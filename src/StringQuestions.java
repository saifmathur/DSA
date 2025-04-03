import java.lang.reflect.Type;
import java.util.*;

public class StringQuestions {


    public boolean inIPrange(int num) {
        return num >= 0 && num <= 255;
    }

    public boolean isIPValid(String s) {
        // Write your code here
        String[] splitIp = s.split("\\.");
        if (splitIp.length != 4) return false;
        for (String i : splitIp) {
            if (!inIPrange(Integer.parseInt(i))) return false;
        }
        return true;
    }

    public String multiplyStrings(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) return "0";
        boolean isNegative = (s1.charAt(0) == '-' || s2.charAt(0) == '0');
        s1 = s1.replaceFirst("^-?", "").replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^-?", "").replaceFirst("^0+", "");

        int m = s1.length(), n = s2.length();

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.isEmpty() && num == 0)) {
                sb.append(num);
            }
        }
        return isNegative ? "-" + sb : sb.toString();
    }


    public int atoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0, n = s.length();

        // Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string is empty after removing spaces
        if (i == n) {
            return 0;
        }

        // Handle sign
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }


    public boolean isRotated2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() < 2) {  // Edge case: If string length < 2, rotation doesn't change it
            return s1.equals(s2);
        }

        // Left Rotation by 2 places
        String leftRotated = s1.substring(2) + s1.substring(0, 2);

        // Right Rotation by 2 places
        String rightRotated = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2);
        System.out.println(rightRotated);

        // Check if either rotation matches s2
        return s2.equals(leftRotated) || s2.equals(rightRotated);
    }


    public static class StringPermutations {

        public static List<String> getPermutations(String s) {
            List<String> result = new ArrayList<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars); //sort to get lexicographic order
            boolean[] used = new boolean[chars.length];
            backTrack(result, new StringBuilder(), chars, used);
            return result;
        }

        private static void backTrack(List<String> result, StringBuilder temp, char[] chars, boolean[] used) {
            if (temp.length() == chars.length) {
                result.add(temp.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i]) continue;
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

                used[i] = true;
                temp.append(chars[i]);

                backTrack(result, temp, chars, used);

                used[i] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }

        public static void driverGenSubset(String s) {
            List<String> result = new ArrayList<>();
            generateSubSets(s, 0, "", result);
            System.out.println(result);
        }

        public static void generateSubSets(String s, int index, String current, List<String> result) {
            if (index == s.length()) {
                result.add(current);
                return;
            }
            generateSubSets(s, index + 1, current, result);

            generateSubSets(s, index + 1, current + s.charAt(index), result);

        }

    }

    public int longestRepeatingSubsequence(String s) {
        int n = s.length();
        int[][] dpTable = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((s.charAt(i - 1) == s.charAt(j - 1)) && i != j) {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }
        System.out.println(dpTable[n][n]);
        return dpTable[n][n];

    }


    public Integer romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue < prevValue) {
                sum = sum - currentValue;
            } else {
                sum = sum + currentValue;
            }
            prevValue = currentValue;
        }

        System.out.println(sum);
        return sum;
    }


    int longestUniqueSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int maxLen = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (seen.containsKey(currentChar)) {
                start = Math.max(start, seen.get(currentChar) + 1); //uske aage se start karega
            }
            seen.put(currentChar, end);
            maxLen = Math.max(maxLen, end - start + 1);

        }
        System.out.println(seen);
        System.out.println(maxLen);
        return maxLen;
    }


    public static int isRepeat(String s) {
        String doubled = s + s;  // Create "s + s"
        String trimmed = doubled.substring(1, doubled.length() - 1); // Remove first & last character
        // If 's' is found inside trimmed string, it means s is a repeated pattern
        return trimmed.contains(s) ? 1 : 0;
    }


    public boolean areAnagrams(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        Arrays.sort(s1arr);
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s2arr);
        return Arrays.equals(s1arr, s2arr);

        //O(n) time and O(n) space, optimal and clean but space can still be reduced
    }

    public boolean areAnagrams2(String s1, String s2) {
        //O(n) time and O(1) space
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;

        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    String lookandsay(int n) {
        //your code here
        if (n == 1) return "1";
        String term = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;
            for (int j = 0; j < term.length(); j++) {
                if (j + 1 < term.length() && term.charAt(j) == term.charAt(j + 1)) {
                    count++;
                } else {
                    nextTerm.append(count).append(term.charAt(j));
                    count = 1;

                }
            }
            term = nextTerm.toString();
        }
        return term;
    }


    public int remAnagrams(String s1, String s2) {
        // add code here.
        if (s1.length() <= 1 || s2.length() <= Math.pow(10, 5)) return -1;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] finalArr = new char[s1Arr.length];

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

//        for (int i = 0; i < ; i++) {
//
//        }

        return 0;
    }


    public int remAnagrams2(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            freq2[c - 'a']++;
        }

        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions = deletions + Math.abs(freq1[i] - freq2[i]);
        }
        System.out.println(deletions);
        return deletions;
    }


    public String smallestWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return ""; // No possible window

        // Frequency map for s2
        Map<Character, Integer> s2Map = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> windowMap = new HashMap<>();
        int start = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int matched = 0; // Number of characters matched

        // Expand the window with 'end' and make a string
        for (int end = 0; end < s1.length(); end++) {
            char ch = s1.charAt(end);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (s2Map.containsKey(ch) && windowMap.get(ch).intValue() == s2Map.get(ch).intValue()) {
                matched++;
            }

            // Contract the window from 'start' when all characters match
            while (matched == s2Map.size()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char leftChar = s1.charAt(start);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (s2Map.containsKey(leftChar) && windowMap.get(leftChar) < s2Map.get(leftChar)) {
                    matched--;
                }

                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s1.substring(minStart, minStart + minLength);
    }

    public int longestUniqueSubstr(String s) {
        Set<Character> seen = new HashSet<>();
        String longestSoFar = "";
        StringBuilder strBldr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                strBldr.append(ch);
            } else {
                seen.clear();
                seen.add(ch);
                strBldr = new StringBuilder().append(ch);
            }
            if (longestSoFar.length() < strBldr.length()) {
                longestSoFar = String.valueOf(strBldr);
            }
        }
        System.out.println(longestSoFar + "," + longestSoFar.length());
        return longestSoFar.length();
    }
}
