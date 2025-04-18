import java.util.ArrayList;
import java.util.List;

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
        LinkedList<Integer> llq = LinkedList.createIntegerLinkedList(3, 20);
        Searching searching = new Searching();


        System.out.println(searching.medianOf2Optimised(new int[]{-5, 3, 6, 12, 15},new int[]{-12, -10, -6, -3, 4, 10}));
    }


}