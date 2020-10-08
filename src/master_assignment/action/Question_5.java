package master_assignment.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question_5 {
	public static void Ques5() {
		// show poor performing students (marks <40%) across all tests for a course id.

		System.out.println("List Of Poor Performing Students...");

		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			float total = 0;
			List<TestResult> t = e.getValue();
			Iterator<TestResult> i = t.iterator();
			while (i.hasNext()) {
				TestResult r = i.next();
				total += r.getMarks();
			}
			float per = total / 500 * 100;
	
			if (per < 40) {
				int courseid = e.getKey();
				List<TestResult> test = e.getValue();
				Iterator<TestResult> i1 = test.iterator();

				while (i1.hasNext()) {
					int sid = i1.next().studentId;
					for (Map.Entry<Integer, List<Student>> s : Academy.studentMap.entrySet()) {
						List<Student> st = s.getValue();
						for (Student ss : st) {
							if (ss.getStudent_id() == sid) {
								System.out.println("Course Id :" + courseid + " Student Name : " + ss.getstudent_name());

							}
						}
					}
				}
			}
		}
	}
}
