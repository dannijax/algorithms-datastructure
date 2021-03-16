data class Ticket(val start: String, val end: String)


fun findStart(tickets: List<Ticket>): Ticket? {

    val starts = mutableListOf<String>()
    val ends = mutableListOf<String>()
    var ticket: Ticket? = null

    tickets.forEach {
        starts.add(it.start)
        ends.add(it.end)

    }

    val setA = starts.toSet()
    val setB = ends.toSet()
    val union = setA.subtract(setB)
    println(union.size)
    val startPoint = union.elementAt(0)
    println(startPoint)

    tickets.forEach {
        if (it.start == startPoint)
            ticket = it
    }
    return ticket

}

fun findRoute(tickets: List<Ticket>, ticket: Ticket): List<Ticket> {
    val queue = ArrayDeque<Ticket>()
    queue.add(ticket)
    val routes = mutableListOf<Ticket>(ticket)
    routes.add(ticket)
    while (!queue.isEmpty()) {
        val current = queue.removeFirst()
        tickets.forEach {
            if (current != it){
                if (current.end == it.start){
                    routes.add(it)
                    queue.add(it)
                }
                else{
                    queue.add(it)
                }
            }
        }



    }
    return routes
}

fun dfs(tickets: List<Ticket>, start: Ticket, compare: Ticket): Ticket? {
    return if (start.end == compare.start) compare else null
}

fun main() {
    val tickets = listOf(
        Ticket("LAX", "JFK"),
        Ticket("SFO", "LAX"),
        Ticket("YVR", "SFO"),
        Ticket("YYZ", "YVR"),
        Ticket("JFK", "DXB")
    )

    //[YYZ to YVR], [YVR to SFO], [SFO to LAX], [LAX to JFK], [JFK to DXB]
    val sP = findStart(tickets)
    val routes = findRoute(tickets, sP!!)
    println(routes)
}