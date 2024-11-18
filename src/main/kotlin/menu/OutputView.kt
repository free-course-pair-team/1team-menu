package menu

class OutputView {

    fun lunchRecommendMessage() = println("점심 메뉴 추천을 시작합니다.")
    fun menuRecommendMessage() = println("메뉴 추천 결과입니다.")
    fun printWeekend() = println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
    fun printCategory(foodCategory: List<String>) = println("[ 카테고리 | ${foodCategory.joinToString(" | ")} ]")
    fun printFoodByCoaches(coaches: List<Coach>) {
        coaches.forEach { coach ->
            println("[ ${coach.name} | ${coach.getRecommendedFoods().joinToString(" | ")} ]")
        }
    }
    fun completeRecommendMessage() = println("\n추천을 완료했습니다.")
}
