import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    T data;
    TreeNode<T> left = null;
    TreeNode<T> right = null;

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public TreeNode(T data) {
        this.data = data;
    }


    public static TreeNode<Integer> createTree() {
        TreeNode<Integer> head = new TreeNode<>(1);
        TreeNode<Integer> l1 = new TreeNode<>(2);
        TreeNode<Integer> r1 = new TreeNode<>(5);
        TreeNode<Integer> l11 = new TreeNode<>(3);
        TreeNode<Integer> l12 = new TreeNode<>(4);
        TreeNode<Integer> r11 = new TreeNode<>(6);
        head.setLeft(l1);
        head.setRight(r1);
        l1.setLeft(l11);
        l1.setRight(l12);
        r1.setLeft(r11);
        return head;
    }

    public static void preOrderPrint(TreeNode<Integer> head){
        if(head == null) return;
        System.out.println(head.getData());
        preOrderPrint(head.getLeft());
        preOrderPrint(head.getRight());
    }
}
