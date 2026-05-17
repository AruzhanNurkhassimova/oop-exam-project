public class Comment implements Serializable {
    private User author;
    private String text;
    private Date createdDate;

    public Comment(User author, String text) {}

    public User getAuthor() { return author; }
    public String getText() { return text; }
    public Date getCreatedDate() { return createdDate; }

    public void setText(String text) {}
}