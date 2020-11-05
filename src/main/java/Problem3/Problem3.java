package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        if (list == null) { //check if list is null
            return;
        }

        printListInReverse(list.next, print); //call function until empty
        print.println(list.val); //print starting from the back
    }
}
