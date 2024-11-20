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
        passNames.forEach { name ->
            val unFriendlyFoods = inputView.getUserUnfriendlyMenus(name)
            val passUnFriendlyFoods = validateFood(unFriendlyFoods)
            val menu = pickMenu(categoryBoard, passUnFriendlyFoods = passUnFriendlyFoods)
            menuResult.addUserMenus(name, menu)
        }

        outputView.printRecommendMenu(categoryBoard)
        outputView.printMenuResult(menuResult)
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

    fun pickMenu(categoryBoard: CategoryBoard, passUnFriendlyFoods: Set<String>): Set<String> {
        var menus = mutableSetOf<String>()
        categoryBoard.categories.forEach { foodCategory ->
            val pickFood = randomMenuGenerator.generatorFood(foodCategory, passUnFriendlyFoods, menus)
            menus.add(pickFood)
        }
        return menus
    }

}
