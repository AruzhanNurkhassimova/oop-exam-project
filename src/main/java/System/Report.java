public class Report implements Serializable {
    private String title;
    private String content;
    private Date createdDate;

    public Report(String title, String content) {}

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreatedDate() { return createdDate; }

    public String generate() {}
}