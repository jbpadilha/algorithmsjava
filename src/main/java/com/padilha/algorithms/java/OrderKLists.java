package com.padilha.algorithms.java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 */

public class OrderKLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a, b)-> a.val-b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static ListNode[] helperConvertTest( List<List<Integer>> numbers) {
        ListNode[] listNodes = new ListNode[numbers.size()];
        int count = 0;
        for (List<Integer> currList : numbers) {
            ListNode head = null;
            ListNode tail = null;
            for (Integer currNumber : currList) {
                ListNode newValue = new ListNode(currNumber);
                if (head == null) {
                    head = newValue;
                    tail = head;
                } else {
                    tail.next = newValue;
                    tail = newValue;
                }
            }
            listNodes[count] = head;
            count++;
        }
        return listNodes;
    }

    public static ListNode convertListToListNode(List<Integer> numbers) {
        ListNode head = null;
        ListNode tail = null;
        for (Integer currNumber: numbers) {
            ListNode newValue = new ListNode(currNumber);
            if (head == null) {
                head = newValue;
                tail = head;
            } else {
                tail.next = newValue;
                tail = newValue;
            }
        }
        return head;
    }

    public static boolean test(ListNode test, ListNode against) {
        ListNode tailTest = test;
        ListNode tailAgainst = against;

        if (tailTest.val != tailAgainst.val) {
            return false;
        }

        while (tailTest.next != null) {
            tailTest = tailTest.next;
            tailAgainst = tailAgainst.next;
            if (tailTest.val != tailAgainst.val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // test 1 [[1,4,5],[1,3,4],[2,6]]
        List<List<Integer>> test1 =  new LinkedList<>(Arrays.asList(
                new LinkedList<>(Arrays.asList(1,4,5)),
                new LinkedList<>(Arrays.asList(1,3,4)),
                new LinkedList<>(Arrays.asList(2,6))
        ));
        ListNode[] listNodes = helperConvertTest(test1);
        ListNode listNode = convertListToListNode(Arrays.asList(1,1,2,3,4,4,5,6));
        if (test(listNode, mergeKLists(listNodes))) {
            System.out.println("TEST 1 - Passed");
        } else {
            System.out.println("TEST 1 - FAILED");
        }
    }

}
