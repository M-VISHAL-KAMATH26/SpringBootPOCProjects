public class RunnablePOC {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for(int i=1;i<=10;i++){
                if(i%2==0){
                    System.out.println(i+" "+Thread.currentThread().getName());
                }
            }
        },"Thread-Even");

        Thread t2=new Thread(()->{
            for(int i=1;i<=10;i++){
                if(i%2!=0){
                    System.out.println(i+" "+Thread.currentThread().getName());
                }
            }
        },"Thread-Odd");

        t1.start();
        t1.join();

        t2.start();
        t2.join();
    }
}
