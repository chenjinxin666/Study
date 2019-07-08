package test1;

import test1.CircularArrayFIFOQueue;

public class Main {
    public static void main(String[] args) {
        testQueue();
    }

    public static void testQueue(){
        CircularArrayFIFOQueue circularArrayFIFOQueue = new CircularArrayFIFOQueue(8);
        circularArrayFIFOQueue.enqueue(1);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue('a');
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(2.0);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(3.2f);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(1l);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue("a");
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(2);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(3);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());

        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());

        circularArrayFIFOQueue.enqueue(1);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue('a');
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(2.0);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(3.2f);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(1l);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue("a");
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(2);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        circularArrayFIFOQueue.enqueue(3);
        System.out.println(circularArrayFIFOQueue.toString());
        System.out.println("队列长度："+circularArrayFIFOQueue.size());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());

        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
        System.out.println("出队："+circularArrayFIFOQueue.dequeue());
    }
}
