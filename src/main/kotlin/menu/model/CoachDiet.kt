package menu.model

import menu.util.Random

class CoachDiet(
    private val coach: Coach,
    private val randomGenerator: Random,
) {
    private val diet = mutableListOf<String>()

    fun setCoachDiet(category: Category) {
        var c = randomGenerator.createMenu(category)
        while (checkDuplicateDiet(c)) {
            c = randomGenerator.createMenu(category)
        }
        diet.add(c)
    }


    private fun checkDuplicateDiet(meal: String): Boolean {
        diet.find { it == meal } ?: return false
        return true
    }

    override fun toString(): String {
        // [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
        val sb = StringBuilder()
        sb.append("[ ${coach.getName()}")
        diet.forEach {
            sb.append(" | $it")
        }
        sb.append(" ]")
        return sb.toString()
    }

}