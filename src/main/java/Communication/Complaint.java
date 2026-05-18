public class Request implements Serializable {
    private Employee sender;
    private String student;
    private UrgencyLevel urgency;
    private String text;
    private Date date;

    public Complaint(Teacher sender, Student student,
                     UrgencyLevel urgency, String text) {}

    public UrgencyLevel getUrgency() { return urgency; }
    public void setUrgency(UrgencyLevel urgency) {}
    public boolean send() {}
}