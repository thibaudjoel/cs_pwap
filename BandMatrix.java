/* *****************************************************************************
* Takes two integer command-line arguments n and width and prints an n-by-n
* pattern like the ones below, with a zero (0) for each element whose distance
* from the main diagonal is strictly more than width, and an asterisk (*) for
* each entry that is not, and two spaces between each 0 or *.
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int i = 1; i <= n; i++) {
            String line = "";
            for (int j = 1; j <= n; j++) {
                if (Math.abs(i - j) > width) {
                    line += "0";
                }
                else {
                    line += "*";
                }
                if (j != n) {
                    line += "  ";
                }
            }
            System.out.println(line);
        }
    }
}
