package sbu.cs.multithread.priority;

import java.util.concurrent.CountDownLatch;

public class WhiteThread extends ColorThread {

    private static final String MESSAGE = "hi back blacks, hi back blues";
    private CountDownLatch latchBeforeEnd;

    public WhiteThread(CountDownLatch latchBeforeEnd)
    {
        this.latchBeforeEnd = latchBeforeEnd;
    }

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        printMessage();
        latchBeforeEnd.countDown();
    }
}
