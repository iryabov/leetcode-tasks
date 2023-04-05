/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */

interface RotateImageSolution {
    fun rotate(matrix: Array<IntArray>)
}

class RotateImageSolution1 : RotateImageSolution {
    override fun rotate(matrix: Array<IntArray>) {
        val len = matrix.size
        for (d in 0 until len / 2) {
            for (i in 0 until len - 1 - d * 2) {
                val t = matrix[d][i + d]
                val r = matrix[i + d][len - d - 1]
                val b = matrix[len - d - 1][len - d - i - 1]
                val l = matrix[len - d - i - 1][d]
                matrix[i + d][len - d - 1] = t
                matrix[len - d - 1][len - d - i - 1] = r
                matrix[len - d - i - 1][d] = b
                matrix[d][i + d] = l
            }
        }
    }

}

class RotateImageTests(private val solution: RotateImageSolution) {
    fun test1() {
        val result = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9))
        solution.rotate(result)
        assertEquals(result, arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)))
    }

    fun test2() {
        val result = arrayOf(
                intArrayOf(5, 1, 9, 11),
                intArrayOf(2, 4, 8, 10),
                intArrayOf(13, 3, 6, 7),
                intArrayOf(15, 14, 12, 16)
        )
        solution.rotate(result)
        assertEquals(
            result,
            arrayOf(
                intArrayOf(15, 13, 2, 5),
                intArrayOf(14, 3, 4, 1),
                intArrayOf(12, 6, 8, 9),
                intArrayOf(16, 7, 10, 11)
            )
        )
    }

}
