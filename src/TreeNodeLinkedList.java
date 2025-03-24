public class TreeNodeLinkedList<T> {

    T data;
    TreeNodeLinkedList<T> left;
    TreeNodeLinkedList<T> right;


    public TreeNodeLinkedList(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNodeLinkedList<T> getLeft() {
        return left;
    }

    public TreeNodeLinkedList<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(TreeNodeLinkedList<T> left) {
        this.left = left;
    }

    public void setRight(TreeNodeLinkedList<T> right) {
        this.right = right;
    }



//    public void printTree(String prefix){
//        System.out.println(prefix + this.getData());
//        if (this.getLeft() != null) {
//            this.getLeft().printTree(prefix + "--");
//        }
//        if (this.getRight() != null) {
//            this.getRight().printTree(prefix + "--");
//        }
//    }


    public void preOrderPrint(String prefix){
        if(this.data != null){
            System.out.println(prefix + this.data);
            if (this.getLeft() != null) {
                this.getLeft().preOrderPrint(prefix + "--");
            }
            if (this.getRight() != null) {
                this.getRight().preOrderPrint(prefix + "--");
            }
        }
    }


    public void postOrderPrint(String prefix){
        if(this.data != null){
            if (this.getLeft() != null) {
                this.getLeft().postOrderPrint(prefix + "--");
            }
            if (this.getRight() != null) {
                this.getRight().postOrderPrint(prefix + "--");
            }
            System.out.println(prefix + this.data);
        }
    }
    public void inOrderPrint(String prefix){
        if(this.data != null){
            if (this.getLeft() != null) {
                this.getLeft().inOrderPrint(prefix + "--");
            }
            System.out.println(prefix + this.data);
            if (this.getRight() != null) {
                this.getRight().inOrderPrint(prefix + "--");
            }
        }
    }


    public static void createAndPrint(){
        TreeNodeLinkedList<Double> root = new TreeNodeLinkedList<>(1.0);
        TreeNodeLinkedList<Double> c1 = new TreeNodeLinkedList<>(1.1);
        TreeNodeLinkedList<Double> c2 = new TreeNodeLinkedList<>(1.2);
        TreeNodeLinkedList<Double> c11 = new TreeNodeLinkedList<>(1.11);
        TreeNodeLinkedList<Double> c12 = new TreeNodeLinkedList<>(1.12);
        TreeNodeLinkedList<Double> c21 = new TreeNodeLinkedList<>(1.21);
        TreeNodeLinkedList<Double> c22 = new TreeNodeLinkedList<>(1.22);


        root.setLeft(c1);
        root.setRight(c2);
        c1.setLeft(c11);
        c1.setRight(c12);
        c2.setLeft(c21);
        c2.setRight(c22);

        System.out.println("------------PreOrder------------");
        root.preOrderPrint("");
        System.out.println("------------PreOrder------------");

        System.out.println("------------PostOrder------------");
        root.postOrderPrint("");
        System.out.println("------------PostOrder------------");
        System.out.println("------------InOrder------------");
        root.inOrderPrint("");
        System.out.println("------------InOrder------------");
    }

}
