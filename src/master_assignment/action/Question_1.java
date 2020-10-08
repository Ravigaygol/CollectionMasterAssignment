package master_assignment.action;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import master_assignment.bean.Academy;
import master_assignment.bean.Attendance;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question_1 {
	public static void Ques1() {
		// write method to delete a student using student name.
		// delete from studlist,attendance list and test list
		Student s1 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
		Student s2 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
		Student s3 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
		Student s4 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
		Student s5 = new Student(102, "jayesh", 9803112660L, "jayesh@gmail.com");

		Academy.studentMap.put(1, Arrays.asList(s5));
		Academy.studentMap.put(2, Arrays.asList(s4));
		Academy.studentMap.put(3, Arrays.asList(s1));
		Academy.studentMap.put(4, Arrays.asList(s3));
		Academy.studentMap.put(5, Arrays.asList(s2));

		Attendance a1 = new Attendance(21, 102, "A", new Date(2020, 19, 02));
		Attendance a2 = new Attendance(22, 105, "P", new Date(2020, 20, 03));
		Attendance a3 = new Attendance(23, 101, "A", new Date(2020, 21, 04));
		Attendance a4 = new Attendance(24, 103, "P", new Date(2020, 22, 05));
		Attendance a5 = new Attendance(25, 104, "A", new Date(2020, 23, 06));

		Academy.attendanceMap.put(1, Arrays.asList(a5));
		Academy.attendanceMap.put(2, Arrays.asList(a4));
		Academy.attendanceMap.put(3, Arrays.asList(a1));
		Academy.attendanceMap.put(4, Arrays.asList(a3));
		Academy.attendanceMap.put(5, Arrays.asList(a2));

		TestResult t1 = new TestResult(new Date(2020, 5, 10), 20, 102, 80, 100);
		TestResult t2 = new TestResult(new Date(2020, 5, 10), 21, 105, 85, 100);
		TestResult t3 = new TestResult(new Date(2020, 5, 10), 22, 101, 84, 100);
		TestResult t4 = new TestResult(new Date(2020, 5, 10), 23, 103, 93, 100);
		TestResult t5 = new TestResult(new Date(2020, 5, 10), 24, 104, 94, 100);

		Academy.test_map.put(1, Arrays.asList(t5));
		Academy.test_map.put(2, Arrays.asList(t4));
		Academy.test_map.put(3, Arrays.asList(t1));
		Academy.test_map.put(4, Arrays.asList(t3));
		Academy.test_map.put(5, Arrays.asList(t2));
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Name to delete from lists:?");
		String name = sc.next();

		Iterator<Map.Entry<Integer, List<Student>>> si = Academy.studentMap.entrySet().iterator();
		Iterator<Map.Entry<Integer, List<Attendance>>> ai = Academy.attendanceMap.entrySet().iterator();
		Iterator<Map.Entry<Integer, List<TestResult>>> ti = Academy.test_map.entrySet().iterator();
		while (si.hasNext()) {
			List<Student> s = si.next().getValue();
			for (Student st : s) {
				if (st.getstudent_name().equalsIgnoreCase(name)) {
					si.remove();
					while (ai.hasNext()) {
						List<Attendance> a = ai.next().getValue();
						for (Attendance at : a) {
							if (at.getStudId() == st.getStudent_id()) {
								ai.remove();
								while (ti.hasNext()) {
									List<TestResult> t = ti.next().getValue();
									for (TestResult tt : t) {
										if (tt.getStudentId() == st.getStudent_id()) {
											ti.remove();

										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(Academy.studentMap);
		System.out.println("**********************************");
		System.out.println(Academy.attendanceMap);
		System.out.println("**********************************");
		System.out.println(Academy.test_map);
		sc.close();
	}
}
