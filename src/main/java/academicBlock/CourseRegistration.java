package academicBlock;
import Enums.RegistrationStatus; // gotta check
import Roles.Manager;
import Roles.Student;
import java.io.Serializable;
import java.util.Date;

public class CourseRegistration implements Serializable {
	private static final long serialVersionUID = 1L;
	private Student student;
	private Course course;
	private RegistrationStatus status;
	private Date createdDate;
	private Manager processedBy;
	
	public CourseRegistration(Student student, Course course) {
		 this.student = student;
		 this.course = course;
		 this.status = RegistrationStatus.PENDING;
		 this.createdDate = new Date();
 }
	
	 public Student getStudent() { return student;}
	 public Course getCourse() { return course; }
	 public RegistrationStatus getStatus() { return status; }
	 public Date getCreatedDate() { return createdDate; }	 
	 public Manager getProcessedBy() { return processedBy; }

	 public void approve(Manager manager) {
		 this.status = RegistrationStatus.APPROVED;
		 this.processedBy = manager;
	 }
	 public void reject(Manager manager) {
		 this.status = RegistrationStatus.REJECTED;
		 this.processedBy = manager;
	 }
	 public void cancel() {
		 this.status = RegistrationStatus.CANCELLED;
	 }
	 
}
