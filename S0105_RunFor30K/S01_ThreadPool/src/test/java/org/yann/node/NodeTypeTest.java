package org.yann.node;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.yann.node.NodeType.DeNode;

import static org.junit.jupiter.api.Assertions.*;

class NodeTypeTest {

    @Nested
    @DisplayName("Node")
    class NodeTest {
        @Test
        void linked() {
            DeNode<Integer> head = new DeNode<Integer>(null, null, null);
            DeNode<Integer> tail = new DeNode<Integer>(null, null, null);

            int i = 1;
            DeNode<Integer> x = new DeNode<>(null, i, null);
            head.next = x;
            tail.prev = x;

            i = 2;
            x = new DeNode<>(null, i, null);
            DeNode last = tail.prev;
            tail.prev = x;
            x.prev = last;
            last.next = x;

            i = 3;
            x = new DeNode<>(null, i, null);
            last = tail.prev;
            tail.prev = x;
            x.prev = last;
            last.next = x;

            i = 4;
            x = new DeNode<>(null, i, null);
            last = tail.prev;
            tail.prev = x;
            x.prev = last;
            last.next = x;

            System.out.println("==========");

            while(head.next != null) {
                DeNode pollNode = head.next;
                DeNode next = pollNode.next;
                if (next == null) {
                    tail.prev = null;
                }
                head.next = next;
                System.out.println(pollNode.item);
            }
        }
    }

    @Test
    void hIsEqualsHead() {
        DeNode<Integer> head = new DeNode<Integer>(null, null, null);

        DeNode<Integer> h = head;

        DeNode<Integer> x = new DeNode<>(null, 1, null);
        head = x;

        Assertions.assertSame(h, head);
    }

}