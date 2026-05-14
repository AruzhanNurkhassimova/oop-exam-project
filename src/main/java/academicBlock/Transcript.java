package academicBlock;
import Roles.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transcript implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private Student student;
	 private List<Mark> marks = new ArrayList<>();
	 
	 public Transcript(Student student) {
		 this.student = student;
	 }
	 
	 public Student getStudent() { return student; }
	 public List<Mark> getMarks() { return marks; }

	 public void addMark(Mark mark) {
		 if (mark != null) {
			 marks.add(mark); }
	 }
	 
	 public void removeMark(Mark mark) {
		 marks.remove(mark);
	 }
	 public double calculateGPA() {
		 if (marks.isEmpty()) { return 0.0; }
		 double sum = 0;
		 for (Mark mark : marks) {
			 sum += mark.getNumericGrade(); }
		 return sum / marks.size();
	 }
	 
	 public int getPassedCoursesCount() {
		 int count = 0;
		 for (Mark mark : marks) {
			 if (mark.isPassed()) count++; }
		 return count;
	 }
	 
	 public int getFailedCoursesCount() {
		 int count = 0;
		 for (Mark mark : marks) {
			 if (!mark.isPassed()) count++; }
		 return count;
	 }
	 
	 public String getTranscriptInfo() {
		 return "Transcript of " + student.getFullName() + ", GPA=" + calculateGPA() + ", marks=" + marks;
	 }
	 @Override
	 public String toString() {
		 return getTranscriptInfo();
	 }
}