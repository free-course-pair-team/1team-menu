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
        val coachesName = getCoachesName()
        val coaches = getCoaches(coachesName)
        val weekFoodCategory = getWeekFoodCategory()
        getRecommendFood(weekFoodCategory, coaches)
        printRecommendMenu(weekFoodCategory, coaches)
    }

    private fun getCoachesName() = retryInput {
        val coachesInput = inputView.readCoachNames()
        validateCoachesName(coachesInput)
        coachesInput
    }

    private fun printRecommendMenu(
        weekFoodCategory: List<FoodCategory>, coaches: List<Coach>
    ) {
        outputView.menuRecommendMessage()
        outputView.printWeekend()
        outputView.printCategory(weekFoodCategory.map { it.type })
        outputView.printFoodByCoaches(coaches)
        outputView.completeRecommendMessage()
    }

    private fun getRecommendFood(weekFoodCategory: List<FoodCategory>, coaches: List<Coach>) {
        weekFoodCategory.forEach { foodCategory ->
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
        require(names.size in MIN_COACH_COUNT..MAX_COACH_COUNT) { Error.COACH_COUNT.getMessage() }
        names.forEach { name ->
            require(name.length in MIN_COACH_NAME_LENGTH..MAX_COACH_NAME_LENGTH) { Error.COACH_NAME_LENGTH.getMessage() }
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
        require(avoidFoods.size in MIN_AVOID_FOODS_COUNT..MAX_AVOID_FOODS_COUNT) { Error.COACH_AVOID_FOOD_COUNT.getMessage() }
    }

    private fun getWeekFoodCategory(): List<FoodCategory> {
        val weekFoodCategory = mutableListOf<FoodCategory>()
        while (weekFoodCategory.size < MIN_FOOD_CATEGORY) {
            val recommendFood = category.getRecommendFoodCategory()
            if (isMaxDuplicate(weekFoodCategory, recommendFood)) weekFoodCategory.add(recommendFood)
        }
        return weekFoodCategory
    }

    private fun isMaxDuplicate(weekFoodRecommend: List<FoodCategory>, recommendFood: FoodCategory) =
        weekFoodRecommend.count { it == recommendFood } < MAX_DUPLICATE_CATEGORY

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
        private const val MIN_FOOD_CATEGORY = 5
        private const val MAX_DUPLICATE_CATEGORY = 2
        private const val SELECTED_FOOD_INDEX = 0
    }
}