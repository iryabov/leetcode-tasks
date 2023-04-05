/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

interface KokoEatingBananasSolution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int
}

class KokoEatingBananasSolution1 : KokoEatingBananasSolution {
    override fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val sum: Long = piles.sumOf { it.toLong() }
        val maxK = piles.max()
        val minK = (sum / h + (if (sum % h > 0) 1 else 0)).toInt()
        for (k in minK..maxK) {
            var sumH = 0L
            for (pile in piles) {
                sumH += pile / k + (if (pile % k > 0) 1 else 0)
            }
            if (sumH <= h)
                return k
        }
        return maxK
    }
}


class KokoEatingBananasTests(private val solution: KokoEatingBananasSolution) {
    fun test1() {
        val result = solution.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8)
        assertEquals(result, 4)
    }

    fun test2() {
        val result = solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5)
        assertEquals(result, 30)
    }

    fun test3() {
        val result = solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6)
        assertEquals(result, 23)
    }

    fun test4() {
        val result = solution.minEatingSpeed(
            intArrayOf(
                332484035,
                524908576,
                855865114,
                632922376,
                222257295,
                690155293,
                112677673,
                679580077,
                337406589,
                290818316,
                877337160,
                901728858,
                679284947,
                688210097,
                692137887,
                718203285,
                629455728,
                941802184
            ), 823855818
        )
        assertEquals(result, 14)
    }
}