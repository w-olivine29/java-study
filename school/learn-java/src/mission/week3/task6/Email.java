package mission.week3.task6;

// 41기 유도경
public class Email {

    private String from;
    private String to;
    private String title;
    private String content;

    public Email(String from, String to) {
        this.to = to;
        this.from = from;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
