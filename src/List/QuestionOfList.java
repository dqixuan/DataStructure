package List;

//链表节点结构
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

public class QuestionOfList {

    //找到链表的中间节点,偶数节点返回第二个
    public ListNode getMid(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表的节点是偶数,奇数相同
        return slow;

    }
}
