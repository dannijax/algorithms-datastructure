fun hasPair(arr: Array<Int>, target: Int): Array<Int> {
    val comp = mutableSetOf<Int>()
    for (elem in arr){
        if (comp.contains( elem)){
            return arrayOf(elem, target - elem)
        }
        comp.add(target - elem)

    }

    return emptyArray()
}

fun hasPair2(arr: MutableList<Int>, target: Int): List<Int> {
    val comp = mutableSetOf<Int>()
    for (elem in arr){
        if (comp.contains( elem)){
            return listOf(elem, target - elem)
        }
        comp.add(target - elem)

    }

    return emptyList()
}


fun main() {
    val arr = hasPair(arrayOf(3, 5, -4, 8, 11, 1, -1, 6 ), 10)

    arr.forEach {
        print(" $it")
    }
}