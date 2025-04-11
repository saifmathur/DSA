import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Searching {

    public boolean twoPointerSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return true;
            else if (sum < target) {
                left++;
            } else {
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


    int search(int[] arr, int numberToFind) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == numberToFind) return mid;

            if (arr[start] <= arr[mid]) {
                if (numberToFind >= arr[start] && numberToFind < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (numberToFind >= arr[mid] && numberToFind <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    int floorSqrt(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }


    int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1;

            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    ArrayList<Integer> find(int arr[], int x) {
        int first = findFirst(arr, x);
        int last = findLast(arr, x);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }

    int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;

            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }


    public int peakElement(int[] arr) {
        // O(n) & O(1)
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i - 1] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public int peakElementBinarySearch(int[] arr) {
        // O(n) & O(1)
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;
        int n = arr.length - 1;
        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            int left = (mid == 0) ? Integer.MIN_VALUE : arr[mid - 1];
            int right = (mid == arr.length - 1) ? Integer.MIN_VALUE : arr[mid + 1];

            if(arr[mid]>right && arr[mid]>left) return mid;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
