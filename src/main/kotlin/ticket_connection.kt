// Given a list of airline tickets in random order, sort them such that they connect in order
// eg. Input: [LAX to JFK], [SFO to LAX], [YVR to SFO], [YYZ to YVR], [JFK to DXB]
// Output: [YYZ to YVR], [YVR to SFO], [SFO to LAX], [LAX to JFK], [JFK to DXB]

data class Ticket(val start: String, val end: String)

fun findStart(tickets: List<Ticket>): Ticket? {

    val starts = mutableSetOf<String>()
    val ends = mutableSetOf<String>()
    var ticket: Ticket? = null

    tickets.forEach {
        starts.add(it.start)
        ends.add(it.end)

    }

    val unique = starts.subtract(ends)
    val startPoint = unique.elementAt(0)

    tickets.forEach {
        if (it.start == startPoint)
            ticket = it
    }
    return ticket

}

fun connect_tickets(tickets: List<Ticket>, ticket: Ticket): List<Ticket> {
    val queue = ArrayDeque<Ticket>()
    queue.add(ticket)
    val routes = mutableListOf<Ticket>()
    routes.add(ticket)
    while (!queue.isEmpty()) {
        val current = queue.removeFirst()
        tickets.forEach {
            if (current.end == it.start) {
                if (!routes.contains(it)) {
                    routes.add(it)
                    queue.addLast(it)
                }
            }
        }
    }
    return routes
}

fun main() {
    val tickets = listOf(
        Ticket("LAX", "JFK"),
        Ticket("SFO", "LAX"),
        Ticket("YVR", "SFO"),
        Ticket("YYZ", "YVR"),
        Ticket("JFK", "DXB")
    )

    val sP = findStart(tickets)
    val routes = connect_tickets(tickets, sP!!)
    println(routes)
}