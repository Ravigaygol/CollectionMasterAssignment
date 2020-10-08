package master_assignment.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import master_assignment.bean.Academy;
import master_assignment.bean.Attendance;
import master_assignment.bean.Course;
import master_assignment.bean.Student;
import master_assignment.bean.TestResult;

public class Question_13 {
	public static void Ques13() {
	/*
	 * move student from one course to another. Delete his past attendance all
	 * records, test series records but transaction record maintain it . Show it
	 * against new course id
	 */

	Course c1 = new Course(1, "Java", new Date(2020, 05, 01), "Computer", 10000, "2 months");// 11
	Course c2 = new Course(2, "Adv java", new Date(2020, 05, 02), "IT", 20000, "3 months");// 12
	Course c3 = new Course(3, "Python", new Date(2020, 05, 03), "Computer", 15000, "2 months");// 13
	Course c4 = new Course(4, "Networking", new Date(2020, 05, 04), "IT", 5000, "4 months");// 14
	Course c5 = new Course(5, "Full Stack Developer", new Date(2020, 05, 05), "ENTC", 50000, "6 months");// 15
	Course c6 = new Course(6, "Embedded Developer", new Date(2020, 05, 06), "ENTC", 50000, "6 months");// For
																										// Ques-13

	Academy.courseList.add(c1);
	Academy.courseList.add(c2);
	Academy.courseList.add(c3);
	Academy.courseList.add(c4);
	Academy.courseList.add(c5);
	Academy.courseList.add(c6); // For Ques-13


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

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Student Id :");
	Integer studentid = sc.nextInt();

	ConcurrentHashMap<Integer, List<Student>> chm = new ConcurrentHashMap<>(Academy.studentMap);
	Iterator<Map.Entry<Integer, List<Student>>> itr = chm.entrySet().iterator();
	System.out.println("**************************************************************");
	System.out.println("Map Before Moving A Student From One Course To Another...");
System.out.println("**************************************************************");

System.out.println(chm);

System.out.println();
	System.out.println("**************************************************************");
	System.out.println("Map After Moving A Student From One Course To Another...");
System.out.println("**************************************************************");
	while (itr.hasNext()) {
		List<Student> st = itr.next().getValue();
		for (int j = 0; j < st.size(); j++) {
			if (st.get(j).getStudent_id() == studentid) {
				ArrayList<Student> stud = new ArrayList<Student>();
				stud.add(st.get(j));
				Academy.studentMap.put(6, stud);
				// System.out.println(Academy.studentMap);
				st.remove(j);
		/*		for(Entry<Integer, List<Student>> e:Academy.studentMap.entrySet())
				{
				System.out.println("Key :"+e.getKey()+"  Value :"+e.getValue());	
				}*/
				System.out.println(Academy.studentMap);
			}
		}
	}

	Iterator<Map.Entry<Integer, List<Attendance>>> i1 = Academy.attendanceMap.entrySet().iterator();
	while (i1.hasNext()) {
		List<Attendance> att = i1.next().getValue();
		Iterator<Attendance> aa = att.iterator();
		while (aa.hasNext()) {
			Attendance a = aa.next();
			if (a.studId == studentid) {
				aa.remove();
			}
		}
	}
	System.out.println("**************************************************************");
	System.out.println("Map After Deleting Attendance Records...");
	System.out.println("**************************************************************");
	/*for(Entry<Integer, List<Attendance>> ee:Academy.attendanceMap.entrySet())
	{
	System.out.println("Key :"+ee.getKey()+"  Value :"+ee.getValue());	
	}*/

	System.out.println(Academy.attendanceMap);

	Iterator<Map.Entry<Integer, List<TestResult>>> i2 = Academy.test_map.entrySet().iterator();
	while (i2.hasNext()) {
		List<TestResult> t = i2.next().getValue();
		Iterator<TestResult> te = t.iterator();
		while (te.hasNext()) {
			TestResult tt = te.next();
			if (tt.studentId == studentid) {
				te.remove();
				break;
			}
		}
	}
	System.out.println("Map After Deleting Test Series Records...");
	for(Entry<Integer, List<TestResult>> eee:Academy.test_map.entrySet())
	{
	System.out.println("Key :"+eee.getKey()+"  Value :"+eee.getValue());	
	}

//	System.out.println(Academy.test_map);

}


}
