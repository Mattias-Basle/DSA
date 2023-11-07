package algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountSort {
    //no comparison required
    //useful for sorting small numbers

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2, 5, 2, 8};
        sortHash(arr);
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

    private static void sortHash(int[] arr) {
        // find largest number in array
        int max = 0;
        for (int num: arr) {
            if (num > max) {
                max = num;
            }
        }

        //create hashmap to store values-frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        //count frequencies of values within the original one and complete the map
        for (int i = 0; i <= max; i++) {
            int count = 0;
            for (int num: arr) {
                if (num == i) {
                    count++;
                }
            }
            map.put(i, count);
        }

        // replace values of old array using frequencies from map
        int index = 0;

        for (int i = 0; i <= max; i++) {
            if (map.get(i) != 0) {
                while(map.get(i) != 0) {
                    arr[index] = i;
                    map.put(i, map.get(i)-1);
                    index++;
                }
            }
        }
    }
}
