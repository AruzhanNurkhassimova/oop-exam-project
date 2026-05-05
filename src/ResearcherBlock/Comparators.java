package ResearcherBlock;

import java.util.Comparator;

class ResearchPaperByCitationsComparator implements Comparator<ResearchPaper> {
    public int compare(ResearchPaper p1, ResearchPaper p2) {
        return Integer.compare(p2.getCitations(), p1.getCitations());
    }
}

class ResearchPaperByDateComparator implements Comparator<ResearchPaper> {
    public int compare(ResearchPaper p1, ResearchPaper p2) {
        return p2.getPublicationDate().compareTo(p1.getPublicationDate());
    }
}

class ResearchPaperByPagesComparator implements Comparator<ResearchPaper> {
    public int compare(ResearchPaper p1, ResearchPaper p2) {
        return Integer.compare(p2.getPages(), p1.getPages());
    }
}