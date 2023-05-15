package algorithms.sorting

class BubbleSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        for (outer in 0..array.size-2) { //outer loop to iterate the array as many times as needed
            for (inner in 0 until array.size-2) { //inner loop to compare 2 values at a time for each iteration
                if (array[inner] > array[inner+1])
                    swap(array, inner, inner+1)
            }

        }
        return array
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        for (outer in 0..array.size-2) { //outer loop to iterate the array as many times as needed
            for (inner in 0 until array.size-1) { //inner loop to compare 2 values at a time for each iteration
                if (array[inner] < array[inner+1])
                    swap(array, inner, inner+1)
            }

        }
        return array
    }

    //swapping 2 numbers
    private fun swap(array: Array<Int>, first: Int, second: Int): Array<Int> {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
        return array
    }
}