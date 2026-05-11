package Roles;
import java.util.*;
import Enums.*;

public abstract class Employee extends User {
	 private double salary;
	 private String department;
	 private Date hireDate;
	 
	 private List<Message> messages = new ArrayList<>();
	 
	 public Employee(int id, String login, String password, String fullName, Language language, double salary, String department, Date hireDate) {
		 super(id, login, password, fullName, language);
		 this.salary = salary;
		 this.department = department;
		 this.hireDate = hireDate;
	 }
	 
	 public double getSalary() { return salary; }
	 public String getDepartment() { return department; }
	 public Date getHireDate() { return hireDate; }
	 
	 public void setSalary(double salary) {}
	 public void setDepartment(String department) {}
	 
	 public Message sendMessage(Employee receiver, String text) {}
	 public List<Message> viewMessages() { return messages; }
	 public Request sendRequest(String description) {}
	}

