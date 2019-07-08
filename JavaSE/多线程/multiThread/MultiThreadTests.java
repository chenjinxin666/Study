package 多线程.multiThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadTests {
    public static void testThrend() {
//        练习一
//        for (int i = 0; i < 10; i++) {
//            new MyThread(i).start();
//        }
//        练习二
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(1000);
                            System.out.println(String.format("%d:%d",finalI,j));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static Object obj = new Object();
    public static void testSynchronized1(){
        synchronized (obj){
            try {
                for (int j = 0; j < 5; j++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T3:%d",j));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void testSynchronized2(){
        synchronized (new Object()){
            try {
                for (int j = 0; j < 5; j++) {
                    Thread.sleep(1000);
                    System.out.println(String.format("T4:%d",j));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void testSynchronized(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testSynchronized1();
                    testSynchronized2();
                }
            }).start();
        }
    }

    public static void testBlockingQueue(){
        BlockingQueue<String> q = new ArrayBlockingQueue<>(10);
        new Thread(new multiThread.Producer(q)).start();
        new Thread(new multiThread.Consumer(q),"Consumer1").start();
        new Thread(new multiThread.Consumer(q),"Consumer2").start();
    }

    private static ThreadLocal<Integer> threadLocalUserIds = new ThreadLocal<>();
    private static int userId;
    public static void testThreadLocal(){
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        userId=finalI;
                        Thread.sleep(1);
                        System.out.println("UserId:"+userId);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        threadLocalUserIds.set(finalI);
                        Thread.sleep(1000);
                        System.out.println("ThreadLocal:"+threadLocalUserIds.get());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void testExecutor(){
//        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try{
                        Thread.sleep(1000);
                        System.out.println("Executor1:"+i);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try{
                        Thread.sleep(1000);
                        System.out.println("Executor2:"+i);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        service.shutdown();

        while (!service.isTerminated()){
            try {
                Thread.sleep(1000);
                System.out.println("Wait for termination.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int counter = 0;
    public static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void testWithoutAtomic(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                        for (int j = 0; j < 10; j++) {
//                            ++counter;
                            counter++;
                            System.out.println(counter);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    public static void testWithAtomic(){
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                        for (int j = 0; j < 10; j++) {
                            System.out.println(atomicInteger.incrementAndGet());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    public static void testAtomic(){
//        testWithoutAtomic();
        testWithAtomic();
    }

    public static void testFuture(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future=service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
//                throw new IllegalArgumentException("异常");
            }
        });

        service.shutdown();
        try {
//            System.out.println(future.get());
            System.out.println(future.get(100,TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testThrend();
//        testSynchronized();
//        testBlockingQueue();
//        testThreadLocal();
//        testExecutor();
//        testAtomic();
//        testFuture();
    }

}
