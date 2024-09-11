/* *****************************************************************************
* Takes two integer command-line arguments r and trials. In each of trials
* independent experiments, simulates a random walk until the random walker is at
* Manhattan distance r from the starting point. Prints the average number of
* steps.
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double total = 0.0;
        for (int i = 0; i < trials; i++) {
            int steps = 0;
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                int dir = (int) (4 * Math.random());
                if (dir == 0) {
                    x++;
                } else if (dir == 1) {
                    x--;
                } else if (dir == 2) {
                    y++;
                } else {
                    y--;
                }
                steps++;
            }
            total += steps;
        }
        System.out.println("average number of steps = " + (total / trials));
    }
}
