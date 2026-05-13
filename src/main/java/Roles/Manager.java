package Roles;
import java.util.*;
import Enums.*;
import academicBlock.*;
import Communication.*;
import System.*;

public class Manager extends Employee {
	 private ManagerType managerType;
	 private List<Request> visibleRequests = new ArrayList<>();

	 public Manager(int id, String login, String password, String fullName,
					Language language, double salary, String department,
					ManagerType managerType) {
		 super(id, login, password, fullName, language, salary, department);
		 this.managerType = managerType;
	 }
	 
	 public ManagerType getManagerType() { return managerType; }

	 public void setManagerType(ManagerType managerType) {
		 this.managerType = managerType;
	 }
	 
	 public boolean approveRegistration(Student student, Course course) {
		 return course.addStudent(student);
	 }

	 public void addCourseForRegistration(Course course) { course.openRegistration(); }

	 public void assignCourseToTeacher(Course course, Teacher teacher) {
		 course.addInstructor(teacher);
		 teacher.addCourse(course);
	 }

	 public Report createStatisticsReport() {
		 return new Report("Academic statistics",
				 "Simple report about marks and academic performance.");
	 }
	 public void addNews(News news, University university) {
		 university.addNews(news);
	 }
}