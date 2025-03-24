import java.util.*;

public class ArrayQuestions {

    public int maxSubarraySum(int[] arr) {
        // Your code here KADANE's Algo
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : arr) {
            sum = sum + num;
            maxSoFar = Math.max(maxSoFar, sum); //which is greater it returns that
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(maxSoFar);
        return maxSoFar;
    }

    public boolean matSearch(int[][] mat, int x) {
        int i = 0;
        int j = mat[0].length - 1;
        int numberOfRows = mat.length;
        while (i < numberOfRows && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] < x) {
                i++;
            } else if (mat[i][j] > x) {
                j--;
            }
        }
        return false;
    }

    public void printSpiral(int[][] mat) {
        int len = mat.length * mat[0].length;
        int i = 0, j = 0, turns = 7;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        while (len != 0) {
            System.out.println(mat[i][j]);
            i++;
            j++;
            len--;
        }
    }

    public void printSpiral2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i) {
                res.add(mat[top][i]);
            }
            top++;
            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                res.add(mat[i][right]);
            }
            right--;
            // Print bottom row from right to left (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }
            // Print left column from bottom to top (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    res.add(mat[i][left]);
                }
                left++;
            }
        }
        System.out.println(res);
    }

    public void rotateArr(int arr[], int d) {
        int[] newArr = new int[arr.length];
        Arrays.fill(newArr, 0);
        for (int i = 0; i < arr.length; i++) {
            int newIndex = (i - d + arr.length) % arr.length;
            newArr[newIndex] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));
    }

    public int maxWater(int arr[]) {
        int left = 0;
        if (arr.length == 0) return 0;
        int right = arr.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int trapped = 0;

        while (left <= right) {
            //left boundary is shorter than right
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    trapped = trapped + (leftMax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    trapped = trapped + (rightMax - arr[right]);
                }
                right--;
            }
        }
        return trapped;
    }


    public ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        int start = 0, end = arr.length - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        HashSet<String> seen = new HashSet<>();
        while (start <= end) {
            if (arr[start] + arr[end] == 0 && arr[start] != 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[start]);
                pair.add(arr[end]);
                if (!seen.contains(arr[start] + "," + arr[end])) {
                    res.add(pair);
                    seen.add(arr[start] + "," + arr[end]);
                }
                start++;
                end--;
            } else if (arr[start] + arr[end] < 0) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(res);
        return res;
    }


    public int least_average(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int minSum = windowSum;
        int minIndex = 0;
        for (int i = k; i < n; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            if (windowSum < minSum) {
                minSum = windowSum;
                minIndex = i - k + 1;
            }
        }
        System.out.println(minSum);
        return minIndex + 1;
    }

    public void zigZag(int[] arr) {
        // code here
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public List<Integer> findDuplicates(int[] arr) {
        // code here
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(arr[i])) {
                int count = res.get(arr[i]);
                count++;
                res.put(arr[i], count);
            } else {
                res.put(arr[i], 1);
            }
        }
        return res.keySet().stream().filter(e -> res.get(e) > 1).toList();
    }

    public boolean hasTripletSum(int arr[], int target) {
        Arrays.sort(arr);
        int n = arr.length;
        // Fix the first pointer
        for (int p1 = 0; p1 < n - 2; p1++) {
            int p2 = p1 + 1; // Second pointer
            int p3 = n - 1;  // Third pointer at the end

            while (p2 < p3) {
                int sum = arr[p1] + arr[p2] + arr[p3];

                if (sum == target) {
                    System.out.println("Triplet is: " + arr[p1] + ", " + arr[p2] + ", " + arr[p3]);
                    return true;
                } else if (sum < target) {
                    p2++; // Increase sum
                } else {
                    p3--; // Decrease sum
                }
            }
        }

        return false;
    }

}