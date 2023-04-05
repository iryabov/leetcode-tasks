import java.util.Stack

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

interface ValidParenthesesSolution {
    fun isValid(s: String): Boolean
}

class ValidParenthesesSolution1: ValidParenthesesSolution {
    override fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c)
            else {
                if (stack.isEmpty())
                    return false
                val c2 = stack.pop()
                if (c == ')' && c2 != '(')
                    return false
                if (c == '}' && c2 != '{')
                    return false
                if (c == ']' && c2 != '[')
                    return false
            }
        }
        if (!stack.isEmpty())
            return false
        return true
    }

}

class ValidParenthesesTests(private val solution: ValidParenthesesSolution) {
    fun test1() {
        val result = solution.isValid("()")
        assertEquals(result, true)
    }

    fun test2() {
        val result = solution.isValid("()[]{}")
        assertEquals(result, true)
    }

    fun test3() {
        val result = solution.isValid("(]")
        assertEquals(result, false)
    }

    fun test4() {
        val result = solution.isValid("[")
        assertEquals(result, false)
    }

    fun test5() {
        val result = solution.isValid("]")
        assertEquals(result, false)
    }
}