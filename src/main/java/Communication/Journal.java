package Communication;

import ResearcherBlock.ResearchPaper;
import Roles.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Journal implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private List<User> subscribers = new ArrayList<>();
    private List<ResearchPaper> papers = new ArrayList<>();

    public Journal(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public List<ResearchPaper> getPapers() {
        return papers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void subscribe(User user) {
        if (user != null && !subscribers.contains(user)) {
            subscribers.add(user);
        }
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    public void publishPaper(ResearchPaper paper) {
        if (paper != null) {
            papers.add(paper);
            notifySubscribers("New research paper published: " + paper.getTitle());
        }
    }

    public void notifySubscribers(String message) {
        for (User user : subscribers) {
            user.update(message);
        }
    }

    @Override
    public String toString() {
        return "Journal{" + title + ", papers=" + papers.size() + "}";
    }
}