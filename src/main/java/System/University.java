package System;

import Exceptions.*;
import Roles.*;
import academicBlock.*;
import Communication.*;
import ResearcherBlock.*;
import Enums.*;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
public class University implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String name;
    private List<User> users = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Journal> journals = new ArrayList<>();
    private List<News> news = new ArrayList<>();
 
    public University(String name) {
        this.name = name;
    }
 
    public University() {
        this("Research-Oriented University");
    }
 
    public String getName() {
        return name;
    }
 
    public List<User> getUsers() {
        return users;
    }
 
    public List<Course> getCourses() {
        return courses;
    }
 
    public List<Journal> getJournals() {
        return journals;
    }
 
    public List<News> getNews() {
        return news;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void addUser(User user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
        }
    }
 
    public void removeUser(User user) {
        users.remove(user);
    }
 
    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }
 
    public void removeCourse(Course course) {
        courses.remove(course);
    }
 
    public void addJournal(Journal journal) {
        if (journal != null && !journals.contains(journal)) {
            journals.add(journal);
        }
    }
 
    public void addNews(News newsItem) {
        if (newsItem != null) {
            news.add(newsItem);
        }
    }
 
    public List<Researcher> getAllResearchers() {
        List<Researcher> researchers = new ArrayList<>();
 
        for (User user : users) {
            if (user instanceof Researcher researcher) {
                researchers.add(researcher);
            }
            if (user instanceof Teacher teacher && teacher.isResearcher()) {
                researchers.add(teacher.getResearcherProfile());
            }
        }
 
        return researchers;
    }
 
    public void printAllPapers(Comparator<ResearchPaper> comparator) {
        for (Researcher researcher : getAllResearchers()) {
            System.out.println("Papers of " + researcher.getResearcherName() + ":");
            researcher.printPapers(comparator);
        }
    }
 
    public Researcher getTopCitedResearcher() {
        return getAllResearchers().stream()
                .max(Comparator.comparingInt(r -> r.getResearchPapers().stream()
                        .mapToInt(ResearchPaper::getCitations)
                        .sum()))
                .orElse(null);
    }
 
    public Researcher getTopCitedResearcherBySchool(String school) {
        return getAllResearchers().stream()
                .filter(r -> r instanceof ResearcherProfile profile
                        && profile.getOwner() instanceof Teacher teacher
                        && teacher.getSchool().equalsIgnoreCase(school))
                .max(Comparator.comparingInt(r -> r.getResearchPapers().stream()
                        .mapToInt(ResearchPaper::getCitations)
                        .sum()))
                .orElse(null);
    }
 
    public News generateTopResearcherNews() {
        Researcher top = getTopCitedResearcher();
        String content = top == null ? "No researchers found" :
                "Top cited researcher is " + top.getResearcherName();
        News item = new News("Top Cited Researcher", content, NewsTopic.RESEARCH);
        addNews(item);
        return item;
    }
 
    public News announcePaper(ResearchPaper paper) {
        News item = new News("New Research Paper", paper.getTitle(), NewsTopic.RESEARCH);
        addNews(item);
        return item;
    }
 
    public Report generateResearchReport() {
        return new Report("Research report", "Researchers count: " + getAllResearchers().size());
    }
 
    @Override
    public String toString() {
        return name + " users=" + users.size() + ", courses=" + courses.size();
    }
}
