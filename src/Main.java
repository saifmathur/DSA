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

        Node.TwoPointerNode<Integer> node1 = new Node.TwoPointerNode<>(1);
        Node.TwoPointerNode<Integer> node2 = new Node.TwoPointerNode<>(3);
        Node.TwoPointerNode<Integer> node3 = new Node.TwoPointerNode<>(14);
        Node.TwoPointerNode<Integer> node4 = new Node.TwoPointerNode<>(56);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        node1.setRandom(node3);
        node2.setRandom(node4);
        node3.setRandom(node4);


        LinkedList.cloneLinkedList(node1);

    }


}