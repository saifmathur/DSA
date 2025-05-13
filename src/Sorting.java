import java.util.Arrays;

public class Sorting {

    public String bubbleSort(int[] arr){
        int temp;
        boolean swapped;
        for (int i = 0; i < arr.length-1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return Arrays.toString(arr);
    }


    public int kthSmallest(int[] arr, int k) {
        // Your code here
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxSoFar){
                maxSoFar = arr[i];
            }
        }
        System.out.println(maxSoFar);
        return 0;
    }

}