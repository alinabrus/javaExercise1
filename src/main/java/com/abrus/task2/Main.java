package com.abrus.task2;

public class Main {

    /*
    https://leetcode.com/problems/reverse-linked-list/description/
     */
    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5});
        System.out.print("\n\n");

        test(new int[]{1,2});
        System.out.print("\n\n");

        test(new int[]{});
    }

    public static void test(int[] nums) {
        ListNode node = createSinglyLinkedList(nums);
        node.print();
        System.out.println();

        ListNode reversed = reverseSinglyLinkedList(node);
        reversed.print();
        System.out.println();

        ListNode reversed2 = reverseSinglyLinkedListRecursively(reversed, null);
        reversed2.print();
    }

    public static ListNode createSinglyLinkedList(int[] items) {
        if (items.length == 0) {
            return new ListNode();
        }
        ListNode node = null;
        for (int i = items.length - 1; i >= 0;  i--) {
            node = new ListNode(items[i], node);
        }
        return node;
    }

    public static ListNode reverseSinglyLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseSinglyLinkedListRecursively(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
        return reverseSinglyLinkedListRecursively(cur, prev);
    }
}

