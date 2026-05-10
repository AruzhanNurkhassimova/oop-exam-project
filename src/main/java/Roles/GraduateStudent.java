public class GraduateStudent extends Student {
    private DegreeType degreeType;
    private List<ResearchPaper> diplomaProjects = new ArrayList<>();

    public GraduateStudent(int id, String login, String password,
                           String fullName, Language language,
                           String major, DegreeType degreeType) {}

    public DegreeType getDegreeType() { return degreeType; }
    public List<ResearchPaper> getDiplomaProjects() { return diplomaProjects; }

    public void setDegreeType(DegreeType degreeType) {}
    public void addDiplomaProject(ResearchPaper paper) {}
    public List<ResearchPaper> viewDiplomaProjects() { return diplomaProjects; }
}