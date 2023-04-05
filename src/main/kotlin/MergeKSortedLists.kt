import java.util.*

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        val otherNode = other as ListNode
        return `val` == otherNode.`val` && next == otherNode.next
    }

    override fun toString(): String {
        return `val`.toString() + (if (next != null) ", " + next.toString() else "")
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }
}

fun ListNode.size(): Int {
    var cnt = 1
    var node = this
    while (node.next != null) {
        node = node.next!!
        cnt++
    }
    return cnt
}

fun nodesOf(vararg nodes: Int): ListNode? {
    if (nodes.isEmpty())
        return null
    val node = ListNode(nodes[0])
    var curr: ListNode = node
    for (i in 1 until nodes.size) {
        curr.next = ListNode(nodes[i])
        curr = curr.next!!
    }
    return node
}

interface MergeKSortedListsSolution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode?
}

class MergeKSortedListsSolution1: MergeKSortedListsSolution {
    override fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty())
            return null
        val node = merge(lists)
        val arr = nodeToArray(node)
        mergeSort(arr)
        return arrayToNodes(arr)
    }

    private fun arrayToNodes(arr: IntArray): ListNode? {
        if (arr.isEmpty())
            return null
        val res = ListNode(arr[0])
        var newNode: ListNode = res
        for (i in 1 until arr.size) {
            newNode.next = ListNode(arr[i])
            newNode = newNode.next!!
        }
        return res
    }

    private fun merge(lists: Array<ListNode?>): ListNode? {
        var first: ListNode? = null
        var last: ListNode? = null
        for (node in lists) {
            if (node != null) {
                if (first == null)
                    first = node
                val lastNode = findLastNodeElement(node)
                if (last != null) {
                    last.next = node
                }
                last = lastNode
            }
        }
        return first
    }

    private fun nodeToArray(node: ListNode?): IntArray {
        val list = ArrayList<Int>()
        var cur = node
        while (cur != null) {
            list.add(cur.`val`)
            cur = cur.next
        }
        return list.toIntArray()
    }

    fun findLastNodeElement(node: ListNode?): ListNode? {
        if (node == null)
            return null
        var res = node
        while (res!!.next != null) {
            res = res.next
        }
        return res
    }

    fun mergeSort(arr: IntArray?) {
        if (arr == null || arr.size < 2) {
            return
        }
        val mid = arr.size / 2
        val left = Arrays.copyOfRange(arr, 0, mid)
        val right = Arrays.copyOfRange(arr, mid, arr.size)
        mergeSort(left)
        mergeSort(right)
        merge(arr, left, right)
    }

    private fun merge(arr: IntArray, left: IntArray, right: IntArray) {
        var i = 0
        var j = 0
        var k = 0
        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++]
            } else {
                arr[k++] = right[j++]
            }
        }
        while (i < left.size) {
            arr[k++] = left[i++]
        }
        while (j < right.size) {
            arr[k++] = right[j++]
        }
    }
}

class MergeKSortedListsTests(private val solution: MergeKSortedListsSolution) {
    fun test1() {
        val result = solution.mergeKLists(arrayOf(nodesOf(1, 4, 5), nodesOf(1, 3, 4), nodesOf(2, 6)))
        assertEquals(result, nodesOf(1, 1, 2, 3, 4, 4, 5, 6))
    }

    fun test2() {
        val result = solution.mergeKLists(arrayOf())
        assertEquals(result, nodesOf())
    }

    fun test3() {
        val result = solution.mergeKLists(arrayOf(nodesOf()))
        assertEquals(result, nodesOf())
    }

    fun test4() {
        val result = solution.mergeKLists(arrayOf(nodesOf(), nodesOf(1)))
        assertEquals(result, nodesOf(1))
    }
}