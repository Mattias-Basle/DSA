package algorithms.sorting

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SelectionSortTest {

    private  val selectionSort = SelectionSort()

    @Test
    fun `should sort array successfully`() {
        val array = arrayOf(51, 14, 25, 19, 2, 6, 35, 96)
        val expected = arrayOf(2, 6, 14, 19, 25, 35, 51, 96)
        val sorted = selectionSort.sort(array)

        assertArrayEquals(expected, sorted)
    }
}