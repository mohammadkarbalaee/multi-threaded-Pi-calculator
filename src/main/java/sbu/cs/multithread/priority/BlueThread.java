package sbu.cs.multithread.priority;

import java.util.concurrent.CountDownLatch;

public class BlueThread extends ColorThread
{

    private static final String MESSAGE = "hi back blacks, hi whites";
    private CountDownLatch latchBeforeWhite;

    public BlueThread(CountDownLatch latchBeforeWhite)
    {
        this.latchBeforeWhite = latchBeforeWhite;
    }

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run()
    {
        printMessage();
        latchBeforeWhite.countDown();
    }
}