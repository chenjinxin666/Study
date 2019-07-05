package multiThread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> q;
    public Consumer(BlockingQueue<String> q){
        this.q=q;
    }
    @Override
    public void run() {
        try{
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+q.take());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
