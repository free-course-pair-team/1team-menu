package menu

import camp.nextstep.edu.missionutils.Randoms

class Category {
    fun getRecommendFoodType() = FoodCategory.values()[Randoms.pickNumberInRange(1, 5) - 1]

}
