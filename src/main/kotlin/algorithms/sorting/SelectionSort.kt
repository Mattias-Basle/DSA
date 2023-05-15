package algorithms.sorting

class SelectionSort {

    fun sort(array: Array<Int>): Array<Int> {
        for (i in 0 until array.size) {
            var lastIndex = array.size -i -1
            var maxValueIndex = getMaxIndex(array, 0, lastIndex)
            swap(array, lastIndex, maxValueIndex)
        }
        return array
    }

    private fun getMaxIndex(array: Array<Int>, start: Int, end: Int): Int {
        var maxIndex = start
        for (i in start..end) {
            if (array[i] > array[maxIndex]) maxIndex = i
        }
        return maxIndex
    }

    private fun swap(array: Array<Int>, first: Int, second: Int): Array<Int> {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
        return array
    }
}