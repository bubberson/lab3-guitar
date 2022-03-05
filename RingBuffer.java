import edu.princeton.cs.algs4.StdOut;

public class RingBuffer<Item> {
    private Item[] ring;
    private int first; //index of the next dequeue or peek
    private int last; //index of next enqueue
    private int n; // number of elements on the buffer

    public RingBuffer(int capacity) {

        ring = (Item[]) new Object[capacity];

        first = 0;
        last = 0;
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

    // adds item X to the end of ringbuffer
    public void enqueue(Item x){
        if (isFull()) {
            StdOut.println("full, resizing");
//            resize(2 * ring.length);
//            throw new RuntimeException("queue is full, ");
        }
        ring[last] = x;
        last = (last + 1) % capacity();
        n++;
    }

    // deletes and returns item at the front of ringbuffer
    public double dequeue(){
        if (isEmpty()){
            throw new RuntimeException("RuntimeException: Queue is empty!!!");
        }
        double temp = (double) ring[first];
        first = (first + 1) % capacity();
        n--;
        return temp;

    }

    public Item peek(){
        if (!isEmpty()) {
            return ring[first];
        } else {
            throw new RuntimeException("Runtime Exception: Queue is empty (--from method PEEK()--)");
        }
    }

//    private void resize(int capacity){
//        assert capacity >= n;
//        Item[] copy = (Item[]) new Object[capacity];
//        for(int i = 0; i < n; i++){
//            copy[i] = ring[(first + i) % ring.length];
//        }
//        ring = copy;
//        first = 0;
//        last = n;
//    }
    public void display() {
        for (int i = 0; i < n; i++){
            StdOut.println(ring[i]);
        }
    }

    public static void main(String[] args) {
        RingBuffer<Double> buffer = new RingBuffer<>(10);
        int s = 100;
        for (int i = 1; i <= s; i++) {
            buffer.enqueue((double) i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("size after wrap around:" + buffer.size());

        while (buffer.size() <= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());


        //        buffer.enqueue(0.2);
//        StdOut.println(buffer.size());
//        buffer.enqueue(0.1);
//        StdOut.println(buffer.size());
//        buffer.enqueue(0.5);
//        StdOut.println(buffer.size());
//        buffer.enqueue(0.1);
//        StdOut.println(buffer.size());
//        buffer.enqueue(0.1);
//        StdOut.println(buffer.size());
//        StdOut.println("--end--");
//        StdOut.println(buffer.last);
//
//        buffer.dequeue();
//        StdOut.println(buffer.size());
//        buffer.dequeue();
//        StdOut.println("------break------");
//        StdOut.println(buffer.size());
//        StdOut.println(buffer.first);
//        StdOut.println(buffer.last);
//        StdOut.println("--peek--");
//        StdOut.println(buffer.peek());
//        StdOut.println("--Display--");
//        buffer.display();
//        StdOut.println("");

    }





}
