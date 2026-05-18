package Communication;

import Enums.RequestStatus;
import Roles.Employee;
import Roles.TechSupportSpecialist; // gotta add
import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private Employee sender;
	 private String description;
	 private RequestStatus status;
	 private Date createdDate;
	 private TechSupportSpecialist assignee;
	 
	 public Request(Employee sender, String description) {
		 this.sender = sender;
		 this.description = description;
		 this.status = RequestStatus.NEW;
		 this.createdDate = new Date();
	 }
	 
	 public Employee getSender() { return sender; }
	 public String getDescription() { return description; }
	 public RequestStatus getStatus() { return status; }
	 public Date getCreatedDate() { return createdDate; }
	 public TechSupportSpecialist getAssignee() { return assignee; }

	 public void setDescription(String description) { this.description = description; }
	 public void setAssignee(TechSupportSpecialist assignee) { this.assignee = assignee; }
	 
	 public void markViewed() { status = RequestStatus.VIEWED; }
	 public void markAccepted() { status = RequestStatus.ACCEPTED; }
	 public void markRejected() { status = RequestStatus.REJECTED; }
	 public void markDone() { status = RequestStatus.DONE; }
	 
	 @Override
	 public String toString() {
		 return "Request{" + description + ", status=" + status + "}";
	 }
}
