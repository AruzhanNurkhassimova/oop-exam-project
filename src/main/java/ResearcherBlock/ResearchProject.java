package ResearcherBlock;

import java.io.Serializable;
import java.util.*;

public class ResearchProject implements Serializable {

    private String topic;
    private List<Researcher> participants = new ArrayList<>();
    private List<ResearchPaper> publishedPapers = new ArrayList<>();

    public ResearchProject(String topic) {
        this.topic = topic;
    }

    public String getTopic() { return topic; }
    public List<Researcher> getParticipants() { return participants; }
    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }

    public void addParticipant(Object person) throws NotResearcherException {
        if (!(person instanceof Researcher researcher)) {
            throw new NotResearcherException("Only researchers can join project");
        }

        if (!participants.contains(researcher)) {
            participants.add(researcher);
        }
    }

    public void removeParticipant(Researcher r) {
        participants.remove(r);
    }

    public void addPublishedPaper(ResearchPaper p) {
        publishedPapers.add(p);
    }

    public int getTotalCitations() {
        int sum = 0;
        for (ResearchPaper p : publishedPapers) {
            sum += p.getCitations();
        }
        return sum;
    }
}