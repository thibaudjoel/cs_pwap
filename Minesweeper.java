/* *****************************************************************************
 * Takes three integer command-line arguments m, n, and k and prints an m-by-n
 * grid of cells with k mines, using asterisks for mines and integers for the
 * neighboring mine counts
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] grid = new String[m][n];
        for (int i = 0; i < k; i++) {
            while (true) {
                int rand = (int) (Math.random() * m * n);
                int row = rand / n;
                int col = rand % n;
                if (grid[row][col] == null) {
                    grid[row][col] = "*";
                    break;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!(grid[i][j] == null))
                    System.out.print("*  ");
                else {
                    int counter = 0;
                    for (int r = -1; r < 2; r++) {
                        for (int c = -1; c < 2; c++) {
                            if (i + r >= 0 && i + r < m && j + c >= 0 && j + c < n) {
                                if (!(grid[i + r][j + c] == null)) {
                                    counter++;
                                }
                            }
                        }
                    }
                    System.out.print(counter + "  ");
                }
            }
            System.out.println();
        }
    }
}
