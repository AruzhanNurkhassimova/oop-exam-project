package Roles;
import java.util.*;
import Enums.*;
import academicBlock.*;

public class Manager extends Employee {
	 private ManagerType managerType;
	 
	 public ManagerType getManagerType() { return managerType; }
	 public void setManagerType(ManagerType managerType) {}
	 
	 public boolean approveRegistration(Student student, Course course) {}
	 public void assignCourseToTeacher(Course course, Teacher teacher) {}
	 public Report createStatisticsReport() {}
	 public void addNews(News news, University university) {}
}