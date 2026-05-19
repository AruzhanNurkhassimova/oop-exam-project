package Roles;
import java.util.*;
import ResearcherBlock.*;
import academicBlock.*;

import academicBlock.*;
import Communication.*;
import Enums.*;
import ResearcherBlock.*;

public class Teacher extends Employee implements Researcher {
	 private TeacherTitle title;
	 private String school;
	 private List<Course> courses = new ArrayList<>();
	 private List<Double> ratings = new ArrayList<>();
	 private ResearcherProfile researcherProfile;
	 
	 public Teacher(int id, String login, String password, String fullName, Language language, double salary, String department,
	 TeacherTitle title, String school) {
		 super(id, login, password, fullName, language, salary, department);
		 this.title = title;
		 this.school = school;
		 if (title == TeacherTitle.PROFESSOR) {
			 becomeResearcher();
		 }
	 }
	 public TeacherTitle getTitle() { return title; }

	 public String getSchool() { return school; }

	 public List<Course> getCourses() { return courses; }

	 public ResearcherProfile getResearcherProfile() {
		return researcherProfile;
	}

	 public boolean isResearcher() {
		return researcherProfile != null;
	}

	 public ResearcherProfile becomeResearcher() {
		 if (researcherProfile == null) {
			 researcherProfile = new ResearcherProfile(this);
		 }
		 return researcherProfile;
	 }

	 public void setTitle(TeacherTitle title) {
		 this.title = title;
		 if (title == TeacherTitle.PROFESSOR) {
			 becomeResearcher();
		 }
	 }

	 public void setSchool(String school) { this.school = school; }

	 public List<Course> viewCourses() {
		return courses;
	}

	 public void addCourse(Course course) {
		 if (course != null && !courses.contains(course)) { courses.add(course); }
	 }

	 public void removeCourse(Course course) { courses.remove(course); }

	 public List<Student> viewStudents(Course course) { return course.getStudents(); }

	 public void putMark(Student student, Course course, Mark mark) {
		 if (!courses.contains(course)) {
			 throw new IllegalArgumentException("Teacher is not assigned to this course");
		 }
		 if (!course.getStudents().contains(student)) {
			 throw new IllegalArgumentException("Student is not enrolled in this course");
		 }
		 student.getTranscript().addMark(mark);
		 course.addMark(mark);
		 if (!mark.isPassed()) {
			 student.incrementFailedCoursesCount();
		 }
	 }

	 public Complaint sendComplaint(Student student,
	 UrgencyLevel urgency, String text) {
		 return new Complaint(this, student, urgency, text);
	 }

	 public void receiveRating(double rating) {
		 if (rating < 0 || rating > 5) {
			 throw new IllegalArgumentException("Rating must be between 0 and 5");
		 }
		 ratings.add(rating);
	 }

	 public double getAverageRating() {
		 if (ratings == null || ratings.isEmpty()) {
			 return 0.0;
		 }
		 double sum = 0.0;
		 for (Double rating : ratings) {
			 sum += rating;
		 }
		 return sum / ratings.size();
	 }
	 
	 public int calculateHIndex() {
		 if (!isResearcher()) { return 0; }
		 return researcherProfile.calculateHIndex();
	 }

	 public void printPapers(Comparator<ResearchPaper> c) {
		 if (!isResearcher()) {
			 System.out.println(getFullName() + " is not a researcher.");
			 return;
		 }
		 researcherProfile.printPapers(c);
	 }

	 //public List<ResearchPaper> getResearchPapers() { return researchPapers; }
	 //public List<ResearchProject> getResearchProjects() { return researchProjects; }

	 public void addResearchPaper(ResearchPaper paper) {
		 becomeResearcher().addResearchPaper(paper);
	 }

	 public void joinResearchProject(ResearchProject project) {
		 becomeResearcher().joinResearchProject(project);
	 }

	 @Override
	 public String toString() {
		 return "Teacher{" + getFullName() + ", title=" + title
				 + ", school=" + school + "}";
	 }
}
