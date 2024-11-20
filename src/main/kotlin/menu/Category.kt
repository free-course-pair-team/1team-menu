package menu

import camp.nextstep.edu.missionutils.Randoms

class Category {
    fun getRecommendFoodType() = selectedFoodCategory(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))

    private fun selectedFoodCategory(randomNumber: Int): FoodCategory {
        when (randomNumber) {
            JAPANESE_FOOD_NUMBER -> return FoodCategory.JAPANESE_FOOD
            KOREAN_FOOD_NUMBER -> return FoodCategory.KOREAN_FOOD
            CHINESE_FOOD_NUMBER -> return FoodCategory.CHINESE_FOOD
            ASIAN_FOOD_NUMBER -> return FoodCategory.ASIAN_FOOD
        }
        return FoodCategory.WESTERN_FOOD
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 1
        private const val MAX_RANDOM_NUMBER = 5
        private const val JAPANESE_FOOD_NUMBER = 1
        private const val KOREAN_FOOD_NUMBER = 2
        private const val CHINESE_FOOD_NUMBER = 3
        private const val ASIAN_FOOD_NUMBER = 4
    }
}
