package mpes.cesar.school.camera_producer.payload;

public class MessagePayload {

    private String content;

    public MessagePayload() {
    }

    public MessagePayload(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
