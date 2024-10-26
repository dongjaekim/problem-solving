package problems.lv1;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] subArray = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < subArray.length; j++)
                subArray[j] = array[j + commands[i][0] - 1];
            quickSort(subArray, 0, subArray.length - 1);

            answer[i] = subArray[commands[i][2] - 1];
        }

        return answer;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int pivot = arr[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[r] > pivot && l < r) r--;
            while (arr[l] <= pivot && l < r) l++;

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        int temp = arr[left];
        arr[left] = arr[l];
        arr[l] = temp;

        quickSort(arr, 0, l - 1);
        quickSort(arr, l + 1, right);
    }
}
