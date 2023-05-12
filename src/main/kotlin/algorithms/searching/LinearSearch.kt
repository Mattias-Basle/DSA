package algorithms.searching

class LinearSearch {

    //find the list index of a given target using native function
    fun search(list: List<Int>, target: Int): Int = list.indexOf(target)

    //find the list index of a given target
    fun searchFull(list: List<Int>, target: Int): Int {
        for (num in list.indices) {
            if (list[num] == target) {
                return num
            }
        }
        return -1
    }
}