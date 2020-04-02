import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread=new Thread(()->{
            System.out.println(1);
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });
        FutureTask<Integer> futureTask=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        //thread1.start();;
    }
}
