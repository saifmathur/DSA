
public class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext( Node<T> next) {
        this.next = next;
    }


    static class TwoPointerNode<T> {
        T data;
        TwoPointerNode<T> next;
        TwoPointerNode<T> random;

        public TwoPointerNode(T data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }



        public void setData(T data) {
            this.data = data;
        }

        public void setNext(TwoPointerNode<T> next) {
            this.next = next;
        }

        public void setRandom(TwoPointerNode<T> random) {
            this.random = random;
        }

        public T getData() {
            return data;
        }

        public TwoPointerNode<T> getNext() {
            return next;
        }

        public TwoPointerNode<T> getRandom() {
            return random;
        }
    }


}
