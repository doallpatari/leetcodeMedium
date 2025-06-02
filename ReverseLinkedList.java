

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

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head;
        ListNode tail = head;
        int count = 1;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }
        tail.next = head;
        k = k%count;
               if (k == 0) {
            tail.next = null; // If k is a multiple of length, no change
            return head;
        }
        ListNode newTail = head;
        // while(k != 0 ){
        //     newTail = newTail.next;
        //     k--;
        // }
        for (int i = 0; i < count - k - 1; i++) {
            newTail = newTail.next; // Move to the correct spot
        }
        ListNode nhead = newTail.next;
        newTail.next = null;
        return nhead;

    }

    public static void main(String args[]){
        ListNode head = createLL();
        ListNode ans = reverse(head);
        printLL(ans);
        System.out.println("");
        ListNode rr = rotateRight(ans, 2);
        printLL(rr);
    }
}