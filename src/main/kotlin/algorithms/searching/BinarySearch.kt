package algorithms.searching

class BinarySearch {

    //binary search in sorted list in ascending order
    fun searchAsc(list: List<Int>, target: Int): Pair<Int, Int> {
        var start = 0
        var end = list.size - 1

        while (start < end) {
            var middle = Math.floor((start.toDouble() + end) / 2).toInt()

            //case 1: target is in the middle
            if (list[middle] == target) return Pair(middle, target)

            //case 2: target is greater than middle
            if (list[middle] < target) {
                start = middle + 1
            }

            //case 3: target is less than middle
            if (list[middle] > target) {
                end = middle - 1
            }
        }
        return Pair(-1, target)
    }

    //binary search in sorted list in descending order
    fun searchDesc(list: List<Int>, target: Int): Pair<Int, Int> {
        var start = 0
        var end = list.size - 1

        while (start < end) {
            var middle = Math.floor((start.toDouble() + end) / 2).toInt()

            //case 1: target is in the middle
            if (list[middle] == target) return Pair(middle, target)

            //case 2: target is greater than middle
            if (list[middle] < target) {
                end = middle - 1
            }

            //case 3: target is less than middle
            if (list[middle] > target) {
                start = middle + 1
            }
        }
        return Pair(-1, target)
    }
}