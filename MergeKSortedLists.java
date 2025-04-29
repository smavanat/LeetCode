import java.util.PriorityQueue;
//LeetCode Problem No. 23: Merge k Sorted Lists
public class MergeKSortedLists {
    //Beats 100% in processing and 64% in memory
    public ListNode mergeKLists(ListNode[] lists) {
        //Early return
        if (lists == null || lists.length == 0) return null;

        //Essentailly just keep merging two lists, with the first list being the combination of all the previously merged lists
        int interval = 1;
        int n = lists.length;

        while (interval < n) {
            for (int i = 0; i + interval < n; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    //This is just the method from my solution to Problem No. 21
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = new ListNode();
        ListNode current = header;

        while(list1 != null && list2 != null){
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
        current.next = (list1 != null) ? list1 : list2;

        return header.next;
    }
}