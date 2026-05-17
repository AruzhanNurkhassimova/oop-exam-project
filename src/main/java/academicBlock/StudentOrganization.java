package academicBlock;
import java.util.*;
import java.io.Serializable;

public class StudentOrganization implements Serializable {
	 private String name;
	 private List<Student> members = new ArrayList<>();
	 private Student head;
	 
	 public StudentOrganization(String name) {
		 this.name = name;
	 }
	 
	 public String getName() { return name; }
	 public List<Student> getMembers() { return members; }
	 public Student getHead() { return head; }
	 
	 public void setName(String name) {}
	 
	 public void assignHead(Student student) {}
	 public void addMember(Student student) {}
	 public void removeMember(Student student) {}
	 public boolean containsMember(Student student) {}
}
