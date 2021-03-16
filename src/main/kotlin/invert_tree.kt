import java.util.*

fun invertTree(node: Node){
    val queue = ArrayDeque<Node>()
    queue.addLast(node)
    while (queue.size > 0){
        val current = queue.pollFirst()
        performSwap(current)
        if (current.left != null) queue.addLast(current.left)
        if (current.right != null) queue.addLast(current.right)

    }
}

fun performSwap(current: Node?) {
    val temp = current?.left
    current?.left = current?.right
    current?.right = temp
}

fun findNearBy(char: Char): Array<Char>{
    if (char == 'a') return arrayOf('b', 'c')
    when(char.toInt()){
        0 -> {
            return arrayOf('b', 'c')
        }
        1 -> {
            return arrayOf('a', 'c')
        }
        2 -> {
            return arrayOf('a', 'b')
        }

    }
    val re = char - 'a'
    if(re < 15){
        if(re %3 ==0){
            return arrayOf((char+ 1), (char +2))
        }
         if (re % 3 ==1){
            return arrayOf((char- 1), (char +1))
        }
        if (re % 3 ==2){
            return arrayOf((char- 2), (char -1))
        }
    }
    else if (re < 19){
        if (re %2 != 0 && re%3 ==0){
            return arrayOf((char +1), (char + 2), (char + 3))
        }
        if (re %2 == 0 && re%3 !=0){
            return arrayOf((char -1), (char + 1), (char + 2))
        }
        if (re %2 == 0 && re%3 !=0){
            return arrayOf((char -1), (char + 1), (char + 2))
        }
        if (re %2 == 0 && re%3 ==0){
            return arrayOf((char -3), (char - 2), (char -1))
        }
    }
//    if ( re % 2 != 0 && re % 3 !=0){
//        return arrayOf((char-1).toChar(), (char+ 1).toChar())
//    }
//    else if (re % 2 == 0 && re % 3 ==0  || (re % 2 != 0 && re % 3 ==0)) return arrayOf((char+ 1).toChar(), (char +2).toChar())
//
//    else  if (re % 2 ==0 && re%3 != 0) return arrayOf(char -2, char -1)
    return emptyArray()
}


fun main() {
    for (i in 'a'..'z'){
        findNearBy(i).forEach {
            println("$i: $it")
        }
    }



}

