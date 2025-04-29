//LeetCode Problem No. 24: Swap Nodes in pairs
public class SwapNode {
    //Beats 100% in processing and 99% in memory
    public ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode(0, head); //Represents the node before the head
        ListNode previous = header; //The node before the node to be swapped
        ListNode current = head; //The current node

        while(current != null && current.next != null) {
            ListNode nextCurrent = current.next.next; //Get the next current node
            ListNode swap = current.next; //Get the node to be swapped with

            //Swap the nodes
            swap.next = current;
            current.next = nextCurrent;
            previous.next = swap;
            
            //Setup the variables for the next loop iteration
            previous = current;
            current = nextCurrent;
        }

        return header.next;
    }
}
