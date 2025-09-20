package uz.pdp;

import java.util.List;
import java.util.concurrent.*;

public class InvokeMain {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            Callable<Student> callable1 = () -> {
                return new Student("Ali", 18,"g58");
            };
            Callable<Student> callable2 = () -> {
                return new Student("Abdurahmon", 19,"g58");
            };
            Callable<Student> callable3 = () -> {
                return new Student("Amirhon", 15,"g58");
            };
            Callable<Student> callable4 = () -> {
                return new Student("Ilhom", 20,"g58");
            };
            Callable<Student> callable5 = () -> {
                return new Student("Alimardon", 19,"g58");
            };

            List<Future<Student>> futures = executorService.invokeAll(List.of(callable1, callable2, callable3, callable4, callable5));
            for (Future<Student> future : futures) {
                System.out.println(future.get());
            }

            System.out.println("------------------------------");

            Student result = executorService.invokeAny(List.of(callable1, callable2, callable3, callable4, callable5));
            System.out.println(result);

        } catch (RuntimeException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

    }
}
