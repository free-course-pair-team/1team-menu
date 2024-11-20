package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCoachNames(): List<String> {
        println(READ_COACH_NAMES_MESSAGE)
        return Console.readLine().split(DELIMITER_COMMA)
    }

    fun readCoachAvoidFoods(name: String): List<String> {
        println(READ_COACH_AVOID_FOODS_MESSAGE.format(name))
        return Console.readLine().split(DELIMITER_COMMA)
    }

    companion object {
        private const val READ_COACH_NAMES_MESSAGE = "\n코치의 이름을 입력해 주세요. (, 로 구분)"
        private const val READ_COACH_AVOID_FOODS_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
        private const val DELIMITER_COMMA = ","
    }
}
