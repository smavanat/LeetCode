//LeetCode Problem No. 25: Reverse Nodes in k-Group
public class KGroupReverse {
    //Beats 100% in processing and 75% in memory
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there's a group to reverse
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEndNext = kth.next;

            // Reverse the k nodes
            ListNode prev = kth.next;
            ListNode curr = groupStart;

            while (curr != groupEndNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect with previous group
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Helper to get the k-th node from a starting point
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
