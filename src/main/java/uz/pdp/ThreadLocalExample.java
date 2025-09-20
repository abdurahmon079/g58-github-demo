package uz.pdp;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    private static final ThreadLocal<Double> doubleThread= new ThreadLocal<>(){
        @Override
        protected Double initialValue() {
            return new Random().nextDouble();
        }
    };

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
//                ThreadLocalRandom random = ThreadLocalRandom.current();
//                System.out.println(random.nextDouble());
                System.out.println(doubleThread.get());
            });
        }

    }
}
