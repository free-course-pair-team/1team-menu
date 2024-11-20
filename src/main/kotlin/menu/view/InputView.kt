package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputName(): String {
        return Console.readLine()
    }

    fun getUserUnfriendlyMenus(user: String): String {
        println("${user}(이)가 못 먹는 메뉴를 입력해 주세요. (예: 마파두부, 고추잡채)")
        return Console.readLine()
    }

}
