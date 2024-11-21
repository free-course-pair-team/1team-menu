package menu.view

import menu.model.CategoryBoard
import menu.model.MenuResult

class OutputView {
    fun printMenuGuide() {
        println("점심 메뉴 추천을 시작합니다.")
        println("\n코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun printRecommendMenu(categoryBoard: CategoryBoard) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println(
            "[ 카테고리 | ${categoryBoard.categories.get(0)} | " +
                    "${categoryBoard.categories.get(1)} | " +
                    "${categoryBoard.categories.get(2)} | " +
                    "${categoryBoard.categories.get(3)} | " +
                    "${categoryBoard.categories.get(4)} ]"
        )
    }

    fun printMenuResult(menuResult: MenuResult) {
        val menuResult = menuResult.getMenuResult()

        menuResult.entries.forEach { entry ->

            print("[ ${entry.key}")
            entry.value.joinToString(" | ")
            print(" ]\n")
        }
        println("\n추천을 완료했습니다.")
    }
}
