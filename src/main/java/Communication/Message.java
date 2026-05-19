public class Message implements Serializable {
    private Employee sender;
    private Employee receiver;
    private String text;
    private Date sentDate;
    private boolean read;

    public Message(Employee sender, Employee receiver, String text) {

    }

    public Employee getSender() { return sender; }
    public Employee getReceiver() { return receiver; }
    public String getText() { return text; }
    public Date getSentDate() { return sentDate; }
    public boolean isRead() { return read; }

    public void setText(String text) {}
    public void markAsRead() {}
}