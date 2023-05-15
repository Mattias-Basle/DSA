package algorithms.sorting

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class CycleSortTest {

    private val cycleSort = CycleSort()

    @Test
    fun `should sort array successfully`() {
        val array = arrayOf(3, 5, 2, 1, 4)
        val expected = arrayOf(1, 2, 3, 4, 5)
        val sorted = cycleSort.sort(array)

        assertArrayEquals(expected, sorted)
    }
}