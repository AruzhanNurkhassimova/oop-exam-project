package communication;

import Enums.NewsTopic; // gotta check
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private String title;
	 private String content;
	 private NewsTopic topic;
	 private boolean pinned;
	 private Date createdDate;
	 private List<Comment> comments = new ArrayList<>();
	 
	 public News(String title, String content, NewsTopic topic) {
		 this.title = title;
		 this.content = content;
		 this.topic = topic;
		 this.createdDate = new Date();
		 this.pinned = topic == NewsTopic.RESEARCH;
	 }
	 public String getTitle() { return title; }
	 public String getContent() { return content; }
	 public NewsTopic getTopic() { return topic; }
	 public boolean isPinned() { return pinned; }
	 public Date getCreatedDate() { return createdDate; }
	 public List<Comment> getComments() { return comments; }

	 public void setTitle(String title) { this.title = title; }
	 public void setContent(String content) { this.content = content; }
	 public void setTopic(NewsTopic topic) {
		 this.topic = topic;
		 if (topic == NewsTopic.RESEARCH) {
			 pin();
		 }
	 }
	 
	 public void pin() { pinned = true; }
	 public void unpin() { pinned = false; }
	 
	 public void addComment(Comment comment) {
		 if (comment != null) {
			 comments.add(comment);
		 }
	 }
	 
	 @Override
	 public String toString() {
		 return (pinned ? "[PINNED] " : "") + title + " (" + topic + ")";
	 }
}
