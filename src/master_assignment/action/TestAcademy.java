package master_assignment.action;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import master_assignment.bean.*;

class RepeatedEntryException extends RuntimeException {
	public RepeatedEntryException() {
		super("Above Student Entry is Repeated.......!");
	}
	public RepeatedEntryException(String msg) {
		super(msg);
	}
}

public class TestAcademy {
	public static void main(String[] args) {
		Course c1 = new Course(1, "Java", new Date(2020, 05, 01), "Civil", 10000, "2 months");
		Course c2 = new Course(2, "Adv java", new Date(2020, 05, 02), "IT", 20000, "3 months");
		Course c3 = new Course(3, "C++", new Date(2020, 05, 03), "Computer", 15000, "2 months");
		Course c4 = new Course(4, "C", new Date(2020, 05, 04), "IT", 5000, "4 months");
		Course c5 = new Course(5, "HTML", new Date(2020, 05, 05), "ENTC", 50000, "6 months");

		Academy.courseList.add(c1);
		Academy.courseList.add(c2);
		Academy.courseList.add(c3);
		Academy.courseList.add(c4);
		Academy.courseList.add(c5);

		Student s1 = new Student(101, "Ravi", 9403112660L, "Ravi@gmail.com");
		Student s2 = new Student(104, "Ajay", 9503112660L, "Ajay@gmail.com");
		Student s3 = new Student(103, "Manthan", 9603112660L, "Manthan@gmail.com");
		Student s4 = new Student(105, "Smith", 9703112660L, "smith@gmail.com");
		Student s5 = new Student(102, "jayesh", 9803112660L, "jayesh@gmail.com");
		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(s5);
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

		Attendance a1 = new Attendance(11, 102, "P", new Date(2020, 07, 03));
		Attendance a2 = new Attendance(12, 105, "A", new Date(2020, 07, 04));
		Attendance a3 = new Attendance(13, 101, "P", new Date(2020, 07, 05));
		Attendance a4 = new Attendance(14, 103, "P", new Date(2020, 07, 06));
		Attendance a5 = new Attendance(15, 104, "A", new Date(2020, 07, 07));

		ArrayList<Attendance> att1 = new ArrayList<>();
		att1.add(a5);
		ArrayList<Attendance> att2 = new ArrayList<>();
		att1.add(a4);
		ArrayList<Attendance> att3 = new ArrayList<>();
		att1.add(a1);
		ArrayList<Attendance> att4 = new ArrayList<>();
		att1.add(a3);
		ArrayList<Attendance> att5 = new ArrayList<>();
		att1.add(a2);

		Academy.attendanceMap.put(1, att1);
		Academy.attendanceMap.put(2, att2);
		Academy.attendanceMap.put(3, att3);
		Academy.attendanceMap.put(4, att4);
		Academy.attendanceMap.put(5, att5);
		//C 1
		TestResult t1 = new TestResult(new Date(2020, 07, 01), 10, 101, 90, 100);
		TestResult t2 = new TestResult(new Date(2020, 07, 01), 10, 104, 91, 100);
		TestResult t3 = new TestResult(new Date(2020, 07, 01), 10, 103, 90, 100);
		TestResult t4 = new TestResult(new Date(2020, 07, 01), 10, 105, 93, 100);
		TestResult t5 = new TestResult(new Date(2020, 07, 01), 10, 102, 94, 100);
		//C 2
		TestResult t6 = new TestResult(new Date(2020, 07, 01), 20, 101, 80, 100);
		TestResult t7 = new TestResult(new Date(2020, 07, 01), 20, 104, 80, 100);
		TestResult t8 = new TestResult(new Date(2020, 07, 01), 20, 103, 80, 100);
		TestResult t9 = new TestResult(new Date(2020, 07, 01), 20, 105, 83, 100);
		TestResult t10 = new TestResult(new Date(2020, 07, 01), 20, 102, 84, 100);
		//C 3
		TestResult t11 = new TestResult(new Date(2020, 07, 01), 30, 101, 70, 100);
		TestResult t12 = new TestResult(new Date(2020, 07, 01), 30, 104, 71, 100);
		TestResult t13 = new TestResult(new Date(2020, 07, 01), 30, 103, 72, 100);
		TestResult t14 = new TestResult(new Date(2020, 07, 01), 30, 105, 73, 100);
		TestResult t15 = new TestResult(new Date(2020, 07, 01), 30, 102, 74, 100);
		//C 4
		TestResult t16 = new TestResult(new Date(2020, 07, 01), 40, 101, 63, 100);
		TestResult t17 = new TestResult(new Date(2020, 07, 01), 40, 104, 60, 100);
		TestResult t18 = new TestResult(new Date(2020, 07, 01), 40, 103, 64, 100);
		TestResult t19 = new TestResult(new Date(2020, 07, 01), 40, 105, 61, 100);
		TestResult t20 = new TestResult(new Date(2020, 07, 01), 40, 102, 65, 100);
		//C 5
		TestResult t21 = new TestResult(new Date(2020, 07, 01), 50, 101, 40, 100);
		TestResult t22 = new TestResult(new Date(2020, 07, 01), 50, 104, 39, 100);
		TestResult t23 = new TestResult(new Date(2020, 07, 01), 50, 103, 40, 100);
		TestResult t24 = new TestResult(new Date(2020, 07, 01), 50, 105, 35, 100);
		TestResult t25 = new TestResult(new Date(2020, 07, 01), 50, 102, 38, 100);

		ArrayList<TestResult> te1 = new ArrayList<>();
		te1.add(t1);
		te1.add(t2);
		te1.add(t3);
		te1.add(t4);
		te1.add(t5);
		ArrayList<TestResult> te2 = new ArrayList<>();
		te2.add(t6);
		te2.add(t7);
		te2.add(t8);
		te2.add(t9);
		te2.add(t10);
		ArrayList<TestResult> te3 = new ArrayList<>();
		te3.add(t11);
		te3.add(t12);
		te3.add(t13);
		te3.add(t14);
		te3.add(t15);
		ArrayList<TestResult> te4 = new ArrayList<>();
		te4.add(t16);
		te4.add(t17);
		te4.add(t18);
		te4.add(t19);
		te4.add(t20);
		ArrayList<TestResult> te5 = new ArrayList<>();
		te5.add(t21);
		te5.add(t22);
		te5.add(t23);
		te5.add(t24);
		te5.add(t25);

		Academy.test_map.put(1, te1);
		Academy.test_map.put(2, te2);
		Academy.test_map.put(3, te3);
		Academy.test_map.put(4, te4);
		Academy.test_map.put(5, te5);

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

		ArrayList<Transaction> trans1 = new ArrayList<>();
		trans1.add(tr1);
		trans1.add(tr2);
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
		
//System.out.println("Question 1-: write method to delete a student using student name.\n delete from studlist, attendance list and test list");		
//System.out.println();
//Question_1 q=new Question_1();
//         q.Ques1();
		
//System.out.println("Question 2-: show most favoured course based on number of students enrolled.\n (Course with maximum students)");		
//System.out.println();
//         Question_2 q=new Question_2();
//		q.Ques2();
		
//System.out.println("Question 3-: find our loyal students, use LinkedHashMap in order to \n find out those  first 3 students across courses who paid full fees");	
//System.out.println();
//		 Question_3 q=new Question_3();
//		 q.Ques3();
		
//System.out.println("Question 4-: use TreeSet to store course details on fees from highest to lowest fees \n and printing the treemap output with course details.");
//System.out.println();
//	 Question_4 q=new Question_4();
//		 q.Ques4();
		
//System.out.println("Question 5-: show poor performing students (marks <40%) across all tests for a course id.");
//System.out.println();
//		Question_5 q=new Question_5();
//		 q.Ques5();
		
//System.out.println("Question 6-: add all student names in one place and print all unique student names");
//System.out.println();
//		 Question_6 q=new Question_6();
//		 q.Ques6();
		
//	System.out.println("Question 7-: create hashmap of student object, total marks from all tests for one \n course id sent in input and then print the response");
//    System.out.println();
//	 Question_7 q=new Question_7();
//		 q.Ques7();
	
//System.out.println("Question 8-: show sorting options on course cname or startDate or subject or \n fees and in response print all details of course");
//System.out.println();
//		 Question_8 q=new Question_8();
//		 q.Ques8();
		
//System.out.println("Question 9-: if stud is being added again on mobile no uniqueness to any course \n show error that student already enrolled.");
//System.out.println();
//		 Question_9 q=new Question_9();
//		 q.Ques9();
		
//System.out.println("Question 10-: show student result for course id and test id sorted from \n topper to lowest marks. If student marks are equal sort on their names");
//System.out.println();
//		 Question_10 q=new Question_10();
//		 q.Ques10();
		
//System.out.println("Question 11-: Show one table which has course name , course start date \n and total students, total revenue till date, total left fees, total projected revenue, percentage collection till date");
//System.out.println();
//		 Question_11 q=new Question_11();
//		 q.Ques11();
		
//System.out.println("Question 13-: move student from one course to another. Delete his past  \n attendance all records, test series records but transaction record maintain it . Show it against new course id");
//System.out.println();
//		 Question_13 q=new Question_13();
//    	 q.Ques13();
		
//System.out.println("Question 14-:  Show the students from a course who have not paid any fees \n till date which  takes course id as input and shows all students registered for this course.");
//System.out.println();
//		 Question_14 q=new Question_14();
//		 q.Ques14();
		
//System.out.println("Question 15-: to delete a transaction. Note transaction all records across all beans should be deleted.");
//System.out.println();
//		 Question_15 q=new Question_15();
//	 q.Ques15();
	}
}