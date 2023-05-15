package algorithms.sorting


// fastest sorting pattern to solve array range 1 to N
class CycleSort {

    fun sort(array: Array<Int>): Array<Int> {
        var index = 0
        while (index < array.size) {
            val correctIndex = array[index] - 1
            if (array[index] != array[correctIndex]) {
                swap(array, index, correctIndex)
            } else index++
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