package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputCoachName(): String {
        println(PRINT_INPUT_COACH_NAME)
        return Console.readLine()
    }

    fun inputNotEatMenu(coachName: String): String {
        println(PRINT_INPUT_NOT_EAT_MENU)
        return Console.readLine()
    }


    companion object {
        private const val PRINT_INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val PRINT_INPUT_NOT_EAT_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}