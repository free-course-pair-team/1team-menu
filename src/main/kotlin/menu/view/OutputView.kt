package menu.view

class OutputView {

    fun printServiceStart() {
        println(PRINT_SERVICE_MESSAGE)
    }



    companion object {
        const val PRINT_SERVICE_MESSAGE = "점심 메뉴 추천을 시작합니다."
    }
}