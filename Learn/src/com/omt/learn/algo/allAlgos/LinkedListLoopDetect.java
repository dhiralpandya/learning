package com.omt.learn.algo.allAlgos;

import com.omt.learn.algo.util.linkedlist.LinkedListNode;

/**
 * Created by omt on 3/26/17.
 */
public class LinkedListLoopDetect {

    public static void main(String args[]) {
        LinkedListNode ln = generateLinkedListNode();

        System.out.println("Start node in loop :" + findLoopAndStartNode(ln).value);

    }

    private static LinkedListNode findLoopAndStartNode(LinkedListNode node) {

        LinkedListNode slowNode = node.next;
        LinkedListNode fastNode = node.next.next;

        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                break;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        if (slowNode == null || fastNode == null) {
            return null;
        } else {
            slowNode = node;
            while (slowNode != null && fastNode != null) {
                if (slowNode == fastNode) {
                    return slowNode;
                }
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
        }

        return null;
    }


    private static LinkedListNode generateLinkedListNode() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);

        n1.next = n2;
        n2.next = n3;

        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);
        LinkedListNode n7 = new LinkedListNode(7);
        LinkedListNode n8 = new LinkedListNode(8);
        LinkedListNode n9 = new LinkedListNode(9);

        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n4;

        return n1;
    }

}
