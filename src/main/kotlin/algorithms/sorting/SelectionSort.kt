package algorithms.sorting

class SelectionSort {

    fun sort(array: Array<Int>): Array<Int> {
        for (i in 0 until array.size-1) {
            while (array[i] != (i + 1)) { // keep swaping values, until the index number and value matches
                swap(array, array[i], i)
            }
        }
        return array
    }

    private fun swap(array: Array<Int>, first: Int, second: Int): Array<Int> {
        val temp = array[first-1]
        array[first-1] = array[second]
        array[second] = temp
        return array
    }
}