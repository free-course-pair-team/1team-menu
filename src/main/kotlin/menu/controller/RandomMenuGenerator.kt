package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Category

class RandomMenuGenerator {
    private val menuCategory: Map<String, MutableSet<String>> = mapOf(
        Category.JAPAN.foodName to mutableSetOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),
        Category.ASIAN.foodName to mutableSetOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),
        Category.CHINESE.foodName to mutableSetOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),
        Category.KOREAN.foodName to mutableSetOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),
        Category.WESTERN.foodName to mutableSetOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
    )

    fun generatorFood(category: String, passUnFriendlyFoods: Set<String>, selectedFood: Set<String>): String {
        val value = Randoms.shuffle(
            (menuCategory.get(category)?.subtract(passUnFriendlyFoods))?.subtract(selectedFood)?.toList()
        )[0]
//        println(passUnFriendlyFoods)
        println(
            (menuCategory.get(category)?.subtract(passUnFriendlyFoods)?.subtract(selectedFood))
        )
        return value
    }

}

