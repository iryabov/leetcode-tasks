/**
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.
 *
 *
 * Input: time = [1,2,3], totalTrips = 5
 * Output: 3
 * Explanation:
 * - At time t = 1, the number of trips completed by each bus are [1,0,0].
 *   The total number of trips completed is 1 + 0 + 0 = 1.
 * - At time t = 2, the number of trips completed by each bus are [2,1,0].
 *   The total number of trips completed is 2 + 1 + 0 = 3.
 * - At time t = 3, the number of trips completed by each bus are [3,1,1].
 *   The total number of trips completed is 3 + 1 + 1 = 5.
 * So the minimum time needed for all buses to complete at least 5 trips is 3.
 */
interface MinimumTimeToCompleteTripsSolution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long
}

class MinimumTimeToCompleteTripsSolution1: MinimumTimeToCompleteTripsSolution {
    override fun minimumTime(time: IntArray, totalTrips: Int): Long {
        val trips = IntArray(time.size)
        var t: Long = 0
        do {
            t++
            for ((idx, it) in time.withIndex()) {
                if ((t % it).toInt() == 0) {
                    trips[idx] += 1
                }
            }
        } while (trips.sum() < totalTrips)
        return t
    }
}

class MinimumTimeToCompleteTripsSolution2: MinimumTimeToCompleteTripsSolution {
    override fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var minTime: Long = totalTrips / time.size * time.min().toLong()
        var maxTime: Long = totalTrips / time.size * time.max().toLong()
        var guessedTime = 0L
        do {
            guessedTime = minTime + (if (maxTime - minTime > 1L) (maxTime - minTime) / 2 else 0)

            var guessedTrips: Long = 0
            for (it in time) {
                guessedTrips += guessedTime / it
            }
            if (guessedTrips < totalTrips)
                minTime = guessedTime + 1
            else if (guessedTrips >= totalTrips)
                maxTime = guessedTime
        } while (minTime < maxTime || guessedTrips < totalTrips)

        return guessedTime
    }
}

class MinimumTimeToCompleteTripsTests(private val solution: MinimumTimeToCompleteTripsSolution) {

    fun test1() {
        val result = solution.minimumTime(intArrayOf(1, 2, 3), 5)
        assertEquals(result, 3L)
    }

    fun test2() {
        val result = solution.minimumTime(intArrayOf(2), 1)
        assertEquals(result, 2L)
    }

    fun test3() {
        val result = solution.minimumTime(intArrayOf(5, 10, 10), 9)
        assertEquals(result, 25L)
    }
}