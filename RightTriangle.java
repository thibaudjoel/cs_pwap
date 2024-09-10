/* *****************************************************************************
 * Takes three int command-line arguments and determines whether they constitute
 * the side lengths of some right triangle.
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean positive = a > 0 && b > 0 && c > 0;
        boolean first = a * a + b * b == c * c;
        boolean second = a * a + c * c == b * b;
        boolean third = c * c + b * b == a * a;
        System.out.println(positive && (first || second || third));
    }
}
