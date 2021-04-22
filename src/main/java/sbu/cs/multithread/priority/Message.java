package sbu.cs.multithread.priority;

public class Message {

    private final String callerThreadColor;
    private final String message;

    public Message(String callerThreadColor, String message) {
        this.callerThreadColor = callerThreadColor;
        this.message = message;
    }

    public String getCallerThreadColor() {
        return callerThreadColor;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("From %s class: %s", getCallerThreadColor(), getMessage());
    }
}
