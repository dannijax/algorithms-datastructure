
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap


var network = mutableMapOf(
    Pair("Min", arrayOf("William", "Jayden", "Omar")),
    Pair("William", arrayOf("Min", "Noam" )),
    Pair("Jayden", arrayOf("Min", "Amelia", "Ren", "Noam" )),
    Pair("Ren", arrayOf("Jayden", "Omar")),
    Pair("Amelia", arrayOf("Jayden", "Adam", "Miguel" )),
    Pair("Adam", arrayOf("Amelia", "Miguel", "Sofia", "Lucas" )),
    Pair("Miguel", arrayOf("Amelia", "Adam", "Liam", "Nathan" )),
    Pair("Noam", arrayOf("Nathan", "Jayden", "William" )),
    Pair("Omar", arrayOf("Ren", "Min", "Scott" ))
)


fun main() {
    val path = findShortestPath(network, "Min", "Adam")
    path?.forEach {
        print(it)
    }
}

fun findShortestPath(graph: MutableMap<String, Array<String>>, startNode: String, endNode: String): Array<String>?{
    val nodestoVisit = ArrayDeque<String>()
    val nodeTracker = mutableMapOf<String, String>()
    nodestoVisit.add(startNode)
    nodeTracker[startNode] = null.toString()


    while (!nodestoVisit.isEmpty()){
        var current = nodestoVisit.removeFirst()
        print("$current -->")
        if (current == endNode){
            return reconstructPath(nodeTracker, startNode, endNode)
        }

        for (neigbour in graph[startNode]!!){
            if (!nodeTracker.contains(neigbour)){
                nodestoVisit.add(neigbour)
                nodeTracker[neigbour] = current

            }

        }

    }
    return null
}

private fun reconstructPath(
    previousNodes: Map<String, String>,
    startNode: String, endNode: String
): Array<String>? {
    val reversedShortestPath: MutableList<String> = ArrayList()

    // start from the end of the path and work backwards
    var currentNode: String? = endNode
    while (currentNode != null) {
        reversedShortestPath.add(currentNode)
        currentNode = previousNodes[currentNode]
    }

    // reverse our path to get the right order
    // by flipping it around, in place
    reversedShortestPath.reverse()
    return reversedShortestPath.toTypedArray()
}