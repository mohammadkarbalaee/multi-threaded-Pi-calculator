package sbu.cs.multithread.priority;

public abstract class ColorThread extends Thread {

    void printMessage(Message message) {
        System.out.printf("[x] %s. thread_name: %s%n", message.toString(), currentThread().getName());
        Runner.addToList(message);
    }

    abstract String getMessage();
}
