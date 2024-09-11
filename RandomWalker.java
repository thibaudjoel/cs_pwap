/* *****************************************************************************
* Takes an integer command-line argument r and simulates the motion of a random
* walk until the random walker is at Manhattan distance r from the starting
* point. Prints the coordinates at each step of the walk, treating the starting
* point as (0, 0) and prints the total number of steps taken.
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ")");
        while (Math.abs(x) + Math.abs(y) < r) {
            int dir = (int) (4 * Math.random());
            System.out.println(dir);
            if (dir == 0) {
                x++;
            }
            else if (dir == 1) {
                x--;
            }
            else if (dir == 2) {
                y++;
            }
            else {
                y--;
            }
            steps++;
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
