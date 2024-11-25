package menu.controller

import menu.model.CategoryBoard
import menu.model.MenuResult
import menu.model.UnFriendlyFoodsBoard
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val validator: Validator,
    private val randomCategoryGenerator: RandomCategoryGenerator,
    private val randomMenuGenerator: RandomMenuGenerator,
    private val menuResult: MenuResult,
    private val unFriendlyFoodsBoard: UnFriendlyFoodsBoard
) {
    fun run() {
        outputView.printMenuGuide()
        val categoryBoard = CategoryBoard(categories = generateCategory())
        val names = inputView.inputName()
        val passNames = validateName(names)

        addUnfriendlyFood(passNames, unFriendlyFoodsBoard)
        dailyPickMenu(categoryBoard, passNames, unFriendlyFoodsBoard)
        outputView.printRecommendMenu(categoryBoard)
        outputView.printMenuResult(menuResult)
    }

    fun addUnfriendlyFood(passNames: List<String>, unFriendlyFoodsBoard: UnFriendlyFoodsBoard) {
        passNames.forEach { name ->
            val unFriendlyFoods = inputView.getUserUnfriendlyMenus(name)
            val passUnFriendlyFoods = validateFood(unFriendlyFoods)
            unFriendlyFoodsBoard.setUserUnFriendlyFoods(name, passUnFriendlyFoods)
            menuResult.initializeUser(name)
        }
    }

    fun dailyPickMenu(
        categoryBoard: CategoryBoard,
        passNames: List<String>,
        passUnFriendlyBoard: UnFriendlyFoodsBoard
    ) {
        val selectedFoodBoard = mutableMapOf<String, MutableSet<String>>()

        categoryBoard.categories.forEach { category ->
            passNames.forEach { name ->
                val pickedFood = randomMenuGenerator.generatorFood(
                    category,
                    passUnFriendlyBoard.getUserUnFriendlyFoods(name),
                    selectedFoodBoard.get(name) ?: emptySet()
                )
                selectedFoodBoard.get(name)?.add(pickedFood)
                menuResult.addUserMenus(name, pickedFood)
            }
        }
    }

    fun validateName(names: String): List<String> {
        val nameList = validator.inputValidatorName(names)
        return nameList
    }

    fun validateFood(foods: String): Set<String> {
        return validator.inputValidatorFood(foods).toSet()
    }

    fun generateCategory(): List<String> {
        return randomCategoryGenerator.generateRandomCategory()
    }


}
