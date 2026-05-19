package ResearcherBlock;

import Roles.User;

import java.io.Serializable;
import java.util.*;

public class ResearcherProfile implements Researcher, Serializable {
    private static final long serialVersionUID = 1L;

    private User owner;
    private List<ResearchPaper> researchPapers = new ArrayList<>();
    private List<ResearchProject> researchProjects = new ArrayList<>();

    public ResearcherProfile(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public int calculateHIndex() {
        return HIndexCalculator.calculate(new ArrayList<>(researchPapers));
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        if (paper != null && !researchPapers.contains(paper)) {
            researchPapers.add(paper);
        }
    }

    @Override
    public void joinResearchProject(ResearchProject project) {
        if (project != null && !researchProjects.contains(project)) {
            researchProjects.add(project);
        }
    }

    @Override
    public String getResearcherName() {
        return owner.getFullName();
    }

    @Override
    public String toString() {
        return "ResearcherProfile{" + owner.getFullName() + "}";
    }
}