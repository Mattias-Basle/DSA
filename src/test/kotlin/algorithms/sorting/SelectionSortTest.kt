package algorithms.sorting

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SelectionSortTest {

    private  val selectionSort = SelectionSort()

    @Test
    fun `should sort array successfully`() {
        val array = arrayOf(4, 5, 1, 2, 3)
        val expected = arrayOf(1, 2, 3, 4, 5)
        val sorted = selectionSort.sort(array)

        assertArrayEquals(expected, sorted)
    }
}