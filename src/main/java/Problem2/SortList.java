package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        if (head == null) {
            return null;
        }

        int counter = 0;
        ListNode p1 = head;

        while (p1.next != null) {
            counter++;
            p1 = p1.next;
        }

        int mid = (counter+1)/2;
        p1 = head;
        for(int i = 0; i < mid-1; i++) {
            p1 = p1.next;
        }

        ListNode temp = p1.next;
        p1.next = null;
        return temp;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeLists(list1, list2.next);
        return list2;
    }
}
