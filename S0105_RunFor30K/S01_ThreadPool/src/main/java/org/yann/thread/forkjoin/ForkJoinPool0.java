package org.yann.thread.forkjoin;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class ForkJoinPool0 {

    private static Logger logger = LoggerFactory.getLogger(ForkJoinPool0.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //ForkJoinPool pool = new ForkJoinPool(1);

        Long total = 10000L;
        Instant start = Instant.now();
        ForkJoinTask<Long> countTask = pool.submit(new MyRecursiveTask(1L, total));
        //while (!countTask.isDone()) {
            //logger.debug("wait...");
        //}
        //logger.debug("countTask.get()={}", countTask.get());
        Long result = countTask.get();
        logger.debug("duration={}", Duration.between(start, Instant.now()).toMillis());
        logger.info("result={}", result);
        pool.shutdown();
    }

    private static class MyRecursiveTask extends RecursiveTask<Long> {
        private Long from;
        private Long to;

        public MyRecursiveTask(Long from, Long to) {
            this.from = from;
            this.to = to;
        }

        @SneakyThrows
        @Override
        protected Long compute() {
            if (to - from > 10) {
                logger.debug("{}, forkjoin: {} - {}", Thread.currentThread().getName(), from, to);
                //TimeUnit.MILLISECONDS.sleep(200);
                //TimeUnit.MILLISECONDS.sleep(200);
                Long middle = from + (to - from)/2;
                MyRecursiveTask left = new MyRecursiveTask(from, middle);
                MyRecursiveTask right = new MyRecursiveTask(middle + 1L, to);
                left.fork();
                right.fork();
                return (left.join() + right.join());
                //return left.invoke() + right.invoke();
            } else {
                logger.debug("{}, actual: {} - {}", Thread.currentThread().getName(), from, to);
                long count = 0L;
                for (Long i = from; i <= to; i++) {
                    count += i;
                }
                return count;
            }
        }
    }

}
