package menu.model

import menu.util.Random

data class WeekDietCategory(
    val randomGenerator: Random
) {
    private val category1week: MutableList<Category> = mutableListOf()

    init {
        initCategory1week()
    }

    private fun initCategory1week() {
        while (category1week.count() < WEEK ) {
            addCategory(randomGenerator.createCategory())
        }
    }
    private fun addCategory(category: Category) {
        if (isCanAddCategory(category)) category1week.add(category)
    }

    private fun isCanAddCategory(category: Category): Boolean =
        category1week.count { it == category } < AVAILABLE_DUPLICATED_CATEGORY

    fun getCategories(): List<Category> = category1week.toList()

    fun getCategoryNamesMsg(): String {
        val sb = StringBuilder()
        sb.append("[ $CATEGORY ")
        repeat(WEEK) {
            sb.append("| ${category1week[it].categoryName} ")
        }
        sb.append("]")
        return sb.toString()
    }

    companion object {
        const val WEEK = 5
        const val AVAILABLE_DUPLICATED_CATEGORY = 2
        const val CATEGORY = "카테고리"
    }
}
