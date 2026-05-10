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
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();

    public Student(int id, String login, String password,
                   String fullName, Language language,
                   String major, int yearOfStudy) {}

    public String getMajor() { return major; }
    public String getMinor() { return minor; }
    public int getYearOfStudy() { return yearOfStudy; }
    public double getGpa() { return gpa; }
    public int getCredits() { return credits; }
    public Transcript getTranscript() { return transcript; }
    public Researcher getSupervisor() { return supervisor; }
    public List<Course> getEnrolledCourses() { return enrolledCourses; }

    public void setMinor(String minor) {}
    public void setSupervisor(Researcher supervisor) throws LowHIndexException {}

    public boolean registerForCourse(Course course) throws CreditLimitExceededException {}
    public boolean dropCourse(Course course) {}
    public Transcript viewTranscript() { return transcript; }
    public void rateTeacher(Teacher teacher, double rating) {}
    public double calculateGPA() {}

    public int calculateHIndex() {}
    public void printPapers(Comparator<ResearchPaper> c) {}
    public List<ResearchPaper> getResearchPapers() { return researchPapers; }
    public List<ResearchProject> getResearchProjects() { return researchProjects; }
    public void addResearchPaper(ResearchPaper paper) {}
    public void joinResearchProject(ResearchProject project) {}
}