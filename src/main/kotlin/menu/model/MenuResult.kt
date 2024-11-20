package menu.model

class MenuResult {
    private val menuResult = mutableMapOf<String, Set<String>>()

    fun addUserMenus(name: String, menus: Set<String>) {
        menuResult.put(name, menus)
    }

    fun getMenuResult(): Map<String, Set<String>> {
        return menuResult.toMap()
    }
}
