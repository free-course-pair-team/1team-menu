package menu

import menu.controller.MenuController
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    // TODO: 프로그램 구현
    // team2
    val outputView = OutputView()
    val inputView = InputView()
    val validator = Validator()
    MenuController(outputView,inputView,validator).run()
}
