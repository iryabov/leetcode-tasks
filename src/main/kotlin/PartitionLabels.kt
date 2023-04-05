/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */

interface PartitionLabelsSolution {
    fun partitionLabels(s: String): List<Int>
}

class PartitionLabelsSolution1 : PartitionLabelsSolution {
    override fun partitionLabels(s: String): List<Int> {
        val parts = ArrayList<Int>()
        var end = 1
        var start = 0
        for (i in s.indices) {
            for (j in s.length - 1 downTo end) {
                if (s[i] == s[j]) {
                    end = j + 1
                    break
                }
            }
            if (i == end - 1) {
                parts.add(end - start)
                start = end
                end += 1
                if (end > s.length)
                    break
            }
        }
        return parts
    }

}

class PartitionLabelsTests(private val solution: PartitionLabelsSolution) {
    fun test1() {
        val result = solution.partitionLabels("ababcbacadefegdehijhklij")
        assertEquals(result, listOf(9, 7, 8))
    }

    fun test2() {
        val result = solution.partitionLabels("eccbbbbdec")
        assertEquals(result, listOf(10))
    }

    fun test3() {
        val result = solution.partitionLabels("abcff")
        assertEquals(result, listOf(1, 1, 1, 2))
    }

    fun test4() {
        val result = solution.partitionLabels("eaaaabaaec")
        assertEquals(result, listOf(9, 1))
    }
}