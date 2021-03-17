// Given an array of integers that are sorted and contain repeating numbers,
// find how many times a certain value appears in that array.
// eg. int[] input = {1, 2, 3, 4, 5}; i = 2 --> 1
// eg. int[] input = {7, 8, 12, 12, 12, 14, 21}; i = 12 --> 3
// eg. int[] input = {0, 0, 0, 0, 0}; i = 0 --> 5

fun findOccurrence(arr: Array<Int>, target: Int): Int{
    var count = 0
    for (i in arr.indices){
        if (arr[i] == target){
            count++
            if (arr[i+1] != target){
                return count
            }
        }

    }
    return count
}

fun main() {
    println(findOccurrence(arrayOf(1, 2, 3, 4, 5), 2))
    println(findOccurrence(arrayOf(7, 8, 12, 12, 12, 14, 21), 12))
    println(findOccurrence(arrayOf(0, 0, 0, 0, 0), 5))
}