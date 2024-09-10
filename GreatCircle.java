/* *****************************************************************************
 *  takes four double command-line arguments x1, y1, x2, and y2 — the latitude
 * and longitude (in degrees) of two points on the surface of the earth—and
 * prints the great-circle distance (in kilometers) between them.
 **************************************************************************** */

public class GreatCircle {

    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double distance = 2 * 6371.0 * Math.asin(Math.sqrt(
                Math.pow(Math.sin((x2 - x1) / 2), 2) + Math.cos(x1) * Math.cos(x2) * Math.pow(
                        Math.sin((y2 - y1) / 2), 2)));
        System.out.print(distance + " kilometers");
    }
}
