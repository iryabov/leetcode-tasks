/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */

interface MergeIntervalsSolution {
    fun merge(intervals: Array<IntArray>): Array<IntArray>
}

class MergeIntervalsSolution1 : MergeIntervalsSolution {
    override fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = ArrayList<IntArray>()
        var mergedInterval = intArrayOf(intervals[0][0], intervals[0][1])
        result.add(mergedInterval)
        for (i in 0 until intervals.size - 1) {
            val nextInterval = intervals[i + 1]
            if (mergedInterval[1] >= nextInterval[0] && mergedInterval[1] < nextInterval[1])
                mergedInterval[1] = nextInterval[1]
            else if (mergedInterval[1] < nextInterval[0]) {
                mergedInterval = intArrayOf(nextInterval[0], nextInterval[1])
                result.add(mergedInterval)
            }
        }
        return result.toTypedArray()
    }
}

class MergeIntervalsTests(private val solution: MergeIntervalsSolution) {
    fun test1() {
        val result = solution.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
        assertEquals(result, arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
    }

    fun test2() {
        val result = solution.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))
        assertEquals(result, arrayOf(intArrayOf(1, 5)))
    }

    fun test3() {
        val result = solution.merge(
            arrayOf(
                intArrayOf(2, 3),
                intArrayOf(2, 2),
                intArrayOf(3, 3),
                intArrayOf(1, 3),
                intArrayOf(5, 7),
                intArrayOf(2, 2),
                intArrayOf(4, 6)
            )
        )
        assertEquals(result, arrayOf(intArrayOf(1, 3), intArrayOf(4, 7)))
    }
}