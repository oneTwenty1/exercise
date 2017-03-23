import java.lang.System.*;


/**
 *test for a palindrome
 */
public class ListNode{


    int val;
    ListNode next;


    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    /**
     *
     *判断是否为回声链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverseList(slow);

        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    /**
     * 链表的翻转
     */
    public static ListNode reverseList(ListNode head) {    
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode first = new ListNode(0);
        while (head.next != null) {
            ListNode tmp = head.next.next;
            first = head.next;
            first.next = head;
            head.next = tmp;
        }
        
        return first;

    }

    /**
     *迭代实现链表翻转更好理解
     *开销较大
     */
    public ListNode reverseListRecur(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode reversedList = reverseListRecur(head.next);
        tail.next = head;
        head.next = null;

        return reversedList;
    }

    public static void main(String[] args) {
        int xlength = args.length();
        //for (int i = 0; i < xlength; i++) {
        //    ListNode[] node
        //}
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        //ListNode c = new ListNode(3);
        a.next = b;
        //b.next = c;
        ListNode z = reverseList(a);
        System.out.println(z.val);
    }
}

