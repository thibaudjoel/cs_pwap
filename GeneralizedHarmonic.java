/* *****************************************************************************
* Takes two integer command-line arguments n and r and uses a for loop to
* compute the nth generalized harmonic number of order r.
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double harmonicMean = 0;
        for (int i = 1; i <= n; i++) {
            harmonicMean += 1 / Math.pow(i, r);
        }
        System.out.println(harmonicMean);
    }
}
