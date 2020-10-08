package master_assignment.action;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question_10 {

	public static void Ques10() {

		/*
		 * show student result for course id and test id sorted from topper to lowest
		 * marks. If student marks are equal sort on their names
		 */

		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			List<TestResult> tr = e.getValue();
			System.out.println("Result For Course Id : " + e.getKey());
			TreeSet<TestResult> tset = new TreeSet<>(new Comparator<TestResult>() {

				@Override
				public int compare(TestResult o1, TestResult o2) {

					if (o1.marks < o2.marks)
						return 1;
					else if (o1.marks > o2.marks)
						return -1;
					else {
						String str1 = "";
						String str2 = "";
						for (Map.Entry<Integer, List<Student>> e1 : Academy.studentMap.entrySet()) {
							List<Student> st = e1.getValue();
							for (Student s : st) {
								if (s.getStudent_id() == o1.studentId) {
									str1 = s.getstudent_name();
									for (Student s1 : st) {
										if (s1.getStudent_id() == o2.studentId) {

											str2 = s1.getstudent_name();
										}
									}
								}
							}
						}

						return str1.compareTo(str2);
					}
				}

			});

			tset.addAll(tr);

			for (TestResult t : tset) {
				for (Map.Entry<Integer, List<Student>> e1 : Academy.studentMap.entrySet()) {
					List<Student> s = e1.getValue();
					for (Student st : s) {
						if (st.getStudent_id() == t.studentId) {
							System.out.println("Student Name : " + st.getstudent_name() + "-->" + " Student Id : "
									+ t.studentId + "-->" + "Test Id : " + t.testid + "-->" + "Marks : " + t.marks);
						}
					}

				}

			}

		}
	}


}
