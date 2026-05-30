import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define a task that returns a String after some work
        Callable<String> task = () -> {
            Thread.sleep(5000);
            return "Task Finished!";
        };

        // Submit the task and get a Future
        Future<String> future = executor.submit(task);

        // Blocking call to get the result
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }
}
