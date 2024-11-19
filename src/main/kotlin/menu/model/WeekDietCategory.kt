package menu.model

data class WeekDietCategory(
    private val category1week: MutableList<Category> = mutableListOf(),
) {
    fun addCategory(category: Category) {
        if (isCanAddCategory(category)) category1week.add(category)
    }

    private fun isCanAddCategory(category: Category): Boolean =
        category1week.count { it == category } < 2

    fun getCategories(): List<Category> = category1week.toList()
}
