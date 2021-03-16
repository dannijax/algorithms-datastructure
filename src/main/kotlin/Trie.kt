class Trie() {

    private val root = TrieNode( char = Char.MIN_VALUE)

    fun insert(word: String){
        var curr: TrieNode? = root
        for(i in word.toCharArray()){
            if (curr != null) {
                if(curr.children[i - 'a'] == null){
                    curr.children[i - 'a'] = TrieNode(i)
                }
            }
            if (curr != null) {
                curr = curr.children[i -'a']
            }
        }
        curr?.isWord = true
    }

    private fun getNode(word:String): TrieNode?{
        var curr: TrieNode? = root

        curr?.children?.forEachIndexed { index, trieNode ->
            println("$index: ${trieNode?.char}")
        }
        for (item in word.toCharArray()){
            println(curr!!.children[1])
            if (curr!!.children[item - 'a'] == null){
                return null
            }
            curr = curr!!.children[item - 'a']
       }
        return curr
    }

    fun search(word: String): Boolean {
        val node = getNode(word)
        return node != null && node.isWord
    }

    fun startsWith(prefix: String): Boolean{
        return getNode(prefix) != null
    }
}

class TrieNode(val char: Char, var isWord: Boolean = false, var children: Array<TrieNode?> = arrayOfNulls(26)){

    companion object{
        fun createNodes(elements: String): Array<TrieNode?>{
            val trieNodes = arrayOfNulls<TrieNode?>(elements.length)
            for ((k, V) in elements.toCharArray().withIndex()){
                trieNodes[k] = TrieNode(V)
            }
            return trieNodes
        }
    }
}

