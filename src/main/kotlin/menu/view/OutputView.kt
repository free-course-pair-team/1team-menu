package menu.view

class OutputView {

    fun printServiceStart() {
        println(PRINT_SERVICE_MESSAGE)
    }

    fun printResult(coachDietMsg: String) {
        println(coachDietMsg)
    }



    companion object {
        private const val PRINT_SERVICE_MESSAGE = "점심 메뉴 추천을 시작합니다."
    }
}