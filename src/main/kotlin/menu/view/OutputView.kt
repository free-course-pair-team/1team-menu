package menu.view

import menu.model.CategoryBoard

class OutputView {
    fun menuGuide(){
        println("점심 메뉴 추천을 시작합니다.")
        println("\n코치의 이름을 입력해 주세요. (, 로 구분)")
    }
    fun recommendMenu(categoryBoard: CategoryBoard) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | ${categoryBoard.categories.get(0)} | " +
                "${categoryBoard.categories.get(1)} | " +
                "${categoryBoard.categories.get(2)} | " +
                "${categoryBoard.categories.get(3)} | " +
                "${categoryBoard.categories.get(4)} ]")
    }

}