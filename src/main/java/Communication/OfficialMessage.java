package Communication;

import Roles.Employee;

public class OfficialMessage extends Message {
    private static final long serialVersionUID = 1L;

    private String subject;

    public OfficialMessage(Employee sender, Employee receiver, String subject, String text) {
        super(sender, receiver, text);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "[OFFICIAL] " + subject + ": " + super.toString();
    }
}
