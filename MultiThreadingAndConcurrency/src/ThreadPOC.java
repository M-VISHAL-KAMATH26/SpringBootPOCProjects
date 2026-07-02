class NumberPrinter extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i+" :"+Thread.currentThread().getName());
        }
    }
}

public class ThreadPOC {
    public static void main(String[] args) throws InterruptedException {
        NumberPrinter t1=new NumberPrinter();
        NumberPrinter t2=new NumberPrinter();
        NumberPrinter t3=new NumberPrinter();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("all done");

    }
}
