package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {8, 9, 1, 4, 5, 2, 7, 3, 6};

        input = selectionSort(input);
        for(int i : input)
            System.out.println(i);
    }

    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int idx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[idx] >= arr[j])
                    idx = j;
            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }

        return arr;
    }
}
