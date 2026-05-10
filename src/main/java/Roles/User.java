public class abstract class User implements Serializable {
    private final int id;
    private String login;
    private String password;
    private String fullName;
    private Language language;

    public User(int id, String login, String password,
                String fullName, Language language) {}

    public int getId() { return id; }
    public String getLogin() { return login; }
    public String getFullName() { return fullName; }
    public Language getLanguage() { return language; }

    public void setFullName(String fullName) {}
    public void changeLanguage(Language language) {}

    public boolean checkPassword(String rawPassword) {}
    public boolean changePassword(String oldPassword, String newPassword) {}

    public List<News> viewNews(University university) {}
    public void subscribeToJournal(Journal journal) {}
    public void unsubscribeFromJournal(Journal journal) {}
    public void update(String message) {}

    public boolean equals(Object obj) {}
    public int hashCode() {}
    public String toString() {}
}