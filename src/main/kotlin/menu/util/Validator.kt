package menu.util

class Validator {
    fun inputValidatorName(input: String): List<String> {
        require(input.isNotEmpty()) { "이름을 입력해 주십시오" }
        require(input.contains(",")) { " 구분자는 쉼표(,)를 이용해 주세요" }
        val name = input.trim().split(",").map {
            require(it.all { !it.isDigit() }) { "이름은 숫자를 표기할 수 없습니다" }
            it
        }
        return name
    }

    fun inputValidatorFood(input: String): Set<String> {
        var name = mutableListOf<String>()
        if ("," in input) {
            require(input.contains(",")) { " 구분자는 쉼표(,)를 이용해 주세요" }
            name.addAll(input.trim().split(",").map {
                require(it.all { !it.isDigit() }) { "음식은 숫자를 표기할 수 없습니다" }
                it
            })
            require(name.size <= 2) { "기피 음식은 최대 2까지 가능합니다" }
        } else {
            require(input.all { it.isLetter() })
        }

        return name.toSet()
    }
}
