package Roles;

import Enums.Language;
import ResearcherBlock.*;

import java.util.Comparator;
import java.util.List;

public class ResearchEmployee extends Employee implements Researcher {
    private static final long serialVersionUID = 1L;

    private ResearcherProfile researcherProfile;

    public ResearchEmployee(int id, String login, String password, String fullName,
                            Language language, double salary, String department) {
        super(id, login, password, fullName, language, salary, department);
        this.researcherProfile = new ResearcherProfile(this);
    }

    public ResearcherProfile getResearcherProfile() {
        return researcherProfile;
    }

    @Override
    public int calculateHIndex() {
        return researcherProfile.calculateHIndex();
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        researcherProfile.printPapers(comparator);
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return researcherProfile.getResearchPapers();
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return researcherProfile.getResearchProjects();
    }

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        researcherProfile.addResearchPaper(paper);
    }

    @Override
    public void joinResearchProject(ResearchProject project) {
        researcherProfile.joinResearchProject(project);
    }

    @Override
    public String getResearcherName() {
        return getFullName();
    }
}
