package master_assignment.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.Transaction;

public class Question_3 {
	public static void Ques3() {

		// find our loyal students, use LinkedHashMap in order to find out those first 3
		// students across courses who paid full fees.

		LinkedHashMap<Integer, Integer> l = new LinkedHashMap<>();
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
		for (Map.Entry<Integer, List<Transaction>> e : Academy.transactionMap.entrySet()) {
			List<Transaction> tr = e.getValue();
			for (Transaction t : tr) {
				if (l.containsKey(t.studId)) {
					l.put(t.studId, l.get(t.studId) + t.paidfees);
				} else {
					l.put(t.studId, t.paidfees);
				}
			}
		}

		for (Map.Entry<Integer, List<Transaction>> e : Academy.transactionMap.entrySet()) {
			List<Transaction> tr = e.getValue();
			for (Transaction t : tr) {
				Integer id = t.studId;
				for (Map.Entry<Integer, Integer> e1 : l.entrySet()) {
					Integer cfees = e1.getValue();
					if (e1.getKey() == id) {
						Integer cid = e.getKey();
						for (Course c : Academy.courseList) {
							if (c.courseId == cid) {
								if (c.courseFees == cfees) {
									for (Map.Entry<Integer, List<Student>> e2 : Academy.studentMap.entrySet()) {
										List<Student> st = e2.getValue();
										for (Student s : st) {
											if (s.getStudent_id() == id) {
												lhm.put(s.getStudent_id(), s.getstudent_name());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		int i = 1;
		for (Map.Entry<Integer, String> e : lhm.entrySet()) {
			if (i <= 3) {
				System.out.println(e.getKey() + "  " + e.getValue());
				i++;
			} else
				break;

		}

	}

}
