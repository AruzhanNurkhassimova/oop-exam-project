package communication;

import Roles.User;
import java.io.Serializable;
import java.util.Date;

public class Comment extends User implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private User author;
	 private String text;
	 private Date createdDate;
	 
	 public Comment(User author, String text) {
		 this.author = author;
		 this.text = text;
		 this.createdDate = new Date();
	 }
	 
	 public User getAuthor() { return author; }
	 public String getText() { return text; }
	 public Date getCreatedDate() { return createdDate;} 

	 public void setText(String text) {
		 this.text = text;
	 }
	 
	 @Override
	 public String toString() {
		 return author.getFullName() + ": " + text;
	 }
}
