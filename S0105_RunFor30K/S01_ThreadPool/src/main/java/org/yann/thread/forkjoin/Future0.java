package org.yann.thread.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.concurrent.*;

public class Future0 {
    private static Logger logger = LoggerFactory.getLogger(Future0.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(20);
                return "ok";
            }
        };
        FutureTask<String> task = new FutureTask<String>(callable);
        new Thread(task).start();
        TimeUnit.SECONDS.sleep(1);
        task.cancel(false);
        //logger.debug("{}", task.get());
        while (!task.isDone()) {
            logger.debug("wait...");
        }
        logger.info(task.get());

    }

}
