package menu.util

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category

class Random {

    fun createCategory(): Category {
        val category: Int = Randoms.pickNumberInRange(1, 5) - 1
        return Category.values()[category]
    }

    fun createMenu(category: Category) =
        Randoms.shuffle(category.menu)[0]
}