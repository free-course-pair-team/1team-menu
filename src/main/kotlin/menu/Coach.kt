package menu

data class Coach(val name: String, private val avoidFoods: List<String>) {
    private val recommendedFoods = mutableListOf<String>()
    fun addRecommendedFood(foodName: String) = recommendedFoods.add(foodName)
    fun hasRecommendedFood(foodName: String) = recommendedFoods.contains(foodName)
    fun getRecommendedFoods() = recommendedFoods.toList()
    fun hasAvoidFood(foodName: String) = avoidFoods.contains(foodName)
}
