package menu.controller

import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val validator: Validator
) {
    fun run(){
        outputView.menuGuide()
        val names = inputView.inputName()
        val passName = validateName(names)
    }
    fun validateName(names: String) : List<String> {
        val nameList = validator.inputValidatorName(names)
        return nameList
    }

}