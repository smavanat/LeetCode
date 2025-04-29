//LeetCode Problem No. 21: Merge Two Sorted Lists
public class MergeSortedLists {
    //Beats 100% in processing and 95% in memory
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode(); //Stores the head of the list
        ListNode current = header;//Holds the current node

        //While we have not depleted one of the lists
        while(list1 != null && list2 != null){
            //Compare two list nodes, add the smaller one as the next in the sorted list and move along
            if(list1. val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        //Append the remaining list
        current.next = (list1 != null) ? list1 : list2;

        return header.next;
    }
}
