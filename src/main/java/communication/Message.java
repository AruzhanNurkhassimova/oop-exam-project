package communication;

import Roles.Employee;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private Employee sender;
	 private Employee receiver;
	 private String text;
	 private Date sentDate;
	 private boolean read;
	 
	 public Message(Employee sender, Employee receiver, String text) {
		 this.sender = sender;
		 this.receiver = receiver;
		 this.text = text;
		 this.sentDate = new Date();
		 this.read = false;
	 }
	 
	 public Employee getSender() { return sender; }
	 public Employee getReceiver() { return receiver; }
	 public String getText() { return text; }
	 public Date getSentDate() { return sentDate; }

	 public boolean isRead() { return read; }
	 
	 public void setText(String text) { this.text = text; }
	 
	 public void markAsRead() {
		 read = true;
	 }
	 
	 @Override
	 public String toString() {
		 return "Message from " + sender.getFullName() + " to " + receiver.getFullName() + ": " + text;
	 }
}
