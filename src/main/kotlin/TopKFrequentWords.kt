import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 500
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * k is in the range [1, The number of unique words[i]]
 */

interface TopKFrequentWordsSolution {
    fun topKFrequent(words: Array<String>, k: Int): List<String>
}

class TopKFrequentWordsSolution1 : TopKFrequentWordsSolution {
    override fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val result = HashMap<String, Int>()
        for (word in words) {
            result.compute(word) { _, v -> if (v == null) 0 else v + 1 }
        }
        val frequentWords = Comparator<Pair<String, Int>> { o1, o2 -> o1.second.compareTo(o2.second) }
            .reversed().thenComparing { o1, o2 -> o1.first.compareTo(o2.first) }
        return result.toList().sortedWith(frequentWords).take(k).map { it.first }
    }

}

class TopKFrequentWordsSolution2: TopKFrequentWordsSolution {
    override fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = words.groupingBy { it }.eachCount()
        val frequentWords = Comparator<Pair<String, Int>> { o1, o2 -> o1.second.compareTo(o2.second) }
            .reversed().thenComparing { o1, o2 -> o1.first.compareTo(o2.first) }
        return map.toList().sortedWith(frequentWords).take(k).map { it.first }
    }

}

class TopKFrequentWordsTests(private val solution: TopKFrequentWordsSolution) {
    fun test1() {
        val result = solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2)
        assertEquals(result, listOf("i","love"))
    }

    fun test2() {
        val result = solution.topKFrequent(arrayOf("the","day","is","sunny","the","the","the","sunny","is","is"), 4)
        assertEquals(result, listOf("the","is","sunny","day"))
    }
}