package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dotin School1 on 5/8/2016.
 */
public class MessageBundle {
    private List<Message> messages;

    public MessageBundle() {
        messages = new ArrayList<Message>();
    }

    public void addError(Message message) {
        messages.add(message);
    }

    public boolean isValid(){
        return messages.size() == 0;
    }

    public void addError(String key , String message){
        messages.add(new Message(key , message));
    }

    public List<Message> getMessages(){
        return messages;
    }
}
