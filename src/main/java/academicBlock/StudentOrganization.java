package academicBlock;
import Roles.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentOrganization implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private String name;
	 private List<Student> members = new ArrayList<>();
	 private Student head;
	 
	 public StudentOrganization(String name) {
		 this.name = name;
	 }
	 
	 public String getName() { return name; }
	 public List<Student> getMembers() { return members; }
	 public Student getHead() { return head; }

	 public void setName(String name) { this.name = name; }
	 
	 public void assignHead(Student student) {
		 if (!members.contains(student)) {
			 throw new IllegalArgumentException("Head must be a member of the organization"); }
		 this.head = student;
	 }
	 
	 public void addMember(Student student) {
		 if (!members.contains(student)) {
			 members.add(student); }
	 }
	 
	 public void removeMember(Student student) {
		 members.remove(student);
		 if (student.equals(head)) {
			 head = null; }
	 }
	 
	 public boolean containsMember(Student student) {
		 return members.contains(student);
	 }
	 
	 @Override
	 public String toString() {
		 return "StudentOrganization{" + name + ", members=" + members.size() + "}";
	 }
}
