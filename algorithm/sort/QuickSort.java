package sort;

import util.ArrayUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = {8, 9, 1, 4, 5, 2, 7, 3, 6};

        quickSort(input, 0, input.length - 1);
        ArrayUtils.print(input);
    }

    public static void quickSort(int[] input, int left, int right) {
        int part = partition(input, left, right);
        if (left < part - 1) {
            quickSort(input, left, part - 1);
        }
        if (part < right) {
            quickSort(input, part, right);
        }
    }

    public static int partition(int[] input, int left, int right) {
        int pivot = input[(left + right) / 2];
        while (left <= right) {
            while (input[left] < pivot) {
                left++;
            }
            while (input[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                left++;
                right--;
            }
        }

        return left;
    }
}
