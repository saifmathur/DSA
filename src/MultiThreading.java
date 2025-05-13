public class MultiThreading extends Thread{


    private String threadName;
    public MultiThreading(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("From: "+threadName + " -> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
