package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,4,8,5,9,7};
        System.out.println(Arrays.toString(arr));
        int[] ans1 = mergeSort1(arr);
        System.out.println(Arrays.toString(ans1));
        mergeSort2(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort1(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort1(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort1(Arrays.copyOfRange(arr, mid, arr.length));

        return merge1(left, right);
    }

    static int[] merge1(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i< first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j< second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    static void mergeSort2(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = (start+end)/2;

        mergeSort2(arr, start,  mid);
        mergeSort2(arr, mid, end);

        merge2(arr, start, mid, end);
    }

    static void merge2(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if(arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i< mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j< end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }
}
