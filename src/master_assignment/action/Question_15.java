package master_assignment.action;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import master_assignment.bean.Academy;
import master_assignment.bean.Transaction;

public class Question_15 {

	public static void Ques15() {
		// to delete a transaction. Note transaction all records across all beans should
		// be deleted.

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Student-Id To Transaction Records :");
		Integer sid = sc.nextInt();

		Iterator<Map.Entry<Integer, List<Transaction>>> i = Academy.transactionMap.entrySet().iterator();
		while (i.hasNext()) {
			List<Transaction> tr = i.next().getValue();
			ListIterator<Transaction> i1 = tr.listIterator();
			while (i1.hasNext()) {
				Integer id = i1.next().studId;
				if (id == sid) {
					i1.remove();
				}

			}
		}
System.out.println("After deleting student-id :"+sid+" Showing all records :");
System.out.println();
		System.out.println(Academy.transactionMap);
	}


}
