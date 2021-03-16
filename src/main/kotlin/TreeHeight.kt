data class BinaryTree(var root: Node?= null){

    private fun addRecursive(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }
        when {
            value < current.value -> {
                current.left = addRecursive(current.left, value)
            }
            value > current.value -> {
                current.right = addRecursive(current.right, value)
            }
            else -> {
                // value already exists
                return current
            }
        }
        return current
    }

    fun add(value: Int) {
        root = addRecursive(root, value)
    }
}