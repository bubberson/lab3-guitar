import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GuitarString {
    private RingBuffer<Number> guitarString;

    public GuitarString(double frequency) {
        double sampleRate = 44100;
        int n = (int) Math.ceil(sampleRate / frequency);
        guitarString = new RingBuffer<>(n);

        for (int i = 0; i < guitarString.capacity(); i++) {
            guitarString.enqueue(0);
        }
    }
    public GuitarString(double[] init){
        int counter = 0;
        try {
            while (true){
                init[counter] = init[counter];
                counter += 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            guitarString = new RingBuffer<>(counter);
            for (int i = 0; i < counter; i++) {
                guitarString.enqueue(init[i]);
            }
        }
    }
    public int length() {
        return guitarString.size();
    }

    public void pluck() {
        for (int i = 0; i < guitarString.size(); i++) {
            guitarString.dequeue();
            guitarString.enqueue(StdRandom.uniform(-0.5, 0.5));
        }
    }
    public void tic() {
        double decayFactor = 0.90;
        double replaced = guitarString.dequeue();
        guitarString.enqueue(((replaced + guitarString.peek()) / 2) * decayFactor);
    }

    public double sample() {
        return guitarString.peek();
    }

    public static void main(String[] args) {
        double[] Array1 = { 0.0, 0.0, 0.0, 0.0, 0.0 };
        GuitarString test = new GuitarString(Array1);
        StdOut.println(test.length());
        StdOut.println(test.sample());
        test.pluck();
        StdOut.println(test.length());
        StdOut.println(test.sample());

        double[] sample = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, -0.3, 0.0, -0.1, -0.3 };
        GuitarString test2 = new GuitarString(sample);
        int tics = 25;
        for (int i = 0; i < tics; i++) {
            double loopsample = test2.sample();
            StdOut.printf("%6d %8.4f\n", i, loopsample);
            test2.tic();
        }
    }


}
