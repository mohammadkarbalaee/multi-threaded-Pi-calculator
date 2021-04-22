package sbu.cs.multithread.priority;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static List<Message> messages = new ArrayList<>();

    /**
     * add your codes to this function. this function is the caller function which will be called first.
     * changing other codes in this function is allowed.
     *
     * @param blackCount    number of black threads
     * @param blueCount     number of blue threads
     * @param whiteCount    number of white threads
     */
    public void run(int blackCount, int blueCount, int whiteCount) throws InterruptedException {
        List<ColorThread> colorThreads = new ArrayList<>();
        // your codes here

        for (int i = 0; i < blackCount; i++) {
            BlackThread blackThread = new BlackThread();
            colorThreads.add(blackThread);
            blackThread.start();
        }
        for (int i = 0; i < blueCount; i++) {
            BlueThread blueThread = new BlueThread();
            colorThreads.add(blueThread);
            blueThread.start();
        }
        for (int i = 0; i < whiteCount; i++) {
            WhiteThread whiteThread = new WhiteThread();
            colorThreads.add(whiteThread);
            whiteThread.start();
        }
        // your codes here

    }

    synchronized public static void addToList(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
