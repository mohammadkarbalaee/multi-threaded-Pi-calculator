package sbu.cs.multithread.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Runner {

    public static List<Message> messages = new ArrayList<>();

    public void run(int blackCount, int blueCount, int whiteCount) throws InterruptedException
    {
        List<ColorThread> colorThreads = new ArrayList<>();

        CountDownLatch latchBeforeBlue = new CountDownLatch(blackCount);
        CountDownLatch latchBeforeWhite = new CountDownLatch(blueCount);
        CountDownLatch latchBeforeEnd = new CountDownLatch(whiteCount);

        for (int i = 0; i < blackCount; i++)
        {
            BlackThread blackThread = new BlackThread(latchBeforeBlue);
            colorThreads.add(blackThread);
            blackThread.start();
        }

        latchBeforeBlue.await();

        for (int i = 0; i < blueCount; i++)
        {
            BlueThread blueThread = new BlueThread(latchBeforeWhite);
            colorThreads.add(blueThread);
            blueThread.start();
        }

        latchBeforeWhite.await();

        for (int i = 0; i < whiteCount; i++)
        {
            WhiteThread whiteThread = new WhiteThread(latchBeforeEnd);
            colorThreads.add(whiteThread);
            whiteThread.start();
        }

        latchBeforeEnd.await();
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
    public static void main(String[] args) throws InterruptedException
    {

    }
}
