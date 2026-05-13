package Roles;

import Enums.*;
import academicBlock.*;
import Exceptions.*;
import ResearcherBlock.*;

import java.util.*;

public class Student extends User implements Researcher {
    private String major;
    private String minor;
    private int yearOfStudy;
    private double gpa;
    private int credits;
    private int failedCoursesCount;
    private Transcript transcript;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Researcher supervisor;
    private ResearcherProfile researcherProfile;

    public Student(int id, String login, String password,
                   String fullName, Language language,
                   String major, String minor, int yearOfStudy) {
        super(id, login, password, fullName, language);
        this.major = major;
        this.minor = minor;
        this.yearOfStudy = yearOfStudy;
        this.transcript = new Transcript(this);
    }

    public String getMajor() { return major; }

    public String getMinor() { return minor; }

    public int getYearOfStudy() { return yearOfStudy; }

    public double getGpa() { return gpa; }

    public int getCredits() { return credits; }

    public int getFailedCoursesCount() { return failedCoursesCount; }

    public Transcript getTranscript() { return transcript; }

    public Researcher getSupervisor() { return supervisor; }

    public List<Course> getEnrolledCourses() { return enrolledCourses; }

    public ResearcherProfile getResearcherProfile() { return researcherProfile; }

    public boolean isResearcher() { return researcherProfile != null; }

    public ResearcherProfile becomeResearcher() {
        if (researcherProfile == null) {
            researcherProfile == new ResearcherProfile(this);
        }
        return researcherProfile;
    }

    public void setMinor(String minor) { this.minor = minor; }

    public void setSupervisor(Researcher supervisor) throws LowHIndexException {
        if (supervisor.calculateHIndex() < 3) {
            throw new LowHIndexException("Supervisor h-index must be at least 3");
        }
        this.supervisor = supervisor;
    }

    public boolean registerForCourse(Course course)
            throws CreditLimitExceededException {
        if (credits + course.getCredits() > 21) {
            throw new CreditLimitExceededException("Student cannot take more than 21 credits");
        }
        if (course.addStudent(this)) {
            enrolledCourses.add(course);
            credits += course.getCredits();
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (enrolledCourses.remove(course)) {
            credits -= course.getCredits();
            course.removeStudent(this);
            return true;
        }
        return false;
    }

    public Transcript viewTranscript() { return transcript; }

    public List<Mark> viewMarks() { return transcript.getMarks(); }

    public void rateTeacher(Teacher teacher, double rating) {
        teacher.receiveRating(rating);
    }

    public double calculateGPA() {
        this.gpa = transcript.calculateGPA();
        return gpa;
    }

    public void incrementFailedCoursesCount() { failedCoursesCount++; }

    //public int calculateHIndex() {}
    //public void printPapers(Comparator<ResearchPaper> c) {}
    //public List<ResearchPaper> getResearchPapers() { return researchPapers; }
    //public List<ResearchProject> getResearchProjects() { return researchProjects; }

    public void addResearchPaper(ResearchPaper paper) {
        becomeResearcher().addResearcherPaper(paper);
    }

    public void joinResearchProject(ResearchProject project) {
        becomeResearcher().joinResearcherProject(project);
    }

    @Override
    public String toString() {
        return "Student{" + getFullName() + ", major='"
                + major + "', year=" + yearOfStudy + "}";
    }
}