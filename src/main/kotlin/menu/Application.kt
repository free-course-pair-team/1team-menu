package menu

import menu.controller.MenuController
import menu.controller.RandomCategoryGenerator
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    // TODO: 프로그램 구현
    // team2
    val outputView = OutputView()
    val inputView = InputView()
    val validator = Validator()
    val randomMenuGenerator = RandomCategoryGenerator()
    MenuController(outputView,inputView,validator, randomMenuGenerator).run()
}
