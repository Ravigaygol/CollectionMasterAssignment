package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import master_assignment.bean.Academy;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;
import master_assignment.bean.Transaction;

public class Question_14 {
	public static void Ques14() {
		/*
		 * Show the students from a course who have not paid any fees till date which
		 * takes course id as input and shows all students registered for this course.
		 */

		Transaction tr1 = new Transaction(000, 102, new Date(2020, 05, 01));
		Transaction tr2 = new Transaction(000, 105, new Date(2020, 05, 01));
		Transaction tr3 = new Transaction(5000, 101, new Date(2020, 05, 01));
		Transaction tr4 = new Transaction(5000, 103, new Date(2020, 05, 01));
		Transaction tr5 = new Transaction(5000, 104, new Date(2020, 05, 01));

		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);

		ArrayList<Transaction> trans2 = new ArrayList<>();
		trans2.add(tr2);

		ArrayList<Transaction> trans3 = new ArrayList<>();
		trans3.add(tr3);

		ArrayList<Transaction> trans4 = new ArrayList<>();
		trans4.add(tr4);

		ArrayList<Transaction> trans5 = new ArrayList<>();
		trans5.add(tr5);

		Academy.transactionMap.put(1, trans1);
		Academy.transactionMap.put(2, trans2);
		Academy.transactionMap.put(3, trans3);
		Academy.transactionMap.put(4, trans4);
		Academy.transactionMap.put(5, trans5);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Id : ");
		Integer courseid = sc.nextInt();
		System.out.println("Students Registered For This Course...");
		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			if (e.getKey() == courseid) {
				List<TestResult> t = e.getValue();
				for (TestResult tt : t) {
					Integer sid = tt.studentId;
					for (Map.Entry<Integer, List<Transaction>> e1 : Academy.transactionMap.entrySet()) {
						List<Transaction> tr = e1.getValue();
						for (Transaction trans : tr) {
							if (trans.studId == sid) {
								for (Map.Entry<Integer, List<Student>> e2 : Academy.studentMap.entrySet()) {
									List<Student> st = e2.getValue();
									for (Student s : st) {

										if (s.getStudent_id() == sid) {
											if (trans.paidfees == 0) {
												System.out.println("Students Who Has Not Paid Any Fees...");
												System.out.println("Student Name : " + s.getstudent_name() + "-->"
														+ "Student ID : " + s.getStudent_id());
											} else {
												System.out.println("Student Name : " + s.getstudent_name() + "-->"
														+ "Student ID : " + s.getStudent_id());
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

	}

}
