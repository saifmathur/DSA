import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedList<T> {

    Node<T> head;

    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        newNode.setPrevious(temp);

    }

    public int getSize() {
        int size = 0;
        Node<T> temp = head;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    public void traverse() {
        Node<T> temp = head;
        System.out.println("--- Linked List Start ---");
        while (temp != null) {
            System.out.println("Node data -> " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println("--- Linked List End ---");
    }

    public void reverse() {
        if (head == null || head.getNext() == null) return;

        Node<T> temp = head;
        Node<T> prev = null;

        //traverse to find the end of the list
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        //take the new head
        head = temp;

        //reverse pointers now
        while (temp != null) {
            prev = temp.getPrevious();
            temp.setPrevious(temp.getNext());
            temp.setNext(prev);
            temp = prev;
        }

    }

    static LinkedList<Integer> createIntegerLinkedList(int start, int end) {
        LinkedList<Integer> llq = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            llq.append(i);
        }
        return llq;
    }

    public void segregateIntegers() {
        // code here
        Node<T> temp = head; //this will traverse
        Node<T> evenHead = null; //this will show a new list
        Node<T> evenTail = null;
        Node<T> oddHead = null;
        Node<T> oddTail = null;

        while (temp != null) {
            int data = (int) temp.getData();
            if (data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.setNext(temp);
                    evenTail = temp;
                }
            } else {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.setNext(temp);
                    oddTail = temp;
                }
            }
            temp = temp.getNext();
        }
        if (evenTail != null) {
            evenTail.setNext(oddHead);
        }
        if (oddTail != null) {
            oddTail.setNext(null);
        }
        head = evenHead;
    }


    public void detectLoop() {
        // Add code here
        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(7);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n2);

        //fast loop
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext(); //moving 1 step
            fast = fast.getNext().getNext(); //moving two steps
            //if at any point fast laps then its a cycle
            if (fast == slow) {
                System.out.println("This linked list has a loop");
                break;
            }
        }
    }


    public void deleteAllOccurances(T i) {
        Node<T> tracker1 = head;
        Node<T> tracker2 = head.getNext();

        while (head != null && head.getData().equals(i)) {
            head = head.getNext();
        }

        Node<T> current = head;

        while (current != null && current.getNext() != null) {
            if (current.getNext().getData().equals(i)) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }


    public void removeLoop() {
        // code here
        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(7);
        Node<Integer> n4 = new Node<>(8);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);

        //fast loop
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast == slow) {
                slow = head;
                while (slow.getNext() != fast.getNext()) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                fast.setNext(null);
            }
        }
        Node<Integer> temp = head;
        System.out.println("--- Linked List Start ---");
        while (temp != null) {
            System.out.println("Node data -> " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println("--- Linked List End ---");
    }


    int getKthFromLast(int sizeOfLinkedList, int k) {
        // Your code here
        if (k > sizeOfLinkedList) return -1;
        Node<T> temp = head;
        int len = sizeOfLinkedList - k;
        for (int i = 0; i < len; i++) {
            temp = temp.getNext();
        }
        return (int) temp.getData();
    }


    static LinkedList<Integer> mergeKLists(List<LinkedList<Integer>> arr) {
        // Add your code here.
        Node<Integer> finalHead = arr.get(0).head;
        Node<Integer> temp = finalHead;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        arr.remove(0);
        for (LinkedList<Integer> list : arr) {
            Node<Integer> tempHead = list.head;
            temp.setNext(tempHead);
            while (tempHead.getNext() != null) {
                tempHead = tempHead.getNext();
            }
            temp = tempHead;
        }
        LinkedList<Integer> result = new LinkedList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (finalHead != null) {
            arr2.add(finalHead.getData());
            finalHead = finalHead.getNext();
        }
        for (Integer i : arr2.stream().sorted().toList()) {
            result.append(i);
        }
        return result;
    }


    static void flatten(TreeNode<Integer> root) {
        if (root == null) return;
        flatten(root.getLeft());
        flatten(root.getRight());

        if (root.getLeft() != null) {
            TreeNode<Integer> tempRight = root.getRight();
            root.setRight(root.getLeft());
            root.setLeft(null);

            TreeNode<Integer> rightMost = root.getRight();
            while (rightMost.getRight() != null) {
                rightMost = rightMost.getRight();

            }
            rightMost.setRight(tempRight);
        }
    }

    static Node<Long> addTwoListsMyWay(Node<Long> num1, Node<Long> num2) {
        StringBuilder nums1Sb = new StringBuilder();
        StringBuilder nums2Sb = new StringBuilder();

        while (num1 != null) {
            nums1Sb.append(num1.getData());
            num1 = num1.getNext();
        }
        while (num2 != null) {
            nums2Sb.append(num2.getData());
            num2 = num2.getNext();
        }
        String sum = String.valueOf(
                Long.parseLong(nums1Sb.toString()) + Long.parseLong(nums2Sb.toString())
        );
        LinkedList<Long> sums = new LinkedList<>();
        for (char ch : sum.toCharArray()) {
            sums.append((long) ((int) ch - '0'));
        }

        return sums.head;
    }

    static Node<Integer> addTwoLists(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.getData() : 0;
            int val2 = (l2 != null) ? l2.getData() : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;
            current.setNext(new Node<>(digit));
            current = current.getNext();

            if (l1 != null) l1 = l1.getNext();
            if (l2 != null) l2 = l2.getNext();
        }
        return dummyHead.getNext();
    }

    static boolean isPalindrome(LinkedList<Integer> list) {
        int size = 0;
        //calculate total size
        Node<Integer> sizeCalculatorNode = list.head;
        while (sizeCalculatorNode != null) {
            size++;
            sizeCalculatorNode = sizeCalculatorNode.getNext();
        }
        int halfSize = size / 2;

        Node<Integer> tempFirstHalf = list.head;
        Node<Integer> tempSecondHalf = list.head;
        int count = 0;
        while (count < halfSize) {
            count++;
            tempSecondHalf = tempSecondHalf.getNext();
        }
        Node<Integer> prev = null;
        Node<Integer> current = tempSecondHalf;
        while (current != null) {
            Node<Integer> nextNode = current.getNext();
            current.setNext(prev);
            prev = current;
            current = nextNode;
        }
        tempSecondHalf = prev;
        while (tempSecondHalf != null) {
            if (tempFirstHalf.getData().equals(tempSecondHalf.getData())) {
                tempFirstHalf = tempFirstHalf.getNext();
                tempSecondHalf = tempSecondHalf.getNext();
            } else {
                return false;
            }
        }
        return true;
    }


    static Node.TwoPointerNode<Integer> cloneLinkedList(Node.TwoPointerNode<Integer> head) {
        // code here
        Node.TwoPointerNode<Integer> temp = head;
        Map<Node.TwoPointerNode<Integer>, Node.TwoPointerNode<Integer>> cloneMap = new HashMap<>();
        while (temp != null) {
            Node.TwoPointerNode<Integer> newNode = new Node.TwoPointerNode<>(temp.getData());
            cloneMap.put(temp, newNode);
            temp = temp.getNext();
        }

        temp = head;
        while (temp != null) {
            Node.TwoPointerNode<Integer> cloneNode = cloneMap.get(temp);
            cloneNode.setNext(cloneMap.get(temp.getNext()));
            cloneNode.setRandom(cloneMap.get(temp.getRandom()));
            temp = temp.getNext();
        }
        System.out.println(cloneMap);
        return cloneMap.get(head);
    }


    Node<Integer> segregate(Node<Integer> head) {
        // add your code here
        if (head == null || head.getNext() == null) return head;

        Node<Integer> zeroDummy = new Node<>(-1), zeroTail = zeroDummy;
        Node<Integer> oneDummy = new Node<>(-1), oneTail = oneDummy;
        Node<Integer> twoDummy = new Node<>(-1), twoTail = twoDummy;

        Node<Integer> current = head;
        while (current != null) {
            if (current.getData().equals(0)) {
                zeroTail.setNext(current);
                zeroTail = zeroTail.getNext();
            } else if (current.getData().equals(1)) {
                oneTail.setNext(current);
                oneTail = oneTail.getNext();
            } else {
                twoTail.setNext(current);
                twoTail = twoTail.getNext();
            }
            current = current.getNext();
        }

        twoTail.setNext(null);
        oneTail.setNext(twoDummy.getNext());
        zeroTail.setNext(oneDummy.getNext());

        return zeroDummy.getNext();
    }


    static Node<Integer> findIntersection(Node<Integer> head1, Node<Integer> head2) {
        // add your code here
        Node<Integer> temp = head1;
        Node<Integer> temp2 = head2;
        List<Integer> tempList = new ArrayList<>();
        List<Integer> tempList2 = new ArrayList<>();
        while (temp != null) {
            tempList.add(temp.getData());
            temp = temp.getNext();
        }
        while (temp2 != null) {
            tempList2.add(temp2.getData());
            temp2 = temp2.getNext();
        }
        List<Node<Integer>> common = new ArrayList<>();
        for (Integer i : tempList){
            if(tempList2.contains(i)){
                common.add(new Node<Integer>(i));
            };
        }
        System.out.println(common);
        for (int i = 0; i < common.size()-1; i++) {
            common.get(i).setNext(common.get(i+1));
        }


        return common.get(0);
    }
}
