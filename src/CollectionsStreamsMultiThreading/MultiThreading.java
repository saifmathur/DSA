package CollectionsStreamsMultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading extends Thread implements Runnable {


    private final String threadName;

    public MultiThreading(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("From: " + threadName + " -> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startThreadByRunnable() {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("From: " + threadName + " -> " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        task.run();
    }

    public void usingExecutorService() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            //tasks
            Runnable task1 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task 1: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            Runnable task2 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Task 2: " + i*2);
                    try {
                        Thread.sleep(i*1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            Runnable task3 = () -> System.out.println("Task 3 is running");

            executorService.submit(task1);
            executorService.submit(task2);
            executorService.submit(task3);

            executorService.shutdown();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
