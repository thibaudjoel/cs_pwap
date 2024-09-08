/* *****************************************************************************
* Takes an integer command-line argument m, followed by a sequence of positive
* integer command-line arguments a_1,a_2,…,a_n, and prints m random indices
* (separated by whitespace), choosing each index i with probability proportional
* to a_i.
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] cumSum = new int[args.length];
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + Integer.parseInt(args[i]);
        }
        for (int i = 0; i < m; i++) {
            int interval = (int) ((cumSum[cumSum.length - 1]) * Math.random());
            int index = 1;
            while (!(cumSum[index - 1] <= interval && interval < cumSum[index])) {
                index++;
            }
            System.out.print(index + " ");
        }
    }
}
