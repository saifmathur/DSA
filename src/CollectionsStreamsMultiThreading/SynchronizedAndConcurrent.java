package CollectionsStreamsMultiThreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SynchronizedAndConcurrent {

    private List<String> synchronizedList;
    private List<String> concurrentList;


    public SynchronizedAndConcurrent(){
        this.concurrentList = List.of("A", "B", "C");
        this.synchronizedList = List.of("D", "E", "F");

    }

    public List<String> getSynchronizedList() {
        return Collections.synchronizedList(synchronizedList);
    }

    public void testSynchronizedList() {
        // Populate list
        synchronizedList.clear();
        synchronizedList.add("A");
        synchronizedList.add("B");
        synchronizedList.add("C");

        Thread t1 = new Thread(() -> {
            try {
                synchronized (synchronizedList){
                    for (String item : getSynchronizedList()) {
                        Thread.sleep(50);
                        synchronizedList.add("G");
                        System.out.println("T1: " + item);
                    }

                }
            } catch (ConcurrentModificationException e) {
                System.out.println("💥 T1: ConcurrentModificationException occurred!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (synchronizedList){
                    for (String item : getSynchronizedList()) {
                        Thread.sleep(50);
                        synchronizedList.add("H");
                        System.out.println("T2: " + item);
                    }

                }

            } catch (ConcurrentModificationException e) {
                System.out.println("💥 T2: ConcurrentModificationException occurred!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void usingConcurrentHashMap(){
        ConcurrentHashMap<String,Integer> concurrentMap = new ConcurrentHashMap<>();
        Map<String,Integer> normalMap = new HashMap<>();
        normalMap.put("A", 1);
        normalMap.put("B", 2);
        normalMap.put("C", 3);


        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);
        concurrentMap.computeIfAbsent("D", key -> 4);
        System.out.println(concurrentMap);



        Thread t1 = new Thread(()->{
            for (Map.Entry<String, Integer> entry : concurrentMap.entrySet()) {
                try {
                    Thread.sleep(50);
                    System.out.println("T1: " + entry.getKey() + " = " + entry.getValue());
                    concurrentMap.put(entry.getKey(), entry.getValue() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (Map.Entry<String, Integer> entry : concurrentMap.entrySet()) {
                try {
                    Thread.sleep(50);
                    System.out.println("T2: " + entry.getKey() + " = " + entry.getValue());
                    concurrentMap.put(entry.getKey(), entry.getValue() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t3 = new Thread(()->{
            for (Map.Entry<String, Integer> entry : normalMap.entrySet()) {
                try {
                    Thread.sleep(50);
                    System.out.println("T3: " + entry.getKey() + " = " + entry.getValue());
                    normalMap.put(entry.getKey(), entry.getValue() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t4 = new Thread(()->{
            for (Map.Entry<String, Integer> entry : normalMap.entrySet()) {
                try {
                    Thread.sleep(50);
                    System.out.println("T4: " + entry.getKey() + " = " + entry.getValue());
                    normalMap.put(entry.getKey(), entry.getValue() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t5 = new Thread(()->{
            for (Map.Entry<String, Integer> entry : normalMap.entrySet()) {
                try {
                    Thread.sleep(50);
                    System.out.println("T5: " + entry.getKey() + " = " + entry.getValue());
                    normalMap.remove("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();

            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
