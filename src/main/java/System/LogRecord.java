package System;
 
import java.io.Serializable;
import java.util.Date;
 
public class LogRecord implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private Date timestamp;
    private String userLogin;
    private String action;
 
    public LogRecord(String userLogin, String action) {
        this.timestamp = new Date();
        this.userLogin = userLogin;
        this.action = action;
    }
 
    public Date getTimestamp() {
        return timestamp;
    }
 
    public String getUserLogin() {
        return userLogin;
    }
 
    public String getAction() {
        return action;
    }
 
    @Override
    public String toString() {
        return "[" + timestamp + "] " + userLogin + ": " + action;
    }
}
