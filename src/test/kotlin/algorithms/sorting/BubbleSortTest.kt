package algorithms.sorting

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class BubbleSortTest {

    private val bubbleSort = BubbleSort()

    private val array = arrayOf(51, 14, 25, 19, 2, 6, 35, 96)


    @Test
    fun `searchAsc - should sort the array successfully`() {
        val expected = arrayOf(2, 6, 14, 19, 25, 35, 51, 96)
        val sorted = bubbleSort.sortAsc(array)

        assertArrayEquals(expected, sorted)
    }

    @Test
    fun `sortDesc - should sort the array successfully`() {
        val expected = arrayOf(96, 51,35, 25, 19, 14, 6, 2)
        val sorted = bubbleSort.sortDesc(array)

        assertArrayEquals(expected, sorted)
    }
}