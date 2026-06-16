
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureProblem1 {
    CompletableFuture<Integer> getOrderId(Executor executor){
        return CompletableFuture.supplyAsync(()->{
            return 1001;
        },executor);
    }
    CompletableFuture<String> getOrderStatus(int orderId,Executor executor){
        return CompletableFuture.supplyAsync(()->{
            return "shipped";
        },executor);
    }
    public static void main(String[] args) throws Exception {
        ExecutorService executor=Executors.newFixedThreadPool(5);

        CompletableFutureProblem1 cf=new CompletableFutureProblem1();

        CompletableFuture<Void> result=cf.getOrderId(executor)
                .thenCompose(id->cf.getOrderStatus(id,executor))
                .exceptionally(ex->"exception")
                .thenAccept(n-> System.out.println(n));

//        Thread.sleep(1000);   //incase where  we use the default forkjoinpool that is deamon thread
        System.out.println(Thread.currentThread().getName());
        result.get();
executor.shutdown();
    }
}
