//Leetcode problem No.2: Add Two Numbers
class AddTwoNumbers {
    //Beats 100% speedwise and beat 53% memorywise
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //The header of the new linked list (dummy variable that goes behind the actual head)
        ListNode head = new ListNode(0);
        ListNode current = head; //Tracks the current node
        int carry = 0; //Tracks the carry

        while(l1 != null || l2 != null || carry != 0) {
            //Null checks set default value of 0
            int x = l1 != null ? l1.val : 0; 
            int y = l2 != null ? l2.val : 0;

            //Work out sum and new carry
            int sum = x + y + carry;
            carry = sum/10;

            //Set the next node in the LinkedList
            current.next = new ListNode(sum % 10);
            current = current.next;

            //Null checks to set the next nodes in both linked lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head.next;
    }
}