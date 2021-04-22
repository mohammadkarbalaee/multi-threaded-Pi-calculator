package sbu.cs.multithread.semaphor;

public class Source {

    public static void getSource() {
        // some process that is limited to 2 persons concurrently
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
