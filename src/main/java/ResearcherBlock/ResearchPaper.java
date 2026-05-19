package ResearcherBlock;
import Enums.CitationFormat;
import java.io.Serializable;
import java.util.*;

public class ResearchPaper implements Serializable, Comparable<ResearchPaper> {

    private String title;
    private List<Researcher> authors = new ArrayList<>();
    private String journalName;
    private int pages;
    private Date publicationDate;
    private String doi;
    private int citations;

    public ResearchPaper(String title, String journalName,
                         int pages, Date publicationDate, String doi) {
        this.title = title;
        this.journalName = journalName;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.doi = doi;
        this.citations = 0;
    }

    public String getTitle() { return title; }
    public List<Researcher> getAuthors() { return authors; }
    public String getJournalName() { return journalName; }
    public int getPages() { return pages; }
    public Date getPublicationDate() { return publicationDate; }
    public String getDoi() { return doi; }
    public int getCitations() { return citations; }

    private int getPublicationYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(publicationDate);
        return calendar.get(Calendar.YEAR);
    }

    public String getCitation(CitationFormat format) {
        if (format == CitationFormat.BIBTEX) {
            return "@article{" + doi +
                    ", title={" + title + "}" +
                    ", journal={" + journalName + "}" +
                    ", year={" + getPublicationYear() + "}" +
                    "}";
        }

        return title + ", " + journalName + ", DOI: " + doi;
    }

    public void addAuthor(Researcher author) {
        if (author != null && !authors.contains(author)) {
            authors.add(author);
        }
    }

    public void removeAuthor(Researcher author) {
        authors.remove(author);
    }

    public void incrementCitations() {
        citations++;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    @Override
    public String toString() {
        return title + " (" + journalName + ", citations=" + citations + ", pages=" + pages + ")";
    }

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ResearchPaper)) return false;
        ResearchPaper other = (ResearchPaper) obj;
        return Objects.equals(doi, other.doi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doi);
    }
}