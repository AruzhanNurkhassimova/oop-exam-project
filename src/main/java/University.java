public class University implements Serializable {
    private String name;
    private List<User> users = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Journal> journals = new ArrayList<>();
    private List<News> news = new ArrayList<>();

    public University(String name) {}

    public String getName() { return name; }
    public List<User> getUsers() { return users; }
    public List<Course> getCourses() { return courses; }
    public List<Journal> getJournals() { return journals; }
    public List<News> getNews() { return news; }

    public void setName(String name) {}
    public void addUser(User user) {}
    public void removeUser(User user) {}
    public void addCourse(Course course) {}
    public void removeCourse(Course course) {}
}