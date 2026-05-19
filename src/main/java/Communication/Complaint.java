
package Communication;

import Enums.UrgencyLevel; // gotta check
import Roles.Student;
import Roles.Teacher;
import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private Teacher sender;
	 private Student student;
	 private UrgencyLevel urgency;
	 private String text;
	 private Date date;
	 
	 public Complaint(Teacher sender, Student student, UrgencyLevel urgency, String text) {
		 this.sender = sender;
		 this.student = student;
		 this.urgency = urgency;
		 this.text = text;
		 this.date = new Date();
	 }
	 public Teacher getSender() { return sender; }
	 public Student getStudent() { return student; }
	 public UrgencyLevel getUrgency() { return urgency; }
	 public String getText() { return text; }
	 public Date getDate() { return date; }

	 public void setUrgency(UrgencyLevel urgency) { this.urgency = urgency; }
	 public void setText(String text) { this.text = text; }	
	 
	 public boolean send() {
		 System.out.println("Complaint sent to dean: " + this);
		 return true;
	 }
	 
	 @Override
	 public String toString() {
		 return "Complaint{teacher=" + sender.getFullName() +
		 ", student=" + student.getFullName() +
		 ", urgency=" + urgency +
		 ", text='" + text + "'}";
	 }
}
