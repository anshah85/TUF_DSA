package linkedList.doublyLinkedList;

public class InsertDelete {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 4, 5, 8};

        ListNode head = convertArrToDLL(arr);
        printDLL(head);
    }

    public static ListNode convertArrToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}