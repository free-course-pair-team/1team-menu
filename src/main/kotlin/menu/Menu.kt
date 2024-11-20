package menu

import camp.nextstep.edu.missionutils.Randoms
import menu.FoodCategory.*

class Menu(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val category: Category = Category()
) {
    fun start() {
        outputView.lunchRecommendMessage()
        val coachesName = retryInput {
            val coachesInput = inputView.readCoachNames()
            validateCoachesName(coachesInput)
            coachesInput
        }
        val coaches = getCoaches(coachesName)
        val weekFoodRecommend = getWeekFoodRecommend()
        getRecommendFood(weekFoodRecommend, coaches)
        printRecommendMenu(weekFoodRecommend, coaches)
    }

    private fun printRecommendMenu(
        weekFoodRecommend: List<FoodCategory>,
        coaches: List<Coach>
    ) {
        outputView.menuRecommendMessage()
        outputView.printWeekend()
        outputView.printCategory(weekFoodRecommend.map { it.type })
        outputView.printFoodByCoaches(coaches)
        outputView.completeRecommendMessage()
    }

    private fun getRecommendFood(weekFoodRecommend: List<FoodCategory>, coaches: List<Coach>) {
        weekFoodRecommend.forEach { foodCategory ->
            coaches.forEach { coach ->
                recommendFood(foodCategory, coach)
            }
        }
    }

    private fun recommendFood(foodCategory: FoodCategory, coach: Coach) {
        while (true) {
            val recommendedFood = getFoodByCountry(foodCategory)
            if (!coach.hasRecommendedFood(recommendedFood) && !coach.hasAvoidFood(recommendedFood)) {
                coach.addRecommendedFood(recommendedFood)
                return
            }
        }
    }

    private fun validateCoachesName(names: List<String>) {
        require(names.size in 2..5) { "[ERROR] 코치는 최소 2명 최대 5명으로 입력해야 합니다." }
        names.forEach { name ->
            require(name.length in 2..4) { "[ERROR] 코치 이름은 최소 2 글자 최대 4글자 입력해야 합니다." }
        }
    }

    private fun getCoaches(coachesName: List<String>) = coachesName.map { name ->
        retryInput {
            val avoidFoods = inputView.readCoachAvoidFoods(name)
            validateAvoidFoods(avoidFoods)
            Coach(name, avoidFoods)
        }
    }

    private fun validateAvoidFoods(avoidFoods: List<String>) {
        require(avoidFoods.size >= 0 || avoidFoods.size <= 2) { "[ERROR] 못 먹는 메뉴는 최소 0개 최대 2개 입력해야 합니다." }
    }

    private fun getWeekFoodRecommend(): List<FoodCategory> {
        val weekFoodRecommend = mutableListOf<FoodCategory>()
        while (weekFoodRecommend.size < 5) {
            val recommendFood = category.getRecommendFoodType()
            if (weekFoodRecommend.count { it == recommendFood } < 2) {
                weekFoodRecommend.add(recommendFood)
            }
        }
        return weekFoodRecommend
    }

    private fun getFoodByCountry(foodCategory: FoodCategory): String {
        return when (foodCategory) {
            JAPANESE_FOOD -> Randoms.shuffle(foodCategory.foods)[0]
            KOREAN_FOOD -> Randoms.shuffle(foodCategory.foods)[0]
            CHINESE_FOOD -> Randoms.shuffle(foodCategory.foods)[0]
            ASIAN_FOOD -> Randoms.shuffle(foodCategory.foods)[0]
            WESTERN_FOOD -> Randoms.shuffle(foodCategory.foods)[0]
        }
    }
}
