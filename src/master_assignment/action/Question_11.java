package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.Transaction;

public class Question_11 {
	public static void Ques11() {
		/*
		 * Show one table which has course name , course start date and total students,
		 * total revenue till date, total left fees, total projected revenue, percentage
		 * collection till date
		 */


		Student s1 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
		Student s2 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
		Student s3 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
		Student s4 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
		Student s5 = new Student(102, "jayesh", 9803112660L, "jayesh@gmail.com");
		Student s6 = new Student(106, "X", 9903112660L, "X@gmail.com");
		Student s7 = new Student(107, "Y", 9904112660L, "Y@gmail.com");

		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(s5);
		al1.add(s6);
		al1.add(s7);
		ArrayList<Student> al2 = new ArrayList<>();
		al2.add(s4);
		ArrayList<Student> al3 = new ArrayList<>();
		al3.add(s1);
		ArrayList<Student> al4 = new ArrayList<>();
		al4.add(s3);
		ArrayList<Student> al5 = new ArrayList<>();
		al5.add(s2);

		Academy.studentMap.put(1, al1);
		Academy.studentMap.put(2, al2);
		Academy.studentMap.put(3, al3);
		Academy.studentMap.put(4, al4);
		Academy.studentMap.put(5, al5);

		Transaction tr1 = new Transaction(5000, 102, new Date(2020, 05, 01));
		Transaction tr2 = new Transaction(5000, 102, new Date(2020, 06, 05));
		Transaction tr3 = new Transaction(10000, 105, new Date(2020, 05, 01));
		Transaction tr4 = new Transaction(10000, 105, new Date(2020, 06, 05));
		Transaction tr5 = new Transaction(5000, 101, new Date(2020, 05, 01));
		Transaction tr6 = new Transaction(5000, 101, new Date(2020, 06, 05));
		Transaction tr7 = new Transaction(2500, 103, new Date(2020, 05, 01));
		Transaction tr8 = new Transaction(2500, 103, new Date(2020, 06, 05));
		Transaction tr9 = new Transaction(25000, 104, new Date(2020, 05, 01));
		Transaction tr10 = new Transaction(25000, 104, new Date(2020, 06, 05));
		Transaction tr11 = new Transaction(1000, 106, new Date(2020, 06, 05));
		Transaction tr12 = new Transaction(2000, 107, new Date(2020, 06, 05));

		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);
		trans1.add(tr2);
		trans1.add(tr11);
		trans1.add(tr12);
		ArrayList<Transaction> trans2 = new ArrayList<>();
		trans2.add(tr3);
		trans2.add(tr4);
		ArrayList<Transaction> trans3 = new ArrayList<>();
		trans3.add(tr5);
		trans3.add(tr6);
		ArrayList<Transaction> trans4 = new ArrayList<>();
		trans4.add(tr7);
		trans4.add(tr8);
		ArrayList<Transaction> trans5 = new ArrayList<>();
		trans5.add(tr9);
		trans5.add(tr10);

		Academy.transactionMap.put(1, trans1); // Ques15
		Academy.transactionMap.put(2, trans2);
		Academy.transactionMap.put(3, trans3);
		Academy.transactionMap.put(4, trans4);
		Academy.transactionMap.put(5, trans5);

		for (Course c : Academy.courseList) {
			String coursename = c.course_name;
			Date coursedate = c.startDate;
			System.out.println("List Of Students For : " + coursename + " are as follows");
			for (Map.Entry<Integer, List<Student>> e : Academy.studentMap.entrySet()) {
				int count = 0;
				List<Student> st = e.getValue();
				for (Student s : st) {
					count++;
				}
				if (c.courseId == e.getKey()) {
					System.out.println(e.getValue());
					for (Map.Entry<Integer, List<Transaction>> e1 : Academy.transactionMap.entrySet()) {
						if (c.courseId == e1.getKey()) {
							List<Transaction> tr = e1.getValue();
							float total_revenue = 0;
							float total_fees_left = 0;
							float projected_revenue = 0;
							for (Transaction t : tr) {
								projected_revenue = count * c.courseFees;
								total_revenue = total_revenue + t.paidfees;
								total_fees_left = projected_revenue - total_revenue;
							}
							System.out.println("Total Revenue Till Date = " + total_revenue);
							System.out.println("Total Fees Left = " + total_fees_left);
							System.out.println("Total Projected Revenue = " + projected_revenue);
							System.out.println("Total Collection int % Till Date = "
									+ (total_revenue / projected_revenue) * (100) + " % ");
							System.out.println("***************************************************************");
							System.out.println();
						}
					}
				}
			}
		}

	}


}
