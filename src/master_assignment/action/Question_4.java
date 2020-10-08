package master_assignment.action;

import java.util.Comparator;
import java.util.TreeSet;

import master_assignment.bean.Academy;
import master_assignment.bean.Course;

public class Question_4 {
	public static void Ques4() {
		/*
		 * use TreeSet to store course details on fees from highest to lowest fees and
		 * printing the treemap output with course details.
		 */

		TreeSet<Course> t = new TreeSet<>(new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {

				if (o1.courseFees < o2.courseFees)
					return 1;
				else if (o1.courseFees > o2.courseFees)
					return -1;
				else
					return 0;
			}
		});

		t.addAll(Academy.courseList);
		for (Course obj : t)
			System.out.println(obj);
	}


}
