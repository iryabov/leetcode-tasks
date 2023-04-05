
/**
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

interface AnagramsSolution {
    fun isAnagram(s1: String, s2: String): Boolean
}

class AnagramsSolution1: AnagramsSolution {
    override fun isAnagram(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false

        val l1 = s1.toCharArray().toMutableList()
        val l2 = s2.toCharArray().toMutableList()

        while (l1.size > 0) {
            val char = l1[0]
            val cnt1 = l1.count { it == char }
            val cnt2 = l2.count { it == char }
            if (cnt1 != cnt2)
                return false
            l1.removeAll { it == char }
            l2.removeAll { it == char }
        }
        return true
    }
}

class AnagramsSolution2: AnagramsSolution {
    override fun isAnagram(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false

        val map1 = toMap(s1)
        val map2 = toMap(s2)

        return map1 == map2
    }

    private fun toMap(s1: String): Map<Char, Int> {
        val map = HashMap<Char, Int>()
        for (c in s1) {
            val k = map[c]
            if (k != null)
                map[c] = k + 1
            else
                map[c] = 1
        }
        return map
    }

}

class AnagramsSolution3: AnagramsSolution {
    override fun isAnagram(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        val strArr = s1.toCharArray()
        val pairArr = s2.toCharArray()

        var strValue = 0
        var pairValue = 0

        for (i in strArr.indices) {
            strValue += strArr[i].code
            pairValue += pairArr[i].code
        }

        return strValue == pairValue
    }
}

class ValidAnagramTests(private val solution: AnagramsSolution) {
    fun test1() {
        val result = solution.isAnagram("anagram", "nagaram")
        assertEquals(result, true)
    }

    fun test2() {
        val result = solution.isAnagram("rat", "car")
        assertEquals(result, false)
    }

}
