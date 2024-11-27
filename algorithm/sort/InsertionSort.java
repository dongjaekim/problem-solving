package sort;

import util.ArrayUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = {8, 9, 1, 4, 5, 2, 7, 3, 6};

        input = insertionSort(input);
        ArrayUtils.print(input);
    }

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }
}
