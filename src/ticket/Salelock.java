package ticket;

public class Salelock {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{for(int i=0;i<40;i++) ticket.sale();System.out.println("aaa");},"aaa");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    ticket.sale();
                }
            }
        },"aaa").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <40 ; i++) {
//                    ticket.sale();
//                }
//            }
//        },"bbb").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <40 ; i++) {
//                    ticket.sale();
//                }
//            }
//        },"ccc").start();

    }
}
