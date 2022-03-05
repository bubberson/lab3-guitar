import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHeroLite {
    public static void main(String[] args) {
        //create two guitar strings, for A and C
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        while (true){

            //check if user has typed a key, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                }else if (key == 'c') {
                    stringC.pluck();
                }
            }
            //compute the superposition of samples
            double sample = stringA.sample() + stringC.sample();

            //play the sample on standard audio
            StdAudio.play(sample);

            //advance, step by step
            stringA.tic();
            stringC.tic();
        }
    }
}

