package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {8, 9, 1, 4, 5, 2, 7, 3, 6};

        input = bubbleSort(input);
        for(int i : input)
            System.out.println(i);
    }

    public static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        return arr;
    }
}
