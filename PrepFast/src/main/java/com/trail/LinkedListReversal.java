package com.trail;

public class LinkedListReversal {


    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print( current.data+" -> ");
            current= current.next;
        }
        System.out.println("null");
    }

    public static ListNode reverse(ListNode head){
        ListNode p = null;
        ListNode c = head;
        while(c!=null){
            ListNode temp = c.next;
            c.next = p;
            p= c;
            c= temp;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        printList(head);
        System.out.println();
        printList(reverse(head));
    }
}

class ListNode{
    int data;
    ListNode next;
    public ListNode(int data, ListNode next){
        this.data = data;
        this.next =next;
    }
}
