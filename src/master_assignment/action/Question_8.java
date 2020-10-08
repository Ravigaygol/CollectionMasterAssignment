package master_assignment.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;

public class Question_8 {

	public static void Ques8() {

		// show sorting options on course cname or startDate or subject or fees and in
		// response print all details of course

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter any one choice for Sorting...");
		System.out.println("1)Course Name  2)Start Date  3)Subject  4)Fees");
		int n = sc.nextInt();

		switch (n) {
		case 1:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.course_name.compareTo(o2.course_name);

				}

			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 2:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					if (o1.startDate.getYear() != o2.startDate.getYear())
						return o1.startDate.getYear() - o2.startDate.getYear();
					else if (o1.startDate.getMonth() != o2.startDate.getMonth())
						return o1.startDate.getMonth() - o2.startDate.getMonth();
					else
						return o1.startDate.getDay() - o2.startDate.getDay();
				}
			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 3:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.subject.compareTo(o2.subject);
				}
			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		case 4:
			Collections.sort(Academy.courseList, new Comparator<Course>() {

				@Override
				public int compare(Course o1, Course o2) {

					return o1.courseFees - o2.courseFees;
				}

			});
			for (Course c : Academy.courseList)
				System.out.println(c);
			break;
		default:
			System.out.println("Invalid Input... Please Enter Correct Choice...");
		}
	}

}
