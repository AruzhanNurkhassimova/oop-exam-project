package ResearcherBlock;

import java.util.*;

public final class HIndexCalculator {

    private HIndexCalculator() {}

    public static int calculate(List<ResearchPaper> papers) {
        List<ResearchPaper> sorted = new ArrayList<>(papers);
        sorted.sort((a, b) -> Integer.compare(b.getCitations(), a.getCitations()));

        int h = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).getCitations() >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}