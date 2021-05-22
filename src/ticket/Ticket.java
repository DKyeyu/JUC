package ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    private int number=40;
    Lock lock=new ReentrantLock();
    public void sale(){

        lock.lock();
        try {
            if(number>0){
                number--;
                System.out.println(Thread.currentThread().getName()+"已卖出\t还剩"+number);
            }
        }catch (Exception e){
            System.err.print(e);
        }finally {
            lock.unlock();
        }

    }

}
