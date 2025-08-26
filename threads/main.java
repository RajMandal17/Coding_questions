package threads;

import java.util.concurrent.*;

public class main {


    public static void main(String arg[]) throws ExecutionException, InterruptedException {


        ExecutorService executorService =  Executors.newFixedThreadPool(5);
for(int i = 0 ; i < 10 ; i++) {
    executorService.submit(() -> System.out.println("ok this task finish" + Thread.currentThread().getName()));
}    }
}
