


public class RemoveNthFromEnd{
        static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    static ListNode removeKthNode(ListNode head, int k){
        ListNode fast = head;
        for(int i=0;i<k;i++) fast = fast.next;
        if(fast == null)return head.next;
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}