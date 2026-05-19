package System;

import Enums.*;
import Roles.*;

public class UserFactory {
    public Student createStudent(int id, String login, String password, String fullName,
                                 Language language, String major, String minor, int yearOfStudy) {
        return new Student(id, login, password, fullName, language, major, minor, yearOfStudy);
    }

    public GraduateStudent createGraduateStudent(int id, String login, String password, String fullName,
                                                 Language language, String major, String minor,
                                                 int yearOfStudy, DegreeType degreeType) {
        return new GraduateStudent(id, login, password, fullName, language, major, minor, yearOfStudy, degreeType);
    }

    public Teacher createTeacher(int id, String login, String password, String fullName,
                                 Language language, double salary, String department,
                                 TeacherTitle title, String school) {
        return new Teacher(id, login, password, fullName, language, salary, department, title, school);
    }

    public Manager createManager(int id, String login, String password, String fullName,
                                 Language language, double salary, String department,
                                 ManagerType managerType) {
        return new Manager(id, login, password, fullName, language, salary, department, managerType);
    }

    public Admin createAdmin(int id, String login, String password, String fullName,
                             Language language, double salary, String department) {
        return new Admin(id, login, password, fullName, language, salary, department);
    }

    public TechSupportSpecialist createTechSupportSpecialist(int id, String login, String password,
                                                             String fullName, Language language,
                                                             double salary, String department) {
        return new TechSupportSpecialist(id, login, password, fullName, language, salary, department);
    }

    public ResearchEmployee createResearchEmployee(int id, String login, String password,
                                                   String fullName, Language language,
                                                   double salary, String department) {
        return new ResearchEmployee(id, login, password, fullName, language, salary, department);
    }
}