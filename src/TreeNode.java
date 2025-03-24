import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    T data;
    List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child){
        this.children.add(child);
    }

    public void printTree(String prefix){
        System.out.println(prefix + data);
        for(TreeNode<T> child: children){
            child.printTree(prefix + "--");
        }
    }
}
