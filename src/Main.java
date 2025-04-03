import java.util.Arrays;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 45, 6, 10, 8};
        int target = 50;
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int x = 6;
        ArrayQuestions arrays = new ArrayQuestions();
        StringQuestions strings = new StringQuestions();
//        System.out.println(strings.isIPValid("222.111.111.111"));
//        System.out.println(strings.multiplyStrings("123","456"));

//        System.out.println(strings.atoi("4193 with words"));
//        System.out.println(strings.isRotated2("amazon","azonam"));
//        System.out.println(StringQuestions.StringPermutations.getPermutations("ABC"));
//        StringQuestions.StringPermutations.driverGenSubset("ABC");
//            strings.longestRepeatingSubsequence("axxzxy");
//        strings.romanToInt("MCMIV");
//        strings.longestUniqueSubstring("abdefgabef");
//        strings.isRepeat("ababab");
//        System.out.println(strings.lookandsay(5));
//        strings.remAnagrams2("bcadeh","hea");
//            strings.smallestWindow("timetopractice","toc");
        strings.longestUniqueSubstr("abcdefabcbb");
    }


}