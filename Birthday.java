/* *****************************************************************************
 * Takes two integer command-line arguments n and trials and performs the
 * following experiment, trials times:
 * Chooses a birthday for the next person, uniformly at random between 0 and n−1,
 * lets a person enter the room, if that person shares a birthday with someone
 * else in the room, stops; otherwise repeats.
 * In each experiment, counts the number of people that enter the room. Prints a
 * table that summarizes the results (the count i, the number of times that
 * exactly i people enter the room, and the fraction of times that i or fewer
 * people enter the room) for each possible value of i from 1 until the fraction
 * reaches (or exceeds) 50%.
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] peoples = new int[trials];
        for (int i = 0; i < trials; i++) {
            int people = 0;
            boolean[] birthdays = new boolean[n];
            while (true) {
                int birthday = (int) (Math.random() * n);
                people++;
                if (!birthdays[birthday]) {
                    birthdays[birthday] = true;
                }
                else {
                    peoples[i] = people;
                    break;
                }
            }
        }
        int maxCount = 0;
        for (int p : peoples) {
            maxCount = Math.max(p, maxCount);
        }
        int[] counts = new int[maxCount];

        for (int i = 0; i < trials; i++) {
            counts[peoples[i] - 1]++;
        }
        double[] cum = new double[maxCount];
        cum[0] = 0.0;
        for (int i = 1; i < maxCount; i++) {
            cum[i] = cum[i - 1] + counts[i] / (double) trials;
        }
        for (int i = 0; i < maxCount; i++) {
            System.out.print(i + 1 + " ");
            System.out.print(counts[i] + " ");
            System.out.print(cum[i]);
            System.out.println();
            if (cum[i] >= 0.5) {
                break;
            }
        }

    }
}
