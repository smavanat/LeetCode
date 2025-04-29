import java.util.ArrayList;
//LeetCode Problem No. 19: Remove Nth Node from End of List
public class RemoveNthNode {
    //Beats 100% in terms of processing and 75% in memory
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head; //Tracks the current node
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();//Stores all the nodes in the list for easy access
        //Add all the nodes to the array list
        while(current != null) {
            nodes.add(current);
            current = current.next;
        }
        
        int indexToRemove = nodes.size() - n; //The index of the node to remove
        //If the node is not the head
        if (indexToRemove > 0) {
            // Skip the removed node
            nodes.get(indexToRemove - 1).next = nodes.get(indexToRemove).next;
            return head;
        } else {
            // Removing the head
            return head.next;
        }
    }
}