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
        require(names.size in MIN_COACH_COUNT..MAX_COACH_COUNT) { "[ERROR] 코치는 최소 2명 최대 5명으로 입력해야 합니다." }
        names.forEach { name ->
            require(name.length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH) { "[ERROR] 코치 이름은 최소 2 글자 최대 4글자 입력해야 합니다." }
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
        require(avoidFoods.size >= MIN_AVOID_FOODS_COUNT || avoidFoods.size <= MAX_AVOID_FOODS_COUNT) { "[ERROR] 못 먹는 메뉴는 최소 0개 최대 2개 입력해야 합니다." }
    }

    private fun getWeekFoodRecommend(): List<FoodCategory> {
        val weekFoodRecommend = mutableListOf<FoodCategory>()
        while (weekFoodRecommend.size < MIN_FOOD_RECOMMEND) {
            val recommendFood = category.getRecommendFoodType()
            if (weekFoodRecommend.count { it == recommendFood } < MAX_DUPLICATE_CATEGORY) {
                weekFoodRecommend.add(recommendFood)
            }
        }
        return weekFoodRecommend
    }

    private fun getFoodByCountry(foodCategory: FoodCategory): String {
        return when (foodCategory) {
            JAPANESE_FOOD -> Randoms.shuffle(foodCategory.foods)[SELECTED_FOOD_INDEX]
            KOREAN_FOOD -> Randoms.shuffle(foodCategory.foods)[SELECTED_FOOD_INDEX]
            CHINESE_FOOD -> Randoms.shuffle(foodCategory.foods)[SELECTED_FOOD_INDEX]
            ASIAN_FOOD -> Randoms.shuffle(foodCategory.foods)[SELECTED_FOOD_INDEX]
            WESTERN_FOOD -> Randoms.shuffle(foodCategory.foods)[SELECTED_FOOD_INDEX]
        }
    }

    companion object {
        private const val MIN_AVOID_FOODS_COUNT = 0
        private const val MAX_AVOID_FOODS_COUNT = 2
        private const val MIN_COACH_COUNT = 2
        private const val MAX_COACH_COUNT = 5
        private const val MIN_COACH_NAME_LENGTH = 2
        private const val MAX_COACH_NAME_LENGTH = 4
        private const val MIN_FOOD_RECOMMEND = 5
        private const val MAX_DUPLICATE_CATEGORY = 2
        private const val SELECTED_FOOD_INDEX = 0
    }
}