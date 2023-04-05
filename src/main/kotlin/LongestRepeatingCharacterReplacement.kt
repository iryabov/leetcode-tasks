import java.lang.Integer.max

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */

interface LongestRepeatingCharacterReplacementSolution {
    fun characterReplacement(s: String, k: Int): Int
}

class LongestRepeatingCharacterReplacementSolution1: LongestRepeatingCharacterReplacementSolution {
    override fun characterReplacement(s: String, k: Int): Int {
        var start = 0
        var maxCount = 0
        var maxLen = 0
        val count = IntArray(26)
        for (end in s.indices) {
            maxCount = max(maxCount, ++count[s[end] - 'A'])
            while (end - start + 1 - maxCount > k) {
                count[s[start] - 'A']--
                start++
            }
            maxLen = max(maxLen, end - start + 1)
        }
        return maxLen
    }
}

class LongestRepeatingCharacterReplacementTests(private val solution: LongestRepeatingCharacterReplacementSolution) {
    fun test1() {
        val result = solution.characterReplacement("ABAB" ,2)
        assertEquals(result, 4)
    }

    fun test2() {
        val result = solution.characterReplacement("AABABBA" ,1)
        assertEquals(result, 4)
    }
}