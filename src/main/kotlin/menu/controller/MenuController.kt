package menu.controller

import menu.model.CategoryBoard
import menu.model.UserFoods
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val validator: Validator,
    private val randomMenuGenerator: RandomCategoryGenerator
) {
    fun run(){
        outputView.menuGuide()
        val names = inputView.inputName()
        val passNames = validateName(names)
        passNames.forEach{ name ->
            val unFriendlyFoods = inputView.getUserUnfriendlyMenus(name)
            val passUnFriendlyFoods = validateFood(unFriendlyFoods)
            UserFoods(name = name, unfriendlyFood = passUnFriendlyFoods)
        }

        val categoryBoard = CategoryBoard(categories = generateCategory())
    }

    fun validateName(names: String) : List<String> {
        val nameList = validator.inputValidatorName(names)
        return nameList
    }

    fun validateFood(foods:String):List<String>{
        return validator.inputValidatorFood(foods)
    }

    fun generateCategory():List<String>{
        return randomMenuGenerator.generateRandomCategory()
    }

}
