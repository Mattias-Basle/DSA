package algorithms.searching

import org.junit.Assert.assertEquals
import org.junit.Test

class BinarySearchTest {

    private val binarySearch = BinarySearch()

    @Test
    fun `searchAsc - should return the index successfully`() {
        val list = listOf(1, 2, 3, 4, 5)
        val searchResult = binarySearch.searchAsc(list, 3)
        val expected = Pair(2, 3)
        assertEquals(expected, searchResult)
    }

    @Test
    fun `searchAsc - should return -1 if target not in array`() {
        val list = listOf(1, 2, 3, 4, 5)
        val searchResult = binarySearch.searchAsc(list, 6)
        val expected = Pair(-1, 6)
        assertEquals(expected, searchResult)
    }

    @Test
    fun `searchAsc - should return -1 with emptyList`() {
        val list = emptyList<Int>()
        val searchResult = binarySearch.searchAsc(list, 6)
        val expected = Pair(-1, 6)
        assertEquals(expected, searchResult)
    }

    @Test
    fun `searchDesc - should return the index successfully`() {
        val list = listOf(5, 4, 3, 2, 1)
        val searchResult = binarySearch.searchDesc(list, 3)
        val expected = Pair(2, 3)
        assertEquals(expected, searchResult)
    }

    @Test
    fun `searchDesc - should return -1 if target not in array`() {
        val list = listOf(5, 4, 3, 2, 1)
        val searchResult = binarySearch.searchDesc(list, 6)
        val expected = Pair(-1, 6)
        assertEquals(expected, searchResult)
    }

    @Test
    fun `searchDesc - should return -1 with emptyList`() {
        val list = emptyList<Int>()
        val searchResult = binarySearch.searchDesc(list, 6)
        val expected = Pair(-1, 6)
        assertEquals(expected, searchResult)
    }
}