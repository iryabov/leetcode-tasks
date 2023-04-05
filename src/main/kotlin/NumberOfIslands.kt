/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

interface NumberOfIslandsSolution {
    fun numIslands(grid: Array<CharArray>): Int
}

class NumberOfIslandsSolution1 : NumberOfIslandsSolution {
    private var rows = 0
    private var cols = 0

    override fun numIslands(grid: Array<CharArray>): Int {
        rows = grid.size
        cols = grid[0].size
        var count = 0
        for (c in 0 until cols) {
            for (r in 0 until rows) {
                if (grid[r][c] == '1')
                    count++
                discover(r, c, grid)
            }
        }
        return count
    }

    private fun discover(r: Int, c: Int, grid: Array<CharArray>) {
        if (r < 0 || r >= rows)
            return
        if (c < 0 || c >= cols)
            return
        if (grid[r][c] != '1')
            return
        if (grid[r][c] == '1')
            grid[r][c] = 'X'
        discover(r + 1, c, grid)
        discover(r, c + 1, grid)
        discover(r - 1, c, grid)
        discover(r, c - 1, grid)
    }

}

class NumberOfIslandsTests(private val solution: NumberOfIslandsSolution) {
    fun test1() {
        val result = solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
        assertEquals(result, 1)
    }

    fun test2() {
        val result = solution.numIslands(
            arrayOf(
                charArrayOf('1','1','0','0','0'),
                charArrayOf('1','1','0','0','0'),
                charArrayOf('0','0','1','0','0'),
                charArrayOf('0','0','0','1','1')
            )
        )
        assertEquals(result, 3)
    }
}