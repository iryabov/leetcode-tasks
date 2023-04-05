/**
 * You are given an m x n integer matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */

interface Search2DMatrixSolution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean
}

class Search2DMatrixSolution1 : Search2DMatrixSolution {
    override fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var list: IntArray = matrix[0]
        for (i in 1 until matrix.size) {
            list = list.plus(matrix[i])
        }
        return list.binarySearch(target) > -1
    }

}


class Search2DMatrixTests(private val solution: Search2DMatrixSolution) {
    fun test1() {
        val result = solution.searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ), 3
        )
        assertEquals(result, true)
    }

    fun test2() {
        val result = solution.searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ), 13
        )
        assertEquals(result, false)
    }
}