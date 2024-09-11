/*
 * Library to manipulate digital audio
 */

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] out = new double[a.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = a[i] * alpha;
        }
        return out;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] out = new double[a.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = a[a.length - 1 - i];
        }
        return out;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] out = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            out[a.length + i] = b[i];
        }
        return out;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] taller;
        double[] shorter;
        if (a.length > b.length) {
            taller = a;
            shorter = b;
        }
        else {
            taller = b;
            shorter = a;
        }
        double[] out = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < shorter.length; i++) {
            out[i] = taller[i] + shorter[i];
        }
        for (int i = shorter.length; i < taller.length; i++) {
            out[i] = taller[i];
        }
        return out;

    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] out = new double[(int) Math.floor(a.length / alpha)];
        for (int i = 0; i < out.length; i++) {
            out[i] = a[(int) Math.floor(i * alpha)];
        }
        return out;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] beatboxFast = changeSpeed(beatbox, 1.2);
        double[] beatboxVeryFast = changeSpeed(beatbox, 1.4);
        double[] beatboxFinal = merge(merge(beatbox, beatboxFast), beatboxVeryFast);
        double[] pianoSong = mix(piano, singer);
        double[] chimesAmpl = amplify(chimes, 0.9);
        double[] beatRev = reverse(beatboxFinal);
        double[] out = merge(merge(buzzer, beatboxFinal), merge(pianoSong, merge(chimesAmpl, beatRev)));
        StdAudio.play(out);
    }
}
