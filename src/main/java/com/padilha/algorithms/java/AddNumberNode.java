package com.padilha.algorithms.java;

public class AddNumberNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode resList = new ListNode(0);
    public static ListNode head = resList;
    public static int carry = 0;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val + carry;
        carry  = sum / 10;
        resList.next = new ListNode(sum % 10);
        resList = resList.next;

        if(l1.next != null && l2.next != null)
            addTwoNumbers(l1.next, l2.next);
        else if (l1.next != null)
            addTwoNumbers(l1.next, new ListNode(0));
        else if (l2.next != null)
            addTwoNumbers(new ListNode(0), l2.next);
        else if (carry > 0)
        {
            resList.next = new ListNode(1);
            resList = resList.next;
        }
        return head.next;
    }

    public static boolean testListNodeSimilar(ListNode test, ListNode against) {
        if (test.val != against.val) {
            return false;
        }
        while (test.next != null) {
            test = test.next;
            against = against.next;
            if (test.val != against.val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Test 1
        // [2,4,3]
        // [5,6,4]
        // Expected [7,0,8]
        ListNode list1 = new ListNode(2);
        ListNode list1_add = new ListNode(4);
        ListNode list1_add1 = new ListNode(3);
        list1_add.next = list1_add1;
        list1.next = list1_add;

        ListNode list2 = new ListNode(5);
        ListNode list2_add = new ListNode(6);
        ListNode list2_add1 = new ListNode(4);
        list2_add.next = list2_add1;
        list2.next = list2_add;

        ListNode list_result = new ListNode(7);
        ListNode list_result_add = new ListNode(0);
        ListNode list_result_add1 = new ListNode(8);
        list_result_add.next = list_result_add1;
        list_result.next = list_result_add;
        
        if (testListNodeSimilar(addTwoNumbers(list1, list2),list_result)){
            System.out.println("TEST 1 - PASSED");
        } else {
            System.out.println("TEST 1 - FAILED");
        }

        // Test 2
        // [9]
        // [1,9,9,9,9,9,9,9,9,9]
        // Expected [0,0,0,0,0,0,0,0,0,0,1]
        ListNode list1_test2 = new ListNode(9);

        ListNode list2_test2 = new ListNode(1);
        ListNode list2_add_test2 = new ListNode(9);
        list2_test2.next = list2_add_test2;
        ListNode list2_add1_test2 = new ListNode(9);
        list2_add_test2.next = list2_add1_test2;
        ListNode list2_add1_test3 = new ListNode(9);
        list2_add1_test2.next = list2_add1_test3;
        ListNode list2_add1_test4 = new ListNode(9);
        list2_add1_test3.next = list2_add1_test4;
        ListNode list2_add1_test5 = new ListNode(9);
        list2_add1_test4.next = list2_add1_test5;
        ListNode list2_add1_test6 = new ListNode(9);
        list2_add1_test5.next = list2_add1_test6;
        ListNode list2_add1_test7 = new ListNode(9);
        list2_add1_test6.next = list2_add1_test7;
        ListNode list2_add1_test8 = new ListNode(9);
        list2_add1_test7.next = list2_add1_test8;


        list_result = new ListNode(0);
        ListNode list_result_add_test1 = new ListNode(0);
        list_result.next = list_result_add_test1;
        ListNode list_result_add_test2 = new ListNode(0);
        list_result_add_test1.next = list_result_add_test2;
        ListNode list_result_add_test3 = new ListNode(0);
        list_result_add_test2.next = list_result_add_test3;
        ListNode list_result_add_test4 = new ListNode(0);
        list_result_add_test3.next = list_result_add_test4;
        ListNode list_result_add_test5 = new ListNode(0);
        list_result_add_test4.next = list_result_add_test5;
        ListNode list_result_add_test6 = new ListNode(0);
        list_result_add_test5.next = list_result_add_test6;
        ListNode list_result_add_test7 = new ListNode(0);
        list_result_add_test6.next = list_result_add_test7;
        ListNode list_result_add_test8 = new ListNode(0);
        list_result_add_test7.next = list_result_add_test8;
        ListNode list_result_add_test9 = new ListNode(0);
        list_result_add_test8.next = list_result_add_test9;
        ListNode list_result_add_test10 = new ListNode(1);
        list_result_add_test9.next = list_result_add_test10;

        if (testListNodeSimilar(addTwoNumbers(list1_test2, list2_test2),list_result)){
            System.out.println("TEST 2 - PASSED");
        } else {
            System.out.println("TEST 2 - FAILED");
        }
    }

}
