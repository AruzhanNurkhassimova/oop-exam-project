package System;
 
import java.io.Serializable;
import java.util.Date;
 
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String title;
    private String content;
    private Date createdDate;
 
    public Report(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
    }
 
    public String getTitle() {
        return title;
    }
 
    public String getContent() {
        return content;
    }
 
    public Date getCreatedDate() {
        return createdDate;
    }
 
    public String generate() {
        return title + "\nCreated: " + createdDate + "\n" + content;
    }
 
    @Override
    public String toString() {
        return generate();
    }
}
