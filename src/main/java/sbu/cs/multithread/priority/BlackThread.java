package sbu.cs.multithread.priority;

import java.util.concurrent.CountDownLatch;

public class BlackThread extends ColorThread
{

    private static final String MESSAGE = "hi blues, hi whites";
    private CountDownLatch latchBeforeBlue;

    public BlackThread(CountDownLatch latchBeforeBlue)
    {
        this.latchBeforeBlue = latchBeforeBlue;
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
        latchBeforeBlue.countDown();
    }
}
