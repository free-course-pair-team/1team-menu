package menu.controller

import menu.model.Coach
import menu.model.CoachDiet
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
        val weekDietCategory = WeekDietCategory(random)
        val coachDietList = setCoachDietList(coaches, weekDietCategory)
        val coachDietMsg = setFormatResultCoachDietsMsg(weekDietCategory, coachDietList)
        outputView.printResult(coachDietMsg)
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


    private fun setCoachDietList(
        coaches: List<Coach>,
        weekDietCategory: WeekDietCategory,
    ): List<String> {
        val coachDiets = mutableListOf<CoachDiet>()
        coaches.forEach { coachDiets.add(CoachDiet(it, random)) }
        weekDietCategory.getCategories().forEach { category ->
            for (i in coachDiets.indices) {
                coachDiets[i].setCoachDiet(category)
            }
        }
        return coachDiets.map { it.toString() }
    }

    private fun makeCoachDietMsg(coachDiets: List<String>): String {
        val sb = StringBuilder()
        coachDiets.forEach {
            sb.append(it + "\n")
        }
        return sb.toString()
    }

    private fun setFormatResultCoachDietsMsg(
        weekDietCategory: WeekDietCategory,
        coachDietList: List<String>,
    ): String {
        val sb = StringBuilder()
        val weekDietCategoryMsg = weekDietCategory.getCategoryNamesMsg()
        val coachDietMsg = makeCoachDietMsg(coachDietList)
        sb.appendLine(PRINT_RESULT_START_MSG)
        sb.appendLine(PRINT_WEEK_MSG)
        sb.appendLine(weekDietCategoryMsg)
        sb.appendLine(coachDietMsg)
        sb.appendLine(PRINT_COMPLETE_RECOMMEND_MSG)
        return sb.toString()
    }


    companion object {
        private const val PRINT_RESULT_START_MSG = "메뉴 추천 결과입니다."
        private const val PRINT_WEEK_MSG = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val PRINT_COMPLETE_RECOMMEND_MSG = "추천을 완료했습니다."
    }

}