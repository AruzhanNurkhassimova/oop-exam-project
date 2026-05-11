package Roles;
import java.util.*;


public class Teacher extends Employee implements Researcher {
	 private TeacherTitle title;
	 private String school;
	 private List<Course> courses = new ArrayList<>();
	 private List<Double> ratings = new ArrayList<>();
	 private List<ResearchPaper> researchPapers = new ArrayList<>();
	 private List<ResearchProject> researchProjects = new ArrayList<>();
	 
	 public Teacher(int id, String login, String password, String fullName, Language language, double salary, String department,
	 TeacherTitle title, String school) {
		 super(id, login, password, fullName, language);
		 super(salary, department, hireDate);
		 this.title = title;
		 this.school = school;	 
	 }
	 public TeacherTitle getTitle() { return title; }
	 public String getSchool() { return school; }
	 public List<Course> getCourses() { return courses; }
	 
	 public void setTitle(TeacherTitle title) {}
	 public void setSchool(String school) {}
	 
	 public void addCourse(Course course) {}
	 public void removeCourse(Course course) {}
	 public List<Student> viewStudents(Course course) {}
	 public void putMark(Student student, Course course, Mark mark) {}
	 public Complaint sendComplaint(Student student,
	 UrgencyLevel urgency, String text) {}
	 public void addRating(double rating) {}
	 public double getAverageRating() {}
	 
	 public int calculateHIndex() {}
	 public void printPapers(Comparator<ResearchPaper> c) {}
	 public List<ResearchPaper> getResearchPapers() { return researchPapers; }
	 public List<ResearchProject> getResearchProjects() { return researchProjects; }
	 public void addResearchPaper(ResearchPaper paper) {}
	 public void joinResearchProject(ResearchProject project) {}
}
