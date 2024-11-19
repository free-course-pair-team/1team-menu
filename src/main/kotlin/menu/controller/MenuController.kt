package menu.controller

import menu.model.Category
import menu.model.Coach
import menu.model.WeekDietCategory
import menu.util.Random
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val random = Random()

    fun run() {
        val coaches = inputCoachName().map { Coach(it) }
        inputNotEatMenu(coaches)
        WeekDietCategory(random)
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

    private fun recommendMenu(category: Category): String {
        return random.createMenu(category)
    }



}