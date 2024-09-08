/* *****************************************************************************
 *  Takes an integer command-line argument n and prints an n-by-n pattern with
 * a + (plus sign) in row i and column j if bits i and j in the Thue-Morse-
 * sequence are equal, and a - (minus sign) if they are different.
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] sequence = new boolean[n];
        sequence[0] = false;
        int power = 1;
        for (int i = 1; i < n; i++) {
            sequence[i] = !sequence[i % (int) Math.pow(2, power - 1)];
            if ((i + 1) == Math.pow(2, power)) {
                power++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}

