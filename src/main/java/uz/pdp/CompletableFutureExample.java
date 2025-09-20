package uz.pdp;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CompletableFuture<String> mijoz1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("1-mijoz savdoni boshladi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1-mijoz savdoni tugatdi");
            return "1-mijoz";
        });

        CompletableFuture<String> mijoz2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("2-mijoz savdoni boshladi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2-mijoz savdoni tugatdi");
            return "2-mijoz";
        });

        CompletableFuture<String> mijoz3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("3-mijoz savdoni boshladi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3-mijoz savdoni tugatdi");
            return "3-mijoz";
        });

        CompletableFuture<String> mijoz4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("4-mijoz savdoni boshladi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("4-mijoz savdoni tugatdi");
            return "4-mijoz";
        });

        CompletableFuture<String> mijoz5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("5-mijoz savdoni boshladi");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("5-mijoz savdoni tugatdi");
            return "5-mijoz";
        });

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.allOf(mijoz1, mijoz2, mijoz3, mijoz4, mijoz5)
                .handle((s, throwable) -> {
                    System.out.println(throwable);
                    return s;
                })
                .thenRun(() -> {
                    System.out.println("Mijozlarning barchasi ishni yakunladi...");
                });

//        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.anyOf(mijoz1, mijoz2, mijoz3, mijoz4, mijoz5)
//                .thenRun(() -> {
//                    System.out.println("Mijozlardan biri ishni yakunladi...");
//                });

        Thread.sleep(10000);
    }

    private static void m1() throws InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread());
                    return (int) (Math.random() * 100);

                }).thenApply(s -> s + 1000)
                .thenAccept(s -> {
                    System.out.println(s);
                }).thenRun(() -> System.out.println("Done"));

        Thread.sleep(500);
    }
}
