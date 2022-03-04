import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<Double> {
    public double[] ring;
    private int front;
    private int end;
    private int n;

    public RingBuffer(int capacity) {
        ring = new double[capacity];
        front = 0;
        end = 0;
        n = 0;
    }

    public int capacity(){
        return ring.length;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull() {
        return size() == capacity();
    }

    public void enqueue(double x){
        if (isFull()) {
            StdOut.println("full");
        } else {
            ring[end] = x;
            end = (++end) % capacity();
            n++;
        }
    }

    public double dequeue(){
        if (isEmpty()){
            StdOut.println("EMPTY");
        } else {
            double temp = ring[front];
            front = (++front) % capacity();
            n--;
            return temp;
        }
        return -1;
    }

    public double peek(){
        if (!isEmpty()) {
            return ring[front];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        RingBuffer<Double> ringbuf = new RingBuffer<Double>(10);
        ringbuf.enqueue(0.2);
        StdOut.println(ringbuf.size());
        ringbuf.enqueue(0.1);
        StdOut.println(ringbuf.size());
        ringbuf.enqueue(0.5);
        StdOut.println(ringbuf.size());
        ringbuf.enqueue(0.1);
        StdOut.println(ringbuf.size());
        ringbuf.enqueue(0.1);
        StdOut.println(ringbuf.size());
        StdOut.println("--end--");
        StdOut.println(ringbuf.end);

        ringbuf.dequeue();
        StdOut.println(ringbuf.size());
        ringbuf.dequeue();
        StdOut.println("------break------");
        StdOut.println(ringbuf.size());
        StdOut.println(ringbuf.front);
        StdOut.println(ringbuf.end);

        for (int i = ringbuf.front; i < ringbuf.end; i++){
            StdOut.println(ringbuf.ring[i]);
            StdOut.println("hey");
        }
        StdOut.println("--peek--");
        StdOut.println(ringbuf.peek());
    }





}
