package menu.model

class CoachDiet(private val coach: Coach) {
    private val diet = mutableListOf<String>()

    fun addMeal(meal: String) {
        if (!checkDuplicateMeal(meal)) diet.add(meal)
    }

    private fun checkDuplicateMeal(meal: String): Boolean {
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