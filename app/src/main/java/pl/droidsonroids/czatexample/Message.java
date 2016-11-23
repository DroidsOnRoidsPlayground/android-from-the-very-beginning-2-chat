package pl.droidsonroids.czatexample;

public class Message {

    private String message;
    private boolean isLeft;

    public Message(final String message, final boolean isLeft) {
        this.message = message;
        this.isLeft = isLeft;
    }

    public String getMessage() {
        return message;
    }

    public boolean isLeft() {
        return isLeft;
    }
}
