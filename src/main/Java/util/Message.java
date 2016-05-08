package util;

/**
 * Created by Dotin School1 on 5/8/2016.
 */
public class Message {
    private String key , message;

    public Message(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
