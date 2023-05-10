package algorithms.searching

import org.junit.Assert.assertEquals
import org.junit.Test

class LinearSearchTest {

    private val linearSearch = LinearSearch()

    @Test
    fun `should return the index successfully`() {
        val list = listOf(1, 2, 3, 4, 5)
        val searchResult = linearSearch.search(list, 3)
        assertEquals(2, searchResult)
    }

    @Test
    fun `should return -1 if target not in array`() {
        val list = listOf(1, 2, 3, 4, 5)
        val searchResult = linearSearch.search(list, 6)
        assertEquals(-1, searchResult)
    }

    @Test
    fun `should return -1 with emptyList`() {
        val list = emptyList<Int>()
        val searchResult = linearSearch.search(list, 6)
        assertEquals(-1, searchResult)
    }

}