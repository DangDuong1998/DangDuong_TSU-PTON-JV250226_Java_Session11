package bt03;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    public Message() {
        this.sender = null;
        this.content = null;
        this.timeStamp = null ;
    }

    public Message(String sender, String content, LocalDateTime timeStamp) {
        this.sender = sender;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        do {
            if(sender.isEmpty()){
                System.out.println("Tên không được để trống");
                System.out.print("Nhập tên người gửi: ");
            }else{
                this.sender = sender;
                break;
            }
        }while (true);

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        do {
            if(sender.isEmpty()){
                System.out.println("Tin nhắn không được để trống");
                System.out.print("Nhập nội dung tin nhắn: ");
            }else{
                this.content = content;
                break;
            }
        }while (true);
    }

    public LocalDateTime getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = LocalDateTime.from(LocalDate.now());;
    }
    @Override
    public String toString() {
        return "[" + timeStamp + "] " + sender + ": " + content;
    }
}
