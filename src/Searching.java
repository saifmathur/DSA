import java.util.*;

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

            if (arr[mid] > right && arr[mid] > left) return mid;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public int missingNumber(int[] arr) {
        // Your code here
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i : arr) {
            if (i > 0) {
                integerMap.put(i, i);
            }
        }
        int result = 1;
        while (integerMap.get(result) != null) {
            result++;
        }

        return result;
    }


    public static int findPages(int[] arr, int k) {


        return 0;
    }


    public static ArrayList<Integer> countEleLessThanOrEqual(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int numberA : a) {
            int count = 0;
            for (int numberB : b) {
                if (numberB <= numberA) {
                    count++;
                }
            }
            res.add(count);
        }
        System.out.println(res);
        return res;
    }

    public static ArrayList<Integer> countEleLessThanOrEqualOptimised(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(b);
        for (int numberA : a) {
            int count = upperBound(b, numberA);
            res.add(count);
        }
        System.out.println(res);
        return res;
    }

    public static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        return low;
    }


    public double medianOf2(int a[], int b[]) {
        // Your Code Here
        int l1 = a.length, l2 = b.length;
        int[] mergedArray = new int[l1 + l2];
        for (int i = 0; i < l1; i++) {
            mergedArray[i] = a[i];
        }
        int j = 0;
        for (int i = l1; i < mergedArray.length; i++) {
            mergedArray[i] = b[j];
            j++;
        }
        Arrays.sort(mergedArray);
        System.out.println(mergedArray[mergedArray.length / 2]);
        return mergedArray[mergedArray.length / 2];
    }

    public double medianOf2Optimised(int a[], int b[]) {
        if (a.length > b.length) {
            return medianOf2Optimised(b, a);
        }
        int x = a.length;
        int y = b.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : a[partitionY - 1];
            int minRightY = (partitionY == x) ? Integer.MAX_VALUE : a[partitionY];

            if (maxLeftY <= minRightY && maxLeftX <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY));
                } else {
                    return (double) Math.max(maxLeftY, maxLeftX);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }

        }
        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}
