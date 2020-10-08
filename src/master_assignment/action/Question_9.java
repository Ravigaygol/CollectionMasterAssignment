package master_assignment.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;

public class Question_9 {

	public static void Ques9() {
		// if stud is being added again on mobile no uniqueness to any course show error
		// that student already enrolled.


		Student s1 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
		Student s2 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
		Student s3 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
		Student s4 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
		Student s5 = new Student(102, "Ravi", 9803112660L, "Ravi@gmail.com");

		Academy.studentMap.put(1, Arrays.asList(s5));
		Academy.studentMap.put(2, Arrays.asList(s4));
		Academy.studentMap.put(3, Arrays.asList(s1));
		Academy.studentMap.put(4, Arrays.asList(s3));
		Academy.studentMap.put(5, Arrays.asList(s2));

		boolean flag = false;
		HashMap<String, String> hm = new HashMap<>();
		try {
			for (Map.Entry<Integer, List<Student>> stud : Academy.studentMap.entrySet()) {
				List<Student> st = stud.getValue();
				for (Student s : st) {
					if (hm.containsKey(s.getstudent_name())) {
						String email = hm.get(s.getstudent_name());
						if (s.getEmail() == email) {
							System.out.println(s);
							flag = true;
							throw new RepeatedEntryException();
						}

					} else {
						hm.put(s.getstudent_name(), s.getEmail());
					}
				}
			}
		} catch (RepeatedEntryException e) {
			System.out.println(e.getMessage());
		}

		if (flag != true)
			System.out.println("All are unique entries.....");
	}

}
