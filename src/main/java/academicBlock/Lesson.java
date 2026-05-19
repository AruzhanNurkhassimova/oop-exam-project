package academicBlock;

import Enums.LessonType;
import Roles.Teacher;
import java.io.Serializable;
import java.util.Date;

public class Lesson implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private LessonType lessonType;
	 private String topic;
	 private Date date;
	 private String room;
	 private Teacher instructor;
	 private Course course;
	 
	 public Lesson(LessonType lessonType, String topic, Date date, String room, Teacher instructor, Course course) {
		 this.lessonType = lessonType;
		 this.topic = topic;
		 this.date = date;
		 this.room = room;
		 this.instructor = instructor;
		 this.course = course;
	 }
	 
	 public LessonType getLessonType() { return lessonType;}
	 public String getTopic() { return topic; }
	 public Date getDate() { return date; }
	 public String getRoom() { return room; }
	 public Teacher getInstructor() { return instructor; }
	 public Course getCourse() { return course; }

	 public void setTopic(String topic) { this.topic = topic; }
	 public void setDate(Date date) { this.date = date; }
	 public void setRoom(String room) { this.room = room; }
	 public void setInstructor(Teacher instructor) { this.instructor = instructor; }
	 
	 public String getInfo() {
		 return lessonType + ": " + topic + " in " + room + " for " + course.getCourseCode();
	 }
	 @Override
	 public String toString() {
	 return getInfo();
	 }
}

