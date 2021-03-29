package org.yann.thread.forkjoin;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DisruptorSequenceBarrier {

    private static Logger logger = LoggerFactory.getLogger(DisruptorSequenceBarrier.class);

    public static void main(String[] args) throws Exception {

        ThreadFactory threadFactory = newThreadFactory();

        Disruptor disruptor = new Disruptor<MyEvent>(
                MyEvent.FACTORY, 4, threadFactory,
                ProducerType.MULTI, new BlockingWaitStrategy());

        //Class clazz = Disruptor.class;

        //Disruptor disruptor1 = (Disruptor<MyEvent>) clazz.getDeclaredConstructor(EventFactory.class, int.class, ThreadFactory.class, ProducerType.class, WaitStrategy.class)
        //        .newInstance(MyEvent.FACTORY, 4, threadFactory, ProducerType.MULTI, new BlockingWaitStrategy());



        handleEventsWith(disruptor, 4);

        //handleEventsWithWorkerPool(disruptor, 4);

        disruptor.start();

        disruptor.publishEvents(
                new EventTranslatorOneArg<MyEvent, Object>() {
                    @Override
                    public void translateTo(MyEvent event, long sequence, Object arg0) {
                        event.name = (String)arg0 + "-" + Thread.currentThread().getName();
                    }
                }, new Object[]{"a", "b", "c"});

        TimeUnit.SECONDS.sleep(4);
        disruptor.halt();
    }

    private static void handleEventsWith(Disruptor disruptor, int size) {
        if (size <= 0) {
            size = 1;
        }
        EventHandler[] eventHandlers = new EventHandler[size];
        for (int i = 0; i < eventHandlers.length; i++) {
            eventHandlers[i] = new EventHandler<MyEvent>() {
                @Override
                public void onEvent(MyEvent event, long sequence, boolean endOfBatch) throws Exception {
                    logger.info("{}, {}, sequence={}, endOfBatch={}", Thread.currentThread().getName(), event, sequence, endOfBatch);
                }
            };
        }

        Sequence[] barrierSequences = new Sequence[3];
        barrierSequences[0] = new Sequence(1);
        barrierSequences[1] = new Sequence(2);
        barrierSequences[2] = new Sequence(3);
        createEventProcessors(disruptor, barrierSequences, eventHandlers);
        //disruptor.handleEventsWith(eventHandlers);
    }

    private static void createEventProcessors(Disruptor disruptor, Sequence[] barrierSequences, EventHandler[] eventHandlers) {
        Class clazz = disruptor.getClass();
        try {
            Method m = clazz.getDeclaredMethod("createEventProcessors", Sequence[].class, EventHandler[].class);
            m.setAccessible(true);
            m.invoke(disruptor, barrierSequences, eventHandlers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleEventsWithWorkerPool(Disruptor disruptor, int size) {
        if (size <= 0) {
            size = 1;
        }
        WorkHandler[] workHandlers = new WorkHandler[size];
        for (int i = 0; i < workHandlers.length; i++) {
            workHandlers[i] = new WorkHandler<MyEvent>() {
                @Override
                public void onEvent(MyEvent event) throws Exception {
                    logger.info("{}, {}", Thread.currentThread(), event);
                }
            };
        }
        disruptor.handleEventsWithWorkerPool(workHandlers);
    }


    private static ThreadFactory newThreadFactory() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("Yann-" + t.getName());
                return t;
            }
        };

    }

    private static class MyEvent {
        String name;

        @Override
        public String toString() {
            return "MyEvent{name=" + name + "}";
        }

        public static final EventFactory<MyEvent> FACTORY = new EventFactory<MyEvent>() {
            @Override
            public MyEvent newInstance() {
                return new MyEvent();
            }
        };
    }
    
}
