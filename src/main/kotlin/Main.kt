import java.lang.Exception
import java.util.LinkedHashSet
import kotlin.math.abs

fun main() {
//    val sample = "barfoofoobarthefoobarman"
//    val struct = Trie()
//    struct.insert(sample)
//    //println(struct.search("barman"))
//
//    val index = findSubString(sample, "foobarnnnn")
//    val sample2 = "wordgoodgoodgoodbestword"
//    val index2 = findSubString(sample, "foobarnnnn")
//
//    val word = arrayOf("bar","foo","the")
//    val itz = findCombo(word)
//
//    itz.forEach {
//        print(it?.length)
//        println(findSubString(sample, it!!))
//    }
//
//    val treeItems = arrayOf(3, 5, 2, 1, 4, 6, 7)
//
//    val tree = createBinaryTree(treeItems)
//    println(tree)
//    val d = LinkedHashSet<String>()

    println(findMinSwap(arrayOf(7,1,3,2,4,5,6)))
    println(findMinSwap(arrayOf(1 ,3, 5, 2, 4, 6, 7)))
}


fun findSubString(word: String, subs:String): Int {
    val ch = subs[0]
    val len = subs.length
    val index = -1
    for((i, char) in word.toCharArray().withIndex()){
        if (ch == char){
            if ((i + len) <= word.length){
                val comp = word.subSequence(i, i +len)
                 if(comp == subs){
                     return i
                 }

            }
        }

    }

    return index

}

fun findCombo(words: Array<String>): Array<String?>{
    val unik = mutableSetOf<String>()
    var count = 0

    while (count < words.size){
        if(count +1 < words.size){
            unik.add(words[count] + words[count +1])
        }
        else {
            unik.add(words[count] + words[0])
        }
        count +=1
    }

    return unik.toTypedArray()
}

fun createBinaryTree(items: Array<Int>): BinaryTree {
    val tree = BinaryTree()
    items.forEach {
        tree.add(it)
    }

    return tree
}

fun findClosestValueInBst(tree: Node, target: Int): Int {
    return findClosestValueInBstHelper(tree, target, tree.value)
}

fun findClosestValueInBstHelper(tree: Node, target: Int, cl: Int): Int {
    // Write your code here.
    var closest = cl
    if(abs(target - closest) > abs(target - tree.value)){
        closest = tree.value
    }

    if(target < tree.value && tree.left != null){
        return findClosestValueInBstHelper(tree.left!!, target, closest)
    }
    else if(target > tree.value && tree.right != null){
        return findClosestValueInBstHelper(tree.right!!, target, closest)
    }
    return closest

}

fun findMinSwap(arr: Array<Int>): Int{
    var swaps = 0
    val data = mutableMapOf<Int, Int>()
    for(i in arr.indices){
        data.putIfAbsent(arr[i],  i+1)
    }

    for (i in 1..arr.size ){
        if (data[i] != i){
            data[arr[i -1]] = data[i]!!
            val x = data[i]!! -1
            arr[x]=arr[i-1]
            swaps +=1
        }

    }
    return swaps
}
