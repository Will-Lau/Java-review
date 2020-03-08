import com.sun.javafx.binding.StringFormatter;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private int count;
    private String name;
    private List<String> status;

    MyThreadFactory(String name){
        this.name=name;
        count=0;
        status=new ArrayList<>();
    }

    public Thread newThread(Runnable runnable){
        Thread thread=new Thread(runnable,name+count);
        count++;
        System.out.println("create:"+thread.getName());
        status.add(String.format("create %s with id: %d",thread.getName(),thread.getId()));
        return thread;
    }

    public String getStatus(){
        StringBuffer s=new StringBuffer();
        for(String i:status){
            s.append(i);
        }
        return s.toString();
    }
}
