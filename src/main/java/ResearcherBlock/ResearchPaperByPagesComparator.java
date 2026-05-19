package ResearcherBlock;

import java.util.Comparator;

public class ResearchPaperByPagesComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper p1, ResearchPaper p2) {
        return Integer.compare(p2.getPages(), p1.getPages());
    }
}
