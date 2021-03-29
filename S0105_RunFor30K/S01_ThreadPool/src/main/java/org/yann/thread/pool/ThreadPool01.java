package org.yann.thread.pool;

import java.util.concurrent.*;

public class ThreadPool01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService service = Executors.newCachedThreadPool();
        //ExecutorService service = Executors.newFixedThreadPool(10);
        //ExecutorService service = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                2, 4, 10L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2));

        for (int i = 0; i < 10; i++) {
            service.execute(new MyTask(i));
            //Future<Integer> future = service.submit(new MyTaskCallable(i));
            //System.out.println(Thread.currentThread().getName() + "===" + future.get());
        }
        service.shutdown();
    }


}

class MyTask implements Runnable{

    private int i;

    public MyTask(){}
    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===" + i);
        try {
            //Thread.sleep(1000);
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyTaskCallable implements Callable{

    private int i;

    public MyTaskCallable(){}
    public MyTaskCallable(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "===" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

}
