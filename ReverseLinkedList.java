

class ReverseLinkedList{
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

    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode createLL(){
        ListNode head;
        head = new ListNode(20);
        head.next = new ListNode(30);
        head.next.next = new ListNode(40);
        head.next.next.next = new ListNode(50);
        head.next.next.next.next = new ListNode(60);
        return head;
    }

    static void printLL(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String args[]){
        ListNode head = createLL();
        ListNode ans = reverse(head);
        printLL(ans);
    }
}