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


        //first
        LinkedList<Long> toAdd1 = new LinkedList<>();
        LinkedList<Long> toAdd2 = new LinkedList<>();
        toAdd2.append(3L);
        toAdd2.append(4L);
        toAdd2.append(5L);

        toAdd1.append(4L);
        toAdd1.append(5L);


        Node<Long> addedhead = LinkedList.addTwoLists(toAdd1.head, toAdd2.head);


    }


}