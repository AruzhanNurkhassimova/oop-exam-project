package Roles;

import Enums.*;
import ResearcherBlock.*;

import java.util.*;

public class GraduateStudent extends Student implements Researcher {
    private DegreeType degreeType;
    private List<ResearchPaper> diplomaProjects = new ArrayList<>();

    public GraduateStudent(int id, String login, String password,
                           String fullName, Language language,
                           String major, String minor,
                           int yearOfStudy, DegreeType degreeType) {
        super(id, login, password, fullName, language, major, minor, yearOfStudy);
        this.degreeType = degreeType;
        becomeResearcher();
    }

    public DegreeType getDegreeType() { return degreeType; }

    public List<ResearchPaper> getDiplomaProjects() { return diplomaProjects; }

    public void setDegreeType(DegreeType degreeType) { this.degreeType = degreeType; }

    public void addDiplomaProject(ResearchPaper paper) {
        if (paper != null && !diplomaProjects.contains(paper)) {
            diplomaProjects.add(paper);
            addResearchPaper(paper);
        }
    }

    public List<ResearchPaper> viewDiplomaProjects() { return diplomaProjects; }

    private ResearcherProfile profile() { return getResearcherProfile(); }

    @Override
    public int calculateHIndex() { return profile().calculateHIndex(); }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        profile().printPapers(comparator);
    }

    @Override
    public List<ResearchPaper> getResearchPapers() { return profile().getResearchPapers(); }

    @Override
    public List<ResearchProject> getResearchProjects() { return profile().getResearchProjects(); }

    @Override
    public void addResearchPaper(ResearchPaper paper) { profile().addResearchPaper(paper); }

    @Override
    public void joinResearchProject(ResearchProject project) { profile().joinResearchProject(project); }

    @Override
    public String getResearcherName() { return getFullName(); }
}