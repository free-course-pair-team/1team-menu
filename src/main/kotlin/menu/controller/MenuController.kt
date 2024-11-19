package menu.controller

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val coaches = inputCoachName().map { Coach(it) }
        inputNotEatMenu(coaches)
    }

    private fun inputCoachName(): List<String> {
        outputView.printServiceStart()
        return inputView.inputCoachName().split(",")
    }

    private fun inputNotEatMenu(coaches: List<Coach>) {
        coaches.forEach { coach ->
            val hateMenu = inputView.inputNotEatMenu(coach.getName()).split(",")
            coach.setHateMenu(hateMenu)
        }
    }
}