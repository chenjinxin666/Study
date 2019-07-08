package test1;

public class CircularArrayFIFOQueue implements Queue {
    /**
     * 环形数组大小上限
     */
    private static final int MAX_ARRAY_SIZE = 65536;
    /**
     * 环形数组，存放队列元素
     */
    private Object[] items;
    /**
     * 队列头部（在 items 中）的下标
     */
    private int front;
    /**
     * 队列尾部（在 items 中）的下标
     */
    private int rear;
    /**
     * 队列长度
     */
    private int LENGTH;
    /**
     * 带参数的构造函数，输入参数为队列初始化的大小。此处约定队列长度不得超过初始化的长度。初始化时，
     rear 应指向 front 的“前”一元素。
     * @param initQueueSize 队列中最多可容纳的元素数量
     */
    public CircularArrayFIFOQueue(int initQueueSize) {
        if (initQueueSize > MAX_ARRAY_SIZE){
            System.out.println("定义长度超过限制，请定义长度不超过 65535 的队列。");
            return;
        }
        items=new Object[initQueueSize];
        front=0;
        rear=initQueueSize-1;
        LENGTH=initQueueSize;
    }

    @Override
    public boolean enqueue(Object o) {
        if((rear + 2) % LENGTH ==front){
            System.out.println("插入失败，队列已满！");
        }else if((rear + 1) % LENGTH ==front){
            front=0;
            rear=0;
            items[rear]=o;
        }else{
            rear=(++rear)%LENGTH;
            items[rear]=o;
        }
        return false;
    }

    @Override
    public Object dequeue() {
        if ((rear + 1) % LENGTH ==front){
            return "队列为空！";
        }
        int t=front;
        front=++front%LENGTH;
        return items[t];
    }

    @Override
    public int size() {
        return Math.abs(rear-front)+1;
    }

    @Override
    public String toString() {
        String str="队列内容：";
        int len=this.size();
        for (int i = 0,j=front; i < len; i++,++j) {
            str+=items[j%LENGTH]+" ";
        }
        return str;
    }
}