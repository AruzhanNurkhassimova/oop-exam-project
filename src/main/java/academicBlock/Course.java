package academicBlock;

import Enums.CourseType;
import Enums.RegistrationStatus;
import Roles.Student;
import Roles.Teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an academic course.
 * A course contains students, instructors, lessons, marks and
 * course registration requests.
 *
 * More than one teacher can be assigned to the same course.
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private String courseCode;
    private String courseName;
    private int credits;
    private CourseType courseType;
    private String school;
    private int yearOfStudy;
    private String major;
    private boolean registrationOpen;

    private List<Student> students = new ArrayList<>();
    private List<Teacher> instructors = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();
    private List<Mark> marks = new ArrayList<>();
    private List<CourseRegistration> registrations = new ArrayList<>();

    public Course(String courseCode, String courseName, int credits, CourseType courseType,
                  String school, int yearOfStudy, String major) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.courseType = courseType;
        this.school = school;
        this.yearOfStudy = yearOfStudy;
        this.major = major;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public String getSchool() {
        return school;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getMajor() {
        return major;
    }

    public boolean isRegistrationOpen() {
        return registrationOpen;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public List<CourseRegistration> getRegistrations() {
        return registrations;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        this.credits = credits;
    }

    public void openRegistration() {
        this.registrationOpen = true;
    }

    public void closeRegistration() {
        this.registrationOpen = false;
    }

    /**
     * Creates a pending course registration request for a student.
     * If the student already has a pending request, the existing one is returned.
     *
     * @param student student who wants to register
     * @return course registration object
     */
    public CourseRegistration requestRegistration(Student student) {
        CourseRegistration existing = findRegistration(student);

        if (existing != null && existing.getStatus() == RegistrationStatus.PENDING) {
            return existing;
        }

        CourseRegistration registration = new CourseRegistration(student, this);
        registrations.add(registration);
        return registration;
    }

    public CourseRegistration findRegistration(Student student) {
        for (CourseRegistration registration : registrations) {
            if (registration.getStudent().equals(student)) {
                return registration;
            }
        }
        return null;
    }

    public boolean addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    /**
     * Adds a teacher as an instructor of this course.
     *
     * @param teacher teacher assigned to the course
     */
    public void addInstructor(Teacher teacher) {
        if (!instructors.contains(teacher)) {
            instructors.add(teacher);
        }
    }

    public void removeInstructor(Teacher teacher) {
        instructors.remove(teacher);
    }

    public void addLesson(Lesson lesson) {
        if (lesson != null && !lessons.contains(lesson)) {
            lessons.add(lesson);
        }
    }

    public void addMark(Mark mark) {
        if (mark != null) {
            marks.add(mark);
        }
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + credits + " credits)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course course)) return false;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
