/*
 * Reads boundary information of a country (or other geographic entity) from
 * standard input and plots the results to standard drawing.
 */
public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int poly = StdIn.readInt();
            double[][] cords = new double[2][poly];
            for (int i = 0; i < poly; i++) {
                cords[0][i] = StdIn.readDouble();
                cords[1][i] = StdIn.readDouble();
            }
            StdDraw.polygon(cords[0], cords[1]);
        }
        StdDraw.show();
    }
}
