package menu.controller

import menu.model.CategoryBoard
import menu.model.MenuResult
import menu.model.Week
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

        outputView.printRecommendMenu(categoryBoard)
        outputView.printMenuResult(menuResult)
    }

    fun dailyPickMenu(
        categoryBoard: CategoryBoard,
        passNames: List<String>,
        passInFriendlyBoard: MutableMap<String, Set<String>>
    ) {
        //새로운 코드
        categoryBoard.categories.forEach {
            passNames.forEach { name ->
                
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

    fun pickMenu(categoryBoard: CategoryBoard, passUnFriendlyFoods: Set<String>): Map<Int, String> {
        var menus = mutableSetOf<String>()
        var test =
            mutableMapOf<Int, String>(
                Week.MON.index to "",
                Week.THU.index to "",
                Week.WED.index to "",
                Week.TUE.index to "",
                Week.FRI.index to ""
            )
        categoryBoard.categories.forEachIndexed { index, foodCategory ->
            val pickFood = randomMenuGenerator.generatorFood(foodCategory, passUnFriendlyFoods, menus)
            menus.add(pickFood)
            test.set(index, pickFood)
        }


        return test
    }

}
