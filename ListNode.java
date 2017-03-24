import java.lang.System.*;
import java.util.ArrayList;


/**
 * @author liudashuang
 *  collection for ListNode function
 */
public class ListNode{

    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    /**
     *  给定一个单链表，判断是否为回声链表<br>
     *  O(n) time and O(1) space
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
     *  链表的翻转
     */
    public static ListNode reverseList(ListNode head) {    

        //基本所有的链表操作都得有下面两个判断，称为链表的起手式
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
     *  迭代实现链表翻转更好理解<br>
     *  开销较大
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

    /**
     * 删除有序链表中的重复节点一<br>
     * toturials: give ListNode 1>2>2>3
     *           return 1>2>3
     */
    public static ListNode deleteDuplicates(ListNode head) {
        dispList(head);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val != node.next.val) {
                node = node.next;
            } else {
                while (node.val == node.next.val && node.next != null) {
                    node.next = node.next.next;
                }
            }
        }
        dispList(head);
        return head;
    }

    /**
     * 删除有序链表中的重复节点二<br>
     * 和一区别：删除重复节点本身。<br>
     * toturials: give ListNode 1>2>2>3
     *          return 1>3
     */
    public static ListNode killDuplicates(ListNode head) {
        dispList(head);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int val = head.val;
        ListNode node = head;
        ListNode beforenode = new ListNode(0);
        ListNode killednode = beforenode;
        while (node.next != null) {
            if (node.val != node.next.val) {
                System.out.println("d1:"+node.val);
                beforenode.next = node;
                beforenode = beforenode.next;
                node = node.next;
            } else {
                System.out.println("d2:"+node.val);
                while (node.val == node.next.val && node.next != null) {
                    node.next = node.next.next;
                }
                node = node.next;
            }
        }
        dispList(killednode.next);
        return killednode.next;
    }
    
    /**
     *  删除有序单链表的重复节点，功能同二<br>
     *  通过迭代实现。
     */
    public static ListNode killDuplicatesRecur(ListNode head) {
        dispList(head);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int val = head.val;
        ListNode node = head;
        boolean killme = false;
        while (node.next != null && val == node.next.val) {
            node = node.next;
            killme = true;
        }
        if (killme) {
            head = killDuplicatesRecur(node.next);
        } else {
            head.next = killDuplicatesRecur(node.next);
        }

        return head;
    }

    /**
     *  删除相对于最后一个节点的第N个节点。<br>
     *  tutorials:  given list 1>2>3>4>5    n = 2
     *          return 1>2>3>5
     *  note: n始终合法，此方法为
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        dispList(head);
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n ;i ++) {
            first = first.next;
            if (first == null) {
                return head.next;
            }
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }


    public static void dispList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println("listStr: " + head.val);
            return;
        }
        String listStr = "listStr: ";
        while(head.next != null){
            listStr = listStr + head.val + " > ";
            head = head.next;
        }
        System.out.println(listStr + " null");
    }

    public static int listLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next != null) {
            return 1;
        }
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> listNodes = new ArrayList();
        int xlength = args.length;
        System.out.println("listNodes length: " + xlength);
        ListNode a = new ListNode(0);
        ListNode listNode = a;
        for (int i = 0; i < xlength; i++) {
            listNodes.add(new ListNode(Integer.valueOf(args[i])));
            a.next = listNodes.get(i);
            a = a.next;
        }
        dispList(listNode.next);
        killDuplicates(listNode.next);
    }

}

