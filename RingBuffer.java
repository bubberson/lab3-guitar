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
    public Item dequeue(){
        if (isEmpty()){
            throw new RuntimeException("RuntimeException: Queue is empty!!!");
        }
        Item temp =  ring[first];
        first = (first + 1) % capacity();
        n--;
        return temp;


    }

    public Item peek(){
        if (isEmpty()) {
            throw new RuntimeException("RuntimeException in Ringbuffer: Queue is Empty");
        }
        Item v = ring[first];
        return v;
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
        for (int i = 0; i < ring.length; i++){
            StdOut.println(ring[i]);
        }
    }

    public static void main(String[] args) {
        RingBuffer<Double> buffer = new RingBuffer<>(3);
        buffer.enqueue(2.0);
        buffer.enqueue(3.0);
        buffer.enqueue(4.0);
        buffer.display();
        StdOut.println("----incoming enqueue while at capacity----");


        StdOut.println(buffer.peek());
    }
}