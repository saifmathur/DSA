import java.util.Arrays;

public class Searching {

    public boolean twoPointerSum(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        while (left<right){
            int sum = arr[left]+arr[right];
            if(sum == target) return true;
            else if(sum <  target){
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                System.out.println("Found at " + mid + " : " + arr[mid]);
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1; //shift low to mid, since only second half needs to be searched
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Not found");
        return -1;
    }
}
