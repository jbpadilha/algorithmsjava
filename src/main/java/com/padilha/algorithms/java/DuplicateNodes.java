package com.padilha.algorithms.java;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class DuplicateNodes {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        // Write your code here
        if (head == null) {
            return null;
        }
        HashSet<Integer> nValues = new LinkedHashSet<>();
        SinglyLinkedListNode newList = new SinglyLinkedListNode(head.data);
        nValues.add(head.data);
        SinglyLinkedListNode tail = newList;
        while(head.next != null) {
            head = head.next;
            if (!nValues.contains(head.data)) {
                nValues.add(head.data);
                SinglyLinkedListNode newValue = new SinglyLinkedListNode(head.data);
                tail.next = newValue;
                tail = newValue;
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode newList = new SinglyLinkedListNode(3);
        SinglyLinkedListNode nValue = new SinglyLinkedListNode(4);
        SinglyLinkedListNode nValue1 = new SinglyLinkedListNode(3);
        nValue.next = nValue1;
        SinglyLinkedListNode nValue2 = new SinglyLinkedListNode(2);
        nValue1.next = nValue2;
        SinglyLinkedListNode nValue3 = new SinglyLinkedListNode(6);
        nValue2.next = nValue3;
        SinglyLinkedListNode nValue4 = new SinglyLinkedListNode(1);
        nValue3.next = nValue4;
        SinglyLinkedListNode nValue5 = new SinglyLinkedListNode(2);
        nValue4.next = nValue5;
        SinglyLinkedListNode nValue6 = new SinglyLinkedListNode(6);
        nValue5.next = nValue6;

        newList.next = nValue;

        System.out.println(condense(newList));
    }

}
