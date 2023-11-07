package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

public class CountSort {
    //no comparison required
    //useful for sorting small numbers

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2, 5, 2, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        // find largest number in array
        int max = 0;
        for (int num: arr) {
            if (num > max) {
                max = num;
            }
        }

        // create array of size max + 1
        int[] newArray = new int[max+1];

        //count frequencies of indices in new array within the original one
        for (int i = 0; i < newArray.length; i++) {
            int count = 0;
            for (int num: arr) {
                if (num == i) {
                    count++;
                }
            }
            newArray[i] = count;
        }

        // replace values of old array using frequencies from new array
        int index = 0;

        for (int i = 0; i < newArray.length; i++) {
            while (newArray[i] != 0) {
                arr[index] = i;
                newArray[i] = newArray[i] -1;
                index++;
            }
        }
    }
}
