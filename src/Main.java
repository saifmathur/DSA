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
//        llq.traverse();

        LinkedList<Integer> sort = new LinkedList<>();
        sort.append(3);
        sort.append(4);
        sort.append(2);
        sort.append(6);
        sort.append(7);
        sort.append(8);


        LinkedList<Integer> sort2 = new LinkedList<>();
        sort2.append(1);
        sort2.append(2);
        sort2.append(3);
        sort2.append(4);

        LinkedList.findIntersection(sort.head, sort2.head);

    }


}