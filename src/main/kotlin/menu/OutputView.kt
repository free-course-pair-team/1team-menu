package menu

class OutputView {
    fun lunchRecommendMessage() = println(LUNCH_RECOMMEND_MESSAGE)
    fun menuRecommendMessage() = println(MENU_RECOMMEND_MESSAGE)
    fun printWeekend() = println(WEEKEND_MESSAGE)
    fun printCategory(foodCategory: List<String>) = println(CATEGORY_MESSAGE.format(foodCategory.joinToString(" | ")))
    fun printFoodByCoaches(coaches: List<Coach>) {
        coaches.forEach { coach ->
            println(FOOD_BY_COACHES.format(coach.name, coach.getRecommendedFoods().joinToString(" | ")))
        }
    }

    fun completeRecommendMessage() = println(COMPLETE_RECOMMEND_MESSAGE)

    companion object {
        private const val LUNCH_RECOMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다."
        private const val MENU_RECOMMEND_MESSAGE = "메뉴 추천 결과입니다."
        private const val WEEKEND_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
        private const val CATEGORY_MESSAGE = "[ 카테고리 | %s ]"
        private const val FOOD_BY_COACHES = "[ %s | %s ]"
        private const val COMPLETE_RECOMMEND_MESSAGE = "\n추천을 완료했습니다."
    }
}
