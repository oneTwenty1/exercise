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

    /**
     * 删除有序链表中的重复节点一
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
     * 删除有序链表中的重复节点二
     * 和一区别：删除重复节点本身。
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
        while (node.next != null) {
            if (node.val != node.next.val) {
                System.out.println("d1:"+node.val);
                //beforenode.next = node;
                //beforenode = beforenode.next;
                node = node.next;
            } else {
                System.out.println("d2:"+node.val);
                while (node.val == node.next.val && node.next != null) {
                    node.next = node.next.next;
                }
                //beforenode.next = node.next.next;
                //beforenode = beforenode.next;
            }
        }
        dispList(beforenode);
        return beforenode;
    }
    
    /**
     *  删除有序单链表的重复节点，功能同二
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
        int xlength = args.length;
        //for (int i = 0; i < xlength; i++) {
        //    ListNode[] node
        //}
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //dispList(a);
        //ListNode z = reverseList(a);
        ListNode x = killDuplicates(a);
        //ListNode y = deleteDuplicates(a);
    }

}

