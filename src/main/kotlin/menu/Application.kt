package menu

import menu.controller.MenuController
import menu.controller.RandomCategoryGenerator
import menu.controller.RandomMenuGenerator
import menu.model.MenuResult
import menu.util.Validator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    // TODO: 프로그램 구현
    // team2
    val outputView = OutputView()
    val inputView = InputView()
    val validator = Validator()
    val randomCategoryGenerator = RandomCategoryGenerator()
    val randomMenuController = RandomMenuGenerator()
    val menuResult = MenuResult()
    MenuController(outputView, inputView, validator, randomCategoryGenerator, randomMenuController, menuResult).run()
}
