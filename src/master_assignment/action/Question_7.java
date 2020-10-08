package master_assignment.action;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import master_assignment.bean.Academy;
import master_assignment.bean.TestResult;

public class Question_7 {
	public static void Ques7() {
		/*
		 * create hashmap of student object, total marks from all tests for one course
		 * id sent in input and then print the response
		 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Course ID Whose Test Result You Want To See?");
		Integer courseid = sc.nextInt();// 1

		Integer total = 0;
		for (Map.Entry<Integer, List<TestResult>> e : Academy.test_map.entrySet()) {
			if (e.getKey().equals(courseid)) {
				List<TestResult> tr = e.getValue();
				for (TestResult t : tr) {
					total += t.marks;
				}
			}
		}
		System.out.println("Total Marks For All The Tests For Course Id : " + courseid + " ---> " + total);

	}

}
