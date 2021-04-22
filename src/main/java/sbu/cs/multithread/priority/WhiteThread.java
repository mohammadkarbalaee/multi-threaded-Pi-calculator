package sbu.cs.multithread.priority;

public class WhiteThread extends ColorThread {

    private static final String MESSAGE = "hi back blacks, hi back blues";

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        // call printMessage
    }
}
