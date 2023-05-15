package algorithms.sorting


// fastest sorting pattern to solve array range 1 to N
class CycleSort {

    fun sort(array: Array<Int>): Array<Int> {
        for (index in  0 until array.size) {
            while (array[index] != (index + 1)) { // keep swaping values, until the index number and value matches
                swap(array, array[index] -1, index)
            }
        }
        return array
    }

    private fun swap(array: Array<Int>, first: Int, second: Int): Array<Int> {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
        return array
    }
}