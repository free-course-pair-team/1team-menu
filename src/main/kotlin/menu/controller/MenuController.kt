package menu.controller

import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private fun inputCoachName(): List<String> {
        outputView.printServiceStart()
        return inputView.inputCoachName().split(",")
    }

}