package tcpforward;

import java.io.Serializable;

public class Message implements Serializable {
    private String request_type;
    private String from;
    private String to;
    private String text;

    public Message() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRequest_type( String request_type){ this.request_type=request_type;};

    public String getRequest_type(){ return request_type;}
}