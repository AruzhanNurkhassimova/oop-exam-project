import Communication.*;
import Enums.*;
import Exceptions.AuthenticationException;
import ResearcherBlock.*;
import Roles.*;
import System.*;
import academicBlock.*;

import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        University university = new University("Kazakh-British Technical University");
        UserFactory factory = new UserFactory();
        AuthService authService = new AuthService();
        Logger logger = new Logger();

        Admin admin = factory.createAdmin(1, "admin", "admin123",
                "System Admin", Language.ENGLISH, 500000, "IT"
        );

        Manager manager = factory.createManager(2, "manager", "manager123", "Academic Manager",
                Language.ENGLISH, 450000, "Office Registrar", ManagerType.OR
        );

        Teacher professor = factory.createTeacher(3, "professor", "prof123", "Dr. Alan Smith",
                Language.ENGLISH, 700000, "Computer Science", TeacherTitle.PROFESSOR, "SITE"
        );

        Teacher tutor = factory.createTeacher(4, "tutor", "tutor123", "Mr. John Brown",
                Language.ENGLISH, 300000, "Computer Science", TeacherTitle.TUTOR, "SITE"
        );

        Student student = factory.createStudent(5, "student", "student123", "Aruzhan Student",
                Language.ENGLISH, "Computer Science", "Mathematics", 2
        );

        GraduateStudent graduateStudent = factory.createGraduateStudent(6, "graduate", "graduate123",
                "Dias Graduate", Language.ENGLISH, "Computer Science", "Artificial Intelligence",
                1, DegreeType.MASTER
        );

        ResearchEmployee researchEmployee = factory.createResearchEmployee(
                7,
                "researcher",
                "research123",
                "Lab Researcher",
                Language.ENGLISH,
                420000,
                "Research Lab"
        );

        TechSupportSpecialist techSupport = factory.createTechSupportSpecialist(
                8,
                "support",
                "support123",
                "IT Support Specialist",
                Language.ENGLISH,
                320000,
                "IT Department"
        );

        admin.addUser(admin, university);
        admin.addUser(manager, university);
        admin.addUser(professor, university);
        admin.addUser(tutor, university);
        admin.addUser(student, university);
        admin.addUser(graduateStudent, university);
        admin.addUser(researchEmployee, university);
        admin.addUser(techSupport, university);

        try {
            User loggedIn = authService.authenticate(
                    "student",
                    "student123",
                    university.getUsers()
            );

            logger.log(loggedIn, "Student authenticated successfully");
            System.out.println("Logged in: " + loggedIn.getFullName());
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }

        Course oop = new Course(
                "CS101",
                "Object-Oriented Programming",
                5,
                CourseType.MAJOR,
                "SITE",
                2,
                "Computer Science"
        );

        university.addCourse(oop);
        manager.addCourseForRegistration(oop);
        manager.assignCourseToTeacher(oop, professor);
        manager.assignCourseToTeacher(oop, tutor);

        Lesson lesson = new Lesson(
                LessonType.LECTURE,
                "Interfaces, Inheritance and Polymorphism",
                new Date(),
                "Room 101",
                professor,
                oop
        );

        oop.addLesson(lesson);

        student.registerForCourse(oop);

        boolean approved = manager.approveRegistration(student, oop);

        System.out.println("Course registration approved: " + approved);

        logger.log(manager, "Approved course registration for " + student.getFullName());

        Mark mark = new Mark(25, 25, 40);

        professor.putMark(student, oop, mark);

        student.calculateGPA();

        System.out.println(student.viewTranscript().getTranscriptInfo());

        student.rateTeacher(professor, 5.0);

        System.out.println("Professor average rating: " + professor.getAverageRating());

        ResearchPaper paper1 = new ResearchPaper(
                "AI in Education",
                "University Research Journal",
                12,
                new Date(),
                "10.1000/ai-education"
        );

        paper1.setCitations(10);
        paper1.addAuthor(professor.getResearcherProfile());
        professor.addResearchPaper(paper1);

        ResearchPaper paper2 = new ResearchPaper(
                "Smart Campus Systems",
                "Engineering Journal",
                8,
                new Date(),
                "10.1000/smart-campus"
        );

        paper2.setCitations(4);
        paper2.addAuthor(researchEmployee);
        researchEmployee.addResearchPaper(paper2);

        ResearchPaper paper3 = new ResearchPaper(
                "Learning Analytics",
                "Education Technology Journal",
                9,
                new Date(),
                "10.1000/learning-analytics"
        );

        paper3.setCitations(6);
        paper3.addAuthor(professor.getResearcherProfile());
        professor.addResearchPaper(paper3);

        ResearchPaper paper4 = new ResearchPaper(
                "Adaptive Online Courses",
                "Digital Education Journal",
                7,
                new Date(),
                "10.1000/adaptive-courses"
        );

        paper4.setCitations(5);
        paper4.addAuthor(professor.getResearcherProfile());
        professor.addResearchPaper(paper4);

        ResearchProject project = new ResearchProject("Smart University Research Project");

        try {
            project.addParticipant(professor.getResearcherProfile());
            project.addParticipant(researchEmployee);

            project.addPublishedPaper(paper1);
            project.addPublishedPaper(paper2);
            project.addPublishedPaper(paper3);
            project.addPublishedPaper(paper4);

            try {
                project.addParticipant("not a researcher");
            } catch (NotResearcherException e) {
                System.out.println("Expected exception: " + e.getMessage());
            }
        } catch (NotResearcherException e) {
            System.out.println("Research project error: " + e.getMessage());
        }

        graduateStudent.setSupervisor(professor.getResearcherProfile());
        graduateStudent.addDiplomaProject(paper1);

        System.out.println("Professor papers sorted by citations:");
        professor.printPapers(new ResearchPaperByCitationsComparator());

        System.out.println("Paper citation in plain text:");
        System.out.println(paper1.getCitation(CitationFormat.PLAIN_TEXT));

        System.out.println("Paper citation in BibTeX:");
        System.out.println(paper1.getCitation(CitationFormat.BIBTEX));

        Journal journal = new Journal("Research Bulletin");

        university.addJournal(journal);

        student.subscribeToJournal(journal);

        journal.publishPaper(paper1);

        university.announcePaper(paper1);

        News news = new News(
                "Research Day",
                "University research day will be held this Friday.",
                NewsTopic.RESEARCH
        );

        news.addComment(new Comment(student, "Great news!"));

        manager.addNews(news, university);

        Request request = professor.sendRequest("Projector does not work in Room 101");

        manager.addVisibleRequest(request);

        List<Request> newRequests = techSupport.viewNewRequests(manager.viewRequests());

        System.out.println("New requests viewed by tech support: " + newRequests.size());

        techSupport.acceptRequest(request);
        techSupport.markDone(request);

        System.out.println("Request status: " + request.getStatus());

        professor.sendMessage(manager, "Please review my course schedule.");

        professor.sendOfficialMessage(
                manager,
                "Exam Room Booking",
                "Please book Room 101 for the OOP final exam."
        );

        System.out.println("Top cited researcher: " + university.getTopCitedResearcher());

        System.out.println(
                "Top cited researcher by school SITE: "
                        + university.getTopCitedResearcherBySchool("SITE")
        );

        int currentYear = new Date().getYear() + 1900;

        System.out.println(
                "Top cited researcher of " + currentYear + ": "
                        + university.getTopCitedResearcherOfYear(currentYear)
        );

        Report academicReport = manager.createStatisticsReport(university.getCourses());

        System.out.println(academicReport.generate());

        Report researchReport = university.generateResearchReport();

        System.out.println(researchReport.generate());

        logger.log(admin, "Users were added to the university");
        logger.log(professor, "Professor put mark and published paper");

        System.out.println("Logs:");

        for (LogRecord log : admin.viewLogs(logger)) {
            System.out.println(log);
        }

        Database database = Database.getInstance();

        database.setFilePath("university_demo_data.ser");
        database.saveData(university);

        University loadedUniversity = database.loadData();

        System.out.println("Loaded university: " + loadedUniversity);

        authService.logout(student);

        System.out.println("Demo finished successfully.");
    }
}