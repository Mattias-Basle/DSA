package algorithms.sorting

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class InsertionSortTest {

    private val insertionSort = InsertionSort()

    private val array = arrayOf(4, 5, 1, 2, 3)

    @Test
    fun `sortAsc - should sort the array successfully`() {
        val expected = arrayOf(1, 2, 3, 4, 5)
        val sorted = insertionSort.sortAsc(array)

        assertArrayEquals(expected, sorted)
    }

    @Test
    fun `sortDesc - should sort the array successfully`() {
        val expected = arrayOf(5, 4, 3, 2, 1)
        val sorted = insertionSort.sortDesc(array)

        assertArrayEquals(expected, sorted)
    }
}