package sort;

import util.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {8, 9, 1, 4, 5, 2, 7, 3, 6};

        mergeSort(input, new int[input.length], 0, input.length - 1);
        ArrayUtils.print(input);
    }

    public static void mergeSort(int[] input, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(input, temp, left, mid);
            mergeSort(input, temp, mid + 1, right);
            merge(input, temp, left, mid, right);
        }
    }

    public static void merge(int[] input, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = input[i];
        }

        int sub1 = left;
        int sub2 = mid + 1;
        int index = left;

        while (sub1 <= mid && sub2 <= right) {
            if (temp[sub1] < temp[sub2]) {
                input[index++] = temp[sub1++];
            } else {
                input[index++] = temp[sub2++];
            }
        }

        for (int i = sub1; i <= mid; i++) {
            input[index++] = temp[i];
        }
    }
}
