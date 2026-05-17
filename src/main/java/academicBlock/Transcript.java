package academicBlock;
import java.util.*;
import java.io.Serializable;

public class Transcript implements Serializable {
	 private Student student;
	 private List<Mark> marks = new ArrayList<>();
	 
	 public Transcript(Student student) {
		 this.student = student;
	 }
	 
	 public Student getStudent() { return student; }
	 public List<Mark> getMarks() { return marks; }
	 public void addMark(Mark mark) {}
	 public void removeMark(Mark mark) {}
	 public double calculateGPA() {}
	 
	 public int getPassedCoursesCount() {}
	 public int getFailedCoursesCount() {}
	 public String getTranscriptInfo() {}
	}

