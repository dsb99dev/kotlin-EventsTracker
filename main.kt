fun main() {

    // hard coded events by team members
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    
    // store events in a mutable list
    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

    // print events
    events.forEach {
        println(it.durationOfEvent)
    }

    // create list of short events (events which last less than 60 minutes)
    val shortEvents = events.filter { it.durationInMinutes < 60 }

    // group events by daypart (morning, afternoon and evening)
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    println(
        "Last event of the day : ${events.last().title}"
    )
}

// define Daypart class (stores constant values - immutable)
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

// holds the details of the event entered by the user
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// add durationOfEvent property to Event class
// without modifying Event class directly
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }
