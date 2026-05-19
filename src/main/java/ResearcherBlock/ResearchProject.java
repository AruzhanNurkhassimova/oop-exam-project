package ResearcherBlock;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a research project.
 * A project has a topic, research participants and published papers.
 * Only researchers can participate in a research project.
 */
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

    /**
     * Adds a participant to the research project.
     * Only objects implementing Researcher are accepted.
     *
     * @param person possible project participant
     * @throws NotResearcherException if the person is not a researcher
     */
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