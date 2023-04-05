import java.lang.Integer.max

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

interface LongestSubstringWithoutRepeatingCharactersSolution {
    fun lengthOfLongestSubstring(s: String): Int
}

class LongestSubstringWithoutRepeatingCharactersSolution1 : LongestSubstringWithoutRepeatingCharactersSolution {
    override fun lengthOfLongestSubstring(s: String): Int {
        var substrLen = 0
        val strset = LinkedHashSet<Char>()
        val strarr = ArrayList<Char>()
        for (c in s.toCharArray()) {
            val added = strset.add(c)
            if (added) {
                strarr.add(c)
                substrLen = max(substrLen, strarr.size)
            } else {
                for (i in 0 .. strarr.indexOf(c)) {
                    strset.remove(strarr.removeAt(0))
                }
                strset.add(c)
                strarr.add(c)
            }
        }
        return substrLen
    }
}


class LongestSubstringWithoutRepeatingCharactersTests(private val solution: LongestSubstringWithoutRepeatingCharactersSolution) {
    fun test1() {
        val result = solution.lengthOfLongestSubstring("abcabcbb")
        assertEquals(result, 3)
    }

    fun test2() {
        val result = solution.lengthOfLongestSubstring("bbbbb")
        assertEquals(result, 1)
    }

    fun test3() {
        val result = solution.lengthOfLongestSubstring("pwwkew")
        assertEquals(result, 3)
    }
}