import java.util.Arrays;
import java.util.TreeSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 45, 6, 10, 8};
        int target = 50;
        int[][] mat = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int x = 6;
        ArrayQuestions arrays = new ArrayQuestions();
//        arrays.zigZag(arr);
//        arrays.findDuplicates(arr);
        System.out.println(arrays.hasTripletSum(arr,13));
    }
}