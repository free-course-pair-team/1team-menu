package menu.model

class UnFriendlyFoodsBoard {
    private val unFriendlyFoods = mutableMapOf<String, Set<String>>()

    fun setUserUnFriendlyFoods(name: String, passUnFriendlyFoods: Set<String>) {
        unFriendlyFoods.set(name, passUnFriendlyFoods)
    }

    fun getUserUnFriendlyFoods(name: String): Set<String> {
        return unFriendlyFoods.get(name) ?: emptySet()
    }
}
