package ResearcherBlock;

import java.util.*;

public class ResearcherImpl implements Researcher {

    private List<ResearchPaper> papers = new ArrayList<>();
    private List<ResearchProject> projects = new ArrayList<>();

    @Override
    public int calculateHIndex() {
        return HIndexCalculator.calculate(papers);
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        papers.stream()
              .sorted(comparator)
              .forEach(p -> System.out.println(p.getTitle()));
    }

    @Override
    public List<ResearchPaper> getResearchPapers() {
        return papers;
    }

    @Override
    public List<ResearchProject> getResearchProjects() {
        return projects;
    }

    @Override
    public void addResearchPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    @Override
    public void joinResearchProject(ResearchProject project) {
        projects.add(project);
    }
}