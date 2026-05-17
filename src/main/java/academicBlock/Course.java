package academicBlock;
import java.io.Serializable;
import java.util.*;

public class Course implements Serializable {
	 private String courseCode;
	 private String courseName;
	 private int credits;
	 private CourseType courseType;
	 private String school;
	 private int yearOfStudy;
	 private String major;
	 
	 private List<Student> students = new ArrayList<>();
	 private List<Teacher> instructors = new ArrayList<>();
	 private List<Lesson> lessons = new ArrayList<>();
	 private List<Mark> marks = new ArrayList<>();
	 
	 public Course(String courseCode, String courseName, int credits, CourseType courseType, String school, int yearOfStudy, String major) {
		 this.courseCode = courseCode;
		 this.courseName = courseName;
		 this.credits = credits;
		 this.courseType = courseType;
		 this.school = scholl;
		 this.yearOfStudy = yearOfStudy;
		 
	 }
	 
	 public String getCourseCode() { return courseCode; }
	 public String getCourseName() { return courseName; }
	 public int getCredits() { return credits; }
	 public CourseType getCourseType() { return courseType; }
	 public String getSchool() { return school; }
	 public int getYearOfStudy() { return yearOfStudy; }
	 public String getMajor() { return major; }
	 
	 public List<Student> getStudents() { return students; }
	 public List<Teacher> getInstructors() { return instructors; }
	 public List<Lesson> getLessons() { return lessons; }
	 
	 public void setCourseName(String courseName) {}
	 public void setCredits(int credits) {}
	 
	 public boolean addStudent(Student student) {}
	 public boolean removeStudent(Student student) {}
	 public void addInstructor(Teacher teacher) {}
	 public void removeInstructor(Teacher teacher) {}
	 public void addLesson(Lesson lesson) {}
	 public void addMark(Mark mark) {}
	 
	 public boolean equals(Object obj) {}
	 public int hashCode() {}
	}

