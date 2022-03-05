import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static void main(String[] args) {
        int notes = 37;
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] myStrings = new GuitarString[notes];

        for (int i = 0; i < notes; i++) {
            double frequency = 440 * Math.pow(2, ((i - 24) / 12.0));

            myStrings[i] = new GuitarString(frequency);

        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {

                char key = StdDraw.nextKeyTyped();

                if (keyboard.indexOf(key) >= 0) {
                    (myStrings[keyboard.indexOf(key)]).pluck();
                } else
                    System.out.println("wrong key...");
            }

            double sample = 0;
            for (int i = 0; i < notes; i++) {
                sample =  sample + ( myStrings[i]).sample();
            }

            StdAudio.play(sample);

            for (int i = 0; i < notes; i++) {
                (myStrings[i]).tic();
            }
        }



    }
}
