/*
 * Takes a command-line integer m; reads a sequence of integers between 1 and m
 * from standard input; and prints the Shannon entropy to standard output, with
 * 4 digits after the decimal point
 */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] counts = new int[m];
        int total = 0;

        while (!StdIn.isEmpty()) {
            int nextInt = StdIn.readInt();
            counts[nextInt - 1]++;
            total++;
        }
        double shannon = 0;
        for (int i = 1; i <= counts.length; i++) {
            if (counts[i - 1] != 0) {
                double p = (double) counts[i - 1] / total;
                shannon += p * Math.log(p) / Math.log(2);
            }
        }

        StdOut.println(String.format("%.4f", -shannon));

    }
}
