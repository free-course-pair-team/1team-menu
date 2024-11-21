package menu.controller

import menu.model.CategoryBoard
import menu.model.MenuResult
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val validator: Validator,
    private val randomCategoryGenerator: RandomCategoryGenerator,
    private val randomMenuGenerator: RandomMenuGenerator,
    private val menuResult: MenuResult
) {
    fun run() {
        outputView.printMenuGuide()
        val categoryBoard = CategoryBoard(categories = generateCategory())
        val names = inputView.inputName()
        val passNames = validateName(names)
        val unFriendlyFoodsBoard = mutableMapOf<String, Set<String>>()
        passNames.forEach { name ->
            val unFriendlyFoods = inputView.getUserUnfriendlyMenus(name)
            val passUnFriendlyFoods = validateFood(unFriendlyFoods)
            unFriendlyFoodsBoard.set(name, passUnFriendlyFoods)

        }
        dailyPickMenu(categoryBoard, passNames, unFriendlyFoodsBoard)
        println(menuResult.getMenuResult())
        outputView.printRecommendMenu(categoryBoard)
        outputView.printMenuResult(menuResult)
    }

    fun dailyPickMenu(
        categoryBoard: CategoryBoard,
        passNames: List<String>,
        passUnFriendlyBoard: MutableMap<String, Set<String>>
    ) {
        val selectedFoodBoard = mutableMapOf<String, MutableSet<String>>()
        if (selectedFoodBoard.isNotEmpty() && passUnFriendlyBoard.isNotEmpty()) {
            //새로운 코드
            categoryBoard.categories.forEach { category ->
                passNames.forEach { name ->
                    val pickedFood = randomMenuGenerator.generatorFood(
                        category,
                        passUnFriendlyBoard.get(name)!!,
                        selectedFoodBoard.get(name)!!
                    )
                    selectedFoodBoard.get(name)?.add(pickedFood)
                    menuResult.addUserMenus(name, pickedFood)
                }
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
