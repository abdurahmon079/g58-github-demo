package uz.pdp;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

    }

    private static void taskWithCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 500; i++) {
            int f = i;
            Future<Integer> submit = executorService.submit(() -> {
                System.out.println("Callable ishlayapti :: " + Thread.currentThread().getName() + " :: i = " + f);
                return new Random().nextInt(1,100);
            });
            System.out.println(i + " :: " + submit.get());
        }
    }

    private static void m2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 100; i++) {
            int f = i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + " :: Task : " + f);
                try {
                    Thread.sleep(10, TimeUnit.MINUTES.ordinal());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        Thread.sleep(3000);
        executorService.shutdownNow();
    }

    private static void m1() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Runnable runnable = () -> {
            System.out.println(new Date());
        };

//        executorService.scheduleAtFixedRate(runnable, 1,5, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(runnable,1,5,TimeUnit.SECONDS);
    }
}