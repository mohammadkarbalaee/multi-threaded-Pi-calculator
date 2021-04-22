package sbu.cs.multithread.priority;

public class BlackThread extends ColorThread {

    private static final String MESSAGE = "hi blues, hi whites";

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
