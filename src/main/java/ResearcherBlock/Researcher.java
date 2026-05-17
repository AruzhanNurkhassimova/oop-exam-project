package ResearcherBlock;

import java.util.Comparator;
import java.util.List;

public interface Researcher {
    int calculateHIndex();

    void printPapers(Comparator<ResearchPaper> comparator);

    List<ResearchPaper> getResearchPapers();
    List<ResearchProject> getResearchProjects();

    void addResearchPaper(ResearchPaper paper);
    void joinResearchProject(ResearchProject project);
}