package Roles;
import Enums.*;
import System.*;
import Communication.*;

import java.io.Serializable;
import java.util.*;

/**
 * Abstract base class for all system users.
 * Stores common account information such as id, login,
 * password, full name and interface language.
 *
 * User is not created directly. Concrete roles such as
 * Student, Teacher, Manager and Admin extend this class.
 */
public abstract class User implements Serializable {
    private final int id;
    private String login;
    private String password;
    private String fullName;
    private Language language;

    public User(int id, String login, String password,
                String fullName, Language language) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        if (language == null) {
            this.language = Language.ENGLISH;
        } else {
            this.language = language;
        }
    }

    public int getId() { return id; }

    public String getLogin() { return login; }

    public String getFullName() { return fullName; }

    public Language getLanguage() { return language; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void changeLanguage(Language language) {
        if (language != null) { this.language = language; }
    }

    /**
     * Checks whether the provided password matches the user's password.
     * The password itself is not exposed through a getter for security reasons.
     *
     * @param rawPassword password entered by user
     * @return true if password is correct
     */
    public boolean checkPassword(String rawPassword) {
        return password.equals(rawPassword);
    }

    /**
     * Changes the user's password if the old password is correct.
     *
     * @param oldPassword current password
     * @param newPassword new password
     * @return true if password was changed successfully
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (!checkPassword(oldPassword)) return false;
        this.password = newPassword;
        return true;
    }

    public List<News> viewNews(University university) {
        return university.getNews();
    }

    public void subscribeToJournal(Journal journal) {
        journal.subscribe(this);
    }

    public void unsubscribeFromJournal(Journal journal) {
        journal.unsubscribe(this);
    }

    public void update(String message) {
        System.out.println(fullName + " notification: " + message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User user)) return false;
        return id == user.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() { return fullName + " (id=" +
            id + ", login=" + login + ")";
    }
}