package ticket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocaExample {
    public static void main(String[] args) {
        SimpleData s = new SimpleData();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                s.getnumber();

            }},"aaa").start();
        new Thread(()->{for (int i = 0; i < 26; i++)s.getcahr();},"bb").start();

    }
}
class SimpleData{
    private Integer [] n=new Integer[100];
    private Character[] s=new Character[100];
    Lock lock=new ReentrantLock();
    Condition cd1=lock.newCondition();
    Condition cd2=lock.newCondition();
    int number=0;
    int i=0;
    int t=0;
    SimpleData(){
        for (int i = 0; i < 100; i++) {
            n[i]=i;

        }
        for (int i = 0; i < 26; i++) {
            s[i]=(char)(i+96);
        }
    }
    public void getnumber(){
        lock.lock();
        try {
            while (number!=0){
                cd1.await();
            }
            if(i++<100){
                System.out.print(n[i]+""+n[++i]);
            }
            number=1;
            cd2.signal();
        }catch (Exception e){}
        finally {
            lock.unlock();
        }
    }
    public void getcahr(){
        lock.lock();
        try {
            while (number==0){
                cd2.await();
            }
            if(t++<26){
                System.out.print(s[t]);
            }
            number=0;
            cd1.signal();
        }catch (Exception e){}
        finally {
            lock.unlock();
        }
    }
}
