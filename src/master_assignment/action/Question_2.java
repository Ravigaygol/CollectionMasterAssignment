package master_assignment.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;

public class Question_2 {
	public static void Ques2() {
	// show most favoured course based on number of students enrolled. (Course with
	// maximum students)

	Student s1 = new Student(107, "john", 12345, "john@gmail.com");
	Student s2 = new Student(109, "smith", 12346, "smith@gmail.com");
	Student s3 = new Student(110, "robin", 12347, "robin@gmail.com");
	Student s4 = new Student(106, "james", 12348, "james@gmail.com");
	Student s5 = new Student(108, "ronald", 12349, "ronald@gmail.com");
	Student s6 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
	Student s7 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
	Student s8 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
	Student s9 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
	Student s10 = new Student(102, "jayesh", 9803112660L, "jayesh@gmail.com");
	Academy.studentMap.put(1, Arrays.asList(s1, s2));
	Academy.studentMap.put(2, Arrays.asList(s1, s2, s3, s4));
	Academy.studentMap.put(3, Arrays.asList(s1, s2, s3));
	Academy.studentMap.put(4, Arrays.asList(s1, s2));
	Academy.studentMap.put(5, Arrays.asList(s6, s7, s8, s9, s10));

	int max = 0;
	int c = 0;

	for (Map.Entry<Integer, List<Student>> obj : Academy.studentMap.entrySet()) {
		if (obj.getValue().size() > max) {
			max = obj.getValue().size();
			c = obj.getKey();

		}
	}
	for (Course ob : Academy.courseList) {
		if (ob.courseId == c) {
			System.out.println("Course Name = " + ob.course_name);
			System.out.println("Number Of Students = " + max);
		}
	}

}

}
