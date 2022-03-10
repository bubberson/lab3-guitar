import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class GuitarString {
    private RingBuffer<Double> guitarString;

    public GuitarString(double frequency) {
        double sampleRate = 44100;
        int n = (int) Math.ceil(sampleRate / frequency);
        guitarString = new RingBuffer<Double>(n);

        for (int i = 0; i < guitarString.capacity(); i++) {
            guitarString.enqueue(0.0);
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
        guitarString.enqueue(((replaced + (Double) guitarString.peek()) / 2) * decayFactor);
    }

    public double sample() {
        return guitarString.peek();
    }

    public static void main(String[] args) {
        GuitarString test2 = new GuitarString(2);
        int tics = 25;
        for (int i = 0; i < tics; i++) {
            double loopsample = test2.sample();
            StdOut.printf("%6d %8.4f\n", i, loopsample);
            test2.tic();
        }
    }


}
