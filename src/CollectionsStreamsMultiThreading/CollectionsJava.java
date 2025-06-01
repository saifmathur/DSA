package CollectionsStreamsMultiThreading;

public class CollectionsJava  {



    public void usingArrayList(){
        // Using ArrayList
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("World");
        list.add("world");

        System.out.println("ArrayList: " + list.stream().map(String::toLowerCase).distinct().toList());
    }

    public void usingHashMap(){
        // Using HashMap
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("HashMap: " + map);
    }


    public void usingLinkedList(){
        // Using LinkedList
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.iterator()
                .forEachRemaining(System.out::println);
    }



    public void usingHashSet(){
        // Using HashSet
        //in a hashset, the order of elements is not guaranteed
        // and duplicates are not allowed.
        java.util.HashSet<String> set = new java.util.HashSet<>();
        set.add("Apple");
        set.add("Banana");
        System.out.println("HashSet: " + set);
    }
    public void usingTreeSet(){
        // Using TreeSet
        // A TreeSet is a NavigableSet that uses a Red-Black tree structure.
        // It stores elements in a sorted order and does not allow duplicates.
        // The elements must implement the Comparable interface or a Comparator must be provided.

        // The order of elements is guaranteed to be sorted.
        // A red-black tree is a self-balancing binary search tree.
        java.util.TreeSet<String> treeSet = new java.util.TreeSet<>();
        treeSet.add("Orange");
        treeSet.add("Apple");
        System.out.println("TreeSet: " + treeSet);
    }

    public void usingLinkedHashSet(){
        // Using LinkedHashSet
        // A LinkedHashSet is a HashSet that maintains the insertion order of elements.
        // This does not allow duplicates, but allows null values.

        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>();
        linkedHashSet.add("Red");
        linkedHashSet.add("Green");
        linkedHashSet.add(null);

        System.out.println("LinkedHashSet: " + linkedHashSet);
    }

    public void usingLinkedHashMap(){
        // Using LinkedHashMap
        // A LinkedHashMap is a HashMap that maintains the insertion order of elements.
        // It allows null values and does not allow duplicates.

        java.util.LinkedHashMap<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        linkedHashMap.put("C", 3);

        System.out.println("LinkedHashMap: " + linkedHashMap);
    }

    public void usingStack(){
        // Using Stack
        // A Stack is a last-in-first-out (LIFO) data structure.
        // It allows null values and does not allow duplicates.

        java.util.Stack<String> stack = new java.util.Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack: " + stack);
    }


    public void usingQueue(){
        // Using Queue
        // A Queue is a first-in-first-out (FIFO) data structure.
        // It allows null values and does not allow duplicates.

        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        System.out.println("Queue: " + queue);
    }


    public void usingPriorityQueue(){
        // Using PriorityQueue
        // A PriorityQueue is a queue that orders its elements based on their natural ordering or a specified comparator.
        // It allows null values and does not allow duplicates.

        java.util.PriorityQueue<String> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.add("First");
        priorityQueue.add("fourth");
        priorityQueue.add("Second");

        System.out.println("PriorityQueue: " + priorityQueue);
    }




}



