package academicBlock;

import java.util.*;
import java.io.Serializable;

public class Lesson implements Serializable {
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
	 
	 public LessonType getLessonType() { return lessonType; }
	 
	 public String getTopic() { return topic; }
	 public Date getDate() { return date; }
	 public String getRoom() { return room; }
	 public Teacher getInstructor() { return instructor; }
	 public Course getCourse() { return course; }
	 
	 public void setTopic(String topic) {}
	 public void setDate(Date date) {}
	 public void setRoom(String room) {}
	 public void setInstructor(Teacher instructor) {}
	 
	 public String getInfo() {}
}

