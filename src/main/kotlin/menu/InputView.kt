package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCoachNames(): List<String> {
        println("\n코치의 이름을 입력해 주세요. (, 로 구분)")
        return Console.readLine().split(",")
    }

    fun readCoachAvoidFoods(name: String): List<String> {
        println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        return Console.readLine().split(",")
    }

//    fun read
}
