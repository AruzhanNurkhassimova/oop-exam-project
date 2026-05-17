public class Request implements Serializable {
    private Employee sender;
    private String description;
    private RequestStatus status;
    private Date createdDate;
    private TechSupportSpecialist assignee;

    public Request(Employee sender, String description) {}

    public Employee getSender() { return sender; }
    public RequestStatus getStatus() {return status; }
    public TechSupportSpecialist getAssignee() { return assignee; }

    public void setDescription(String description) {}
    public void serAssignee(TechSupportSpecialist assignee) {}

    public void markViewed() {}
    public void markAccepted() {}
    public void markRejected() {}
    public void markDone() {}
}