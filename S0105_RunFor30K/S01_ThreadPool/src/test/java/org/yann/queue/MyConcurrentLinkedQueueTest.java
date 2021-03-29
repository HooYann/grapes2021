package org.yann.queue;

import org.junit.jupiter.api.Test;

class MyConcurrentLinkedQueueTest {

    @Test
    void unsafePutOrderedObject() {
        MyConcurrentLinkedQueue queue = new MyConcurrentLinkedQueue();
        sun.misc.Unsafe unsafe = sun.misc.Unsafe.getUnsafe();
    }

}