package Roles;

import Enums.*;
import Communication.*;
import academicBlock.*;

import java.util.ArrayList;
import java.util.List;

public class TechSupportSpecialist extends Employee {
    private static final long serialVersionUID = 1L;

    private List<Request> assignedRequests = new ArrayList<>();

    public TechSupportSpecialist(int id, String login, String password, String fullName,
                                 Language language, double salary, String department) {
        super(id, login, password, fullName, language, salary, department);
    }

    public List<Request> getAssignedRequests() {
        return assignedRequests;
    }

    public List<Request> viewNewRequests(List<Request> requests) {
        List<Request> result = new ArrayList<>();
        for (Request request : requests) {
            if (request.getStatus() == RequestStatus.NEW) {
                request.markViewed();
                result.add(request);
            }
        }
        return result;
    }

    public void acceptRequest(Request request) {
        request.setAssignee(this);
        request.markAccepted();
        if (!assignedRequests.contains(request)) {
            assignedRequests.add(request);
        }
    }

    public void rejectRequest(Request request) {
        request.markRejected();
    }

    public void markDone(Request request) {
        request.markDone();
    }
}
