package org.yann.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

class MyLinkedListTest {

    @Test
    void addAll() {
        Collection<Integer> c = new ArrayList<>();
        c.add(11);
        c.add(12);

        MyLinkedList<Number> myLinkedList = new MyLinkedList<>();
        myLinkedList.addAll(c);
        System.out.println(myLinkedList);
    }

}