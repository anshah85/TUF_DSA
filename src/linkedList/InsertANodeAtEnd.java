package linkedList;

public class InsertANodeAtEnd {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};

        ListNode head = arrayToLinkedList(arr);
        printLinkedList(head);
        System.out.println();
        head = insertAtTheEndofLL(head, 11);
        printLinkedList(head);
        System.out.println();
        head = removeHead(head);
        printLinkedList(head);
    }

    public static ListNode removeHead(ListNode head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public static ListNode insertAtTheEndofLL(ListNode head, int x) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.next == null) {
                ListNode newNode = new ListNode(x);
                temp.next = newNode;
                temp = newNode;
            }
            temp = temp.next;
        }

        return head;
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
