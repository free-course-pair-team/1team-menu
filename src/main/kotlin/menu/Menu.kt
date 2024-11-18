package menu

class Menu(
    private val inputView: InputView = InputView(),
    private val outputVuew: OutputView = OutputView()
) {

    fun start() {
        outputVuew.lunchRecommendMessage()
        val coaches = inputView.readCoachNames()
        validateCoachesName(coaches)
    }

    private fun validateCoachesName(names: List<String>) {
        require(names.size >= 2 || names.size <= 5) { "[ERROR] 코치는 최소 2명 최대 5명으로 입력해야 합니다." }
        names.forEach { name ->
            require(name.length >= 2 || name.length <= 4) { "[ERROR] 코치 이름은 최소 2 글자 최대 4글자 입력해야 합니다." }
        }
    }
}