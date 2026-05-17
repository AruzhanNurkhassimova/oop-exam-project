package ResearcherBlock;

import java.util.*;

public final class HIndexCalculator {

    private HIndexCalculator() {}

    public static int calculate(List<ResearchPaper> papers) {
        papers.sort((a, b) -> b.getCitations() - a.getCitations());

        int h = 0;
        for (int i = 0; i < papers.size(); i++) {
            if (papers.get(i).getCitations() >= i + 1) {
                h = i + 1;
            } else break;
        }
        return h;
    }
}