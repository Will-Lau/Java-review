package MutiThread;

public class Demo {
    public static int i=10;
    public static synchronized void sub(){
        if(Thread.currentThread().getName()=="t1"){
            if(i>=2){
                i-=2;
            }

        }else {
            if(i>=3){
                i-=3;
            }
        }
        System.out.println(i);
    }
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
           while (i>=2){
               sub();

           }
        },"t1");

        Thread thread2=new Thread(()->{
            while (i>=3){
                sub();
            }
        },"t2");
        thread1.start();
        thread2.start();
    }
}
