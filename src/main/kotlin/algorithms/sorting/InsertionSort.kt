package algorithms.sorting

class InsertionSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        for (outer in 1 until array.size) { //outer element to be added at each iteration
            if (array[outer] > array[outer-1]) continue // if new element already the biggest, move on

            var indexToCompare = outer - 1

            while (indexToCompare >= 0) {
                if (array[indexToCompare] > array[indexToCompare+1]) {
                    swap(array, indexToCompare, indexToCompare + 1)
                }
                indexToCompare--
            }
        }
        return array
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        for (outer in 1 until array.size) { //outer element to be added at each iteration
            if (array[outer] < array[outer-1]) continue // if new element already the smallest, move on

            var indexToCompare = outer - 1

            while (indexToCompare >= 0) {
                if (array[indexToCompare] < array[indexToCompare+1]) {
                    swap(array, indexToCompare, indexToCompare + 1)
                }
                indexToCompare--
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