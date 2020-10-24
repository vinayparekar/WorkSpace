package com.trail;

public class MadhuLinkedList {
    Node head;

    MadhuLinkedList(){
        head = null;
    }

    public Node addNode(int value){
        Node newNode = new Node(value,null);
        // adding node to head
        if(head == null){
            head = newNode;
        }else{// adding nodes when linkedlist length > 1
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next=newNode;
        }
        return newNode;
    }

    public static void main(String[] args) {
        MadhuLinkedList list1 = new MadhuLinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);

        MadhuLinkedList.printList(list1);
    }

    public static void printList(MadhuLinkedList mll){
        Node temp = mll.head;
        while(temp !=null){
            System.out.print(temp.value+ "->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
}

class Node{
    int value;
    Node next;

    Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}
