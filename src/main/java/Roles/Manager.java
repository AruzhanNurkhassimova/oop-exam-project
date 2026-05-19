package Roles;
import java.util.*;
import Enums.*;
import academicBlock.*;
import Communication.*;
import System.*;

import java.util.Comparator;

/**
 * Represents a university manager.
 * Manager approves course registrations, opens courses for registration,
 * assigns teachers to courses, manages news and creates statistical reports.
 */
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

	/**
	 * Approves student's pending course registration.
	 * After approval the student becomes enrolled in the course.
	 *
	 * @param student student whose registration is approved
	 * @param course course selected by the student
	 * @return true if registration was approved successfully
	 */
	public boolean approveRegistration(Student student, Course course) {
		CourseRegistration registration = course.findRegistration(student);

		if (registration == null || registration.getStatus() != RegistrationStatus.PENDING) {
			return false;
		}

		boolean enrolled = student.confirmCourseRegistration(course);

		if (enrolled) {
			registration.approve(this);
		}

		return enrolled;
	}

	public boolean rejectRegistration(Student student, Course course) {
		CourseRegistration registration = course.findRegistration(student);

		if (registration == null || registration.getStatus() != RegistrationStatus.PENDING) {
			return false;
		}

		registration.reject(this);
		return true;
	}

	public void addVisibleRequest(Request request) {
		if (request != null && !visibleRequests.contains(request)) {
			visibleRequests.add(request);
		}
	}

	public List<Request> viewRequests() {
		return visibleRequests;
	}

	public List<Student> viewStudentsSortedByGPA(List<Student> students) {
		return students.stream()
				.sorted(Comparator.comparingDouble(Student::getGpa).reversed())
				.toList();
	}

	public List<Student> viewStudentsSortedAlphabetically(List<Student> students) {
		return students.stream()
				.sorted(Comparator.comparing(Student::getFullName))
				.toList();
	}

	public List<Teacher> viewTeachersSortedAlphabetically(List<Teacher> teachers) {
		return teachers.stream()
				.sorted(Comparator.comparing(Teacher::getFullName))
				.toList();
	}

	 public void addCourseForRegistration(Course course) { course.openRegistration(); }

	 public void assignCourseToTeacher(Course course, Teacher teacher) {
		 course.addInstructor(teacher);
		 teacher.addCourse(course);
	 }

	/**
	 * Creates a simple academic performance report based on course marks.
	 *
	 * @param courses list of courses used for statistics
	 * @return generated report with passed, failed and average mark statistics
	 */
	public Report createStatisticsReport(List<Course> courses) {
		int marksCount = 0;
		int passed = 0;
		int failed = 0;
		double total = 0;

		for (Course course : courses) {
			for (Mark mark : course.getMarks()) {
				marksCount++;
				total += mark.getTotal();

				if (mark.isPassed()) {
					passed++;
				} else {
					failed++;
				}
			}
		}

		double average = marksCount == 0 ? 0 : total / marksCount;

		String content = "Marks count: " + marksCount
				+ ", passed: " + passed
				+ ", failed: " + failed
				+ ", average total: " + average;

		return new Report("Academic performance report", content);
	}
	 public void addNews(News news, University university) {
		 university.addNews(news);
	 }
}