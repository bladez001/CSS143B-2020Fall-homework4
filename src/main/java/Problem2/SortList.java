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
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            p2 = p2.next;

            if (p2 == null) {
                break;
            }

            p2 = p2.next;

            if (p2 == null) {
                break;
            }

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
