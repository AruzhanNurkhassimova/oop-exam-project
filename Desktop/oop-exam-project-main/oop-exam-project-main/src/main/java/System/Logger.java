package edu.university.system;
 
import edu.university.users.User;
 
import java.util.ArrayList;
import java.util.List;
 
public class Logger {
    private List<LogRecord> logs = new ArrayList<>();
 
    public void log(User user, String action) {
        logs.add(new LogRecord(user.getLogin(), action));
    }
 
    public List<LogRecord> getLogs() {
        return logs;
    }
 
    public void clearLogs() {
        logs.clear();
    }
}
