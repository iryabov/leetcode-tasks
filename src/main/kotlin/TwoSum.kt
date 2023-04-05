/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */

interface TwoSumSolution {
    fun twoSum(nums: IntArray, target: Int): IntArray
}

class TwoSumSolution1: TwoSumSolution {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        for (a in 0 until nums.size - 1) {
            for (b in a + 1 until nums.size) {
                if (nums[a] + nums[b] == target)
                    return intArrayOf(a, b)
            }
        }
        return intArrayOf(0, 0)
    }
}


class TwoSumSolution2: TwoSumSolution {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (a in nums.indices) {
            if (map.contains(target - nums[a]))
                return intArrayOf(map[target - nums[a]]!!, a)
            map[nums[a]] = a
        }
        return intArrayOf(0, 0)
    }
}

class TwoSumSolution3: TwoSumSolution {
    override fun twoSum(nums: IntArray, target: Int): IntArray {
        val sortedNums = nums.sorted()
        var left = 0
        var right = sortedNums.size - 1
        while (left < right) {
            val sum = sortedNums[left] + sortedNums[right]
            when {
                sum == target -> return intArrayOf(nums.indexOf(sortedNums[left]), nums.lastIndexOf(sortedNums[right]))
                sum < target -> left++
                else -> right--
            }
        }
        return intArrayOf(0, 0)
    }
}

class TwoSumTests(private val solution: TwoSumSolution) {
    fun test1() {
        val result = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
        assertEquals(result, intArrayOf(0, 1))
    }

    fun test2() {
        val result = solution.twoSum(intArrayOf(3, 2, 4), 6)
        assertEquals(result, intArrayOf(1, 2))
    }

    fun test3() {
        val result = solution.twoSum(intArrayOf(3, 3), 6)
        assertEquals(result, intArrayOf(0, 1))
    }
}