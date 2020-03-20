package ThreadPool;

import java.util.concurrent.*;

public class MyThreadExecutor {

    public static void main(String[] args) {
        //ExecutorService executor = Executors.newFixedThreadPool(2);
        //ExecutorService executor=Executors.newCachedThreadPool();

        MyThreadFactory f;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, //corePoolSize
                100, //maximumPoolSize
                100, //keepAliveTime
                TimeUnit.SECONDS, //unit
                new LinkedBlockingDeque<>(100),//workQueue
                f=new MyThreadFactory("Liu")//factory
                , new ThreadPoolExecutor.DiscardOldestPolicy());
        for(int i=0;i<105;i++){
            final int taskIndex=i;
            System.out.println(f.getStatus());
            executor.execute(()->{
                System.out.println(taskIndex);
                try {
                    Thread.sleep(Long.MAX_VALUE);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
    }


}
