package menu

enum class Error(private val message: String) {
    COACH_COUNT("코치는 최소 2명 최대 5명으로 입력해야 합니다."),
    COACH_NAME_LENGTH("코치 이름은 최소 2 글자 최대 4글자 입력해야 합니다."),
    COACH_AVOID_FOOD_COUNT("못 먹는 메뉴는 최소 0개 최대 2개 입력해야 합니다.");

    fun getMessage() = "[ERROR] " + this.message
}