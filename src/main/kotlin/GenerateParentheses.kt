/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
interface GenerateParenthesesSolution {
    fun generateParenthesis(n: Int): List<String>
}

class GenerateParenthesesSolution1 : GenerateParenthesesSolution {

    override fun generateParenthesis(n: Int): List<String> {
        return brackets(n)
    }

    private fun brackets(n: Int): List<String> {
        if (n == 0)
            return listOf("")
        val list = ArrayList<String>()
        for (i in n downTo 1) {
            val left = brackets(i - 1)
            val right = brackets(n - i)
            for (l in left) {
                for (r in right) {
                    list.add("($l)$r")
                }
            }
        }
        return list
    }

}

class GenerateParenthesesTests(private val solution: GenerateParenthesesSolution) {
    fun test1() {
        val result = solution.generateParenthesis(2)
        assertEquals(
            result, listOf(
                "(())",
                "()()"
            )
        )
    }

    fun test2() {
        val result = solution.generateParenthesis(3)
        assertEquals(
            result, listOf(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
            )
        )
    }

    fun test3() {
        val result = solution.generateParenthesis(1)
        assertEquals(
            result, listOf(
                "()"
            )
        )
    }

}