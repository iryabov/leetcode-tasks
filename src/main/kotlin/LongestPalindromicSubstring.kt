/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */

interface LongestPalindromicSubstringSolution {
    fun longestPalindrome(s: String): String
}

class LongestPalindromicSubstringSolution1 : LongestPalindromicSubstringSolution {
    override fun longestPalindrome(s: String): String {
        var res = s[0].toString()
        for (i in 0 until s.length - 1) {
            if (res.length > s.length - i)
                break
            for (i2 in s.length - 1 downTo i + 1) {
                if (res.length > i2 - i + 1)
                    break
                if (isPalindromic2(s, i, i2)) {
                    val substring = s.substring(i, i2 + 1)
                    if (res.length < substring.length)
                        res = substring
                    break
                }
            }
        }
        return res
    }

    private fun isPalindromic(s: String, i: Int, i2: Int): Boolean {
        val substring = s.substring(i, i2 + 1)
        return substring.reversed() == substring
    }

    private fun isPalindromic2(s: String, i: Int, i2: Int): Boolean {
        for (k in 0 .. (i2 - i) / 2) {
            if (s[i + k] != s[i2 - k])
                return false
        }
        return true;
    }
}

class LongestPalindromicSubstringSolution2 : LongestPalindromicSubstringSolution {
    override fun longestPalindrome(s: String): String {
        if (s.length < 2)
            return s
        var longest = s.substring(0, 1)
        for (i in 1 until s.length) {
            var palindrome = ""
            if (i + 1 < s.length && s[i - 1] == s[i + 1]) {
                var d = 2
                palindrome = s.substring(i - 1, i + 2)
                while (i - d >= 0 && i + d < s.length && s[i - d] == s[i + d]) {
                    palindrome = s[i - d] + palindrome + s[i + d]
                    d++
                }
            }
            longest = if (palindrome.length > longest.length) palindrome else longest
            if (s[i] == s[i - 1]) {
                var d = 1
                palindrome = s.substring(i - 1, i + 1)
                while (i - 1 - d >= 0 && i + d < s.length && s[i - 1 - d] == s[i + d]) {
                    palindrome = s[i - d - 1] + palindrome + s[i + d]
                    d++
                }
            }
            longest = if (palindrome.length > longest.length) palindrome else longest
        }
        return longest
    }

}

class LongestPalindromicSubstringTests(private val solution: LongestPalindromicSubstringSolution) {
    fun test1() {
        val result = solution.longestPalindrome("babad")
        assertEquals(result, "bab")
    }

    fun test2() {
        val result = solution.longestPalindrome("cbbd")
        assertEquals(result, "bb")
    }

    fun test3() {
        val result = solution.longestPalindrome("a")
        assertEquals(result, "a")
    }

    fun test4() {
        val result = solution.longestPalindrome("aaaa")
        assertEquals(result, "aaaa")
    }

    fun test5() {
        val result = solution.longestPalindrome("ccc")
        assertEquals(result, "ccc")
    }
}
