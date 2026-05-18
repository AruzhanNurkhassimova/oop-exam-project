public class News implement Serializable {
    private String title;
    private String content;
    private NewsTopic topic;
    private boolean pinned;
    private Date createdDate;
    private List<Comment> comments = new ArrayList<>();

    public News(String title, String content, NewsTopic topic){

    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public NewsTopic getTopic() { return pinned; }
    public Date getCreateDate() { return createdDate; }
    public List<Comment> getComments() { return comments; }

    public void setTitle(String title) {}
    public void setContent(String content) {}
    public void setTopic(NewsTopic topic) {}
    public void pin() {}
    public void unpin() {}
    public void addComment(Comment comment) {}
}