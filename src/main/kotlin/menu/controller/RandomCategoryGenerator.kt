package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category

class RandomCategoryGenerator {
    val category = listOf("",Category.JAPAN.foodName, Category.KOREAN.foodName, Category.CHINESE.foodName, Category.ASIAN.foodName, Category.WESTERN.foodName)

    fun generateRandomCategory():List<String>{
        val result = mutableListOf<String>()
        while (result.size < 5) {
            val value = category.get(Randoms.pickNumberInRange(1, 5))
            if (result.count { it == value } < 3) {
                result.add(value)
            }
        }
        return result
    }
}
