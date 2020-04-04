package AQS;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class AQS {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Thread thread=new Thread(()->{
            lock.lock();
            System.out.println(new Date());
            lock.unlock();
        });
        thread.start();
    }

//    摘自公众号 林湾村龙猫
//    lock的存储结构：一个int类型状态值（用于锁的状态变更），一个双向链表（用于存储等待中的线程）
//
//    lock获取锁的过程：本质上是通过CAS来获取状态值修改，如果当场没获取到，会将该线程放在线程等待链表中。
//
//    lock释放锁的过程：修改状态值，调整等待链表。
//
//    可以看到在整个实现过程中，lock大量使用CAS+自旋。因此根据CAS特性，lock建议使用在低锁冲突的情况下。
//    目前java1.6以后，官方对synchronized做了大量的锁优化（偏向锁、自旋、轻量级锁）。
//    因此在非必要的情况下，建议使用synchronized做同步操作。
}
