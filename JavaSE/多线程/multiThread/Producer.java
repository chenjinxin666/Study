package multiThread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> q;
    public Producer(BlockingQueue<String> q){
        this.q=q;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i < 20; i++) {
                Thread.sleep(1000);
                q.put(String.valueOf(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
