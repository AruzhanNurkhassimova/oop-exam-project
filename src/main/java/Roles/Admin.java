package Roles;

import System.*;
import Enums.*;

import java.util.List;

public class Admin extends Employee {
    private static final long serialVersionUID = 1L;

    public Admin(int id, String login, String password, String fullName,
                 Language language, double salary, String department) {
        super(id, login, password, fullName, language, salary, department);
    }

    public void addUser(User user, University university) {
        university.addUser(user);
    }

    public void removeUser(User user, University university) {
        university.removeUser(user);
    }

    public void updateUser(User user) {
        System.out.println("Updated user: " + user);
    }

    public List<LogRecord> viewLogs(Logger logger) {
        return logger.getLogs();
    }
}
