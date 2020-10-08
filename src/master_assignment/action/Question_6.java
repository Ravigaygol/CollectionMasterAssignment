package master_assignment.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;

public class Question_6 {

	public static void Ques6() {
		// add all student names in one place and print all unique student names

		Student s1 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
		Student s2 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
		Student s3 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
		Student s4 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
		Student s5 = new Student(102, "jayesh", 9803112660L, "jayesh@gmail.com");
		Student s6 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");

		Academy.studentMap.put(1, Arrays.asList(s5, s6));
		Academy.studentMap.put(2, Arrays.asList(s4));
		Academy.studentMap.put(3, Arrays.asList(s1));
		Academy.studentMap.put(4, Arrays.asList(s3));
		Academy.studentMap.put(5, Arrays.asList(s2));

		ArrayList<String> al = new ArrayList<>();
		Map<Integer, List<Student>> s = new HashMap<>(Academy.studentMap);
		for (Map.Entry<Integer, List<Student>> obj : s.entrySet()) {
			List<Student> st = obj.getValue();
			for (Student ss : st) {
				String name = ss.getstudent_name();

				if (!al.contains(name))
					al.add(name);
			}

		}
		System.out.println(al);
	}


}
