/*
 * Implements a class that represents a color in hue–saturation–brightness (HSB)
 * format.
 */
public class ColorHSB {
    private static final int MAX_H = 360;
    private final int h, s, b;
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= MAX_H) {
            throw new IllegalArgumentException("h has to be between 0 and 359");
        }
        if (s < 0 || s > 100) {
            throw new IllegalArgumentException("s has to be between 0 and 100");
        }
        if (b < 0 || b > 100) {
            throw new IllegalArgumentException("b has to be between 0 and 100");
        }
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" +h + ", " + s + ", " + b +")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("that cannot be null");
        }
        int hDist = Math.abs(this.h - that.h);
        int sDist = this.s - that.s;
        int bDist = this.b - that.b;
        return Math.min(hDist * hDist, (MAX_H - hDist) * (MAX_H - hDist)) + sDist * sDist + bDist * bDist;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB col = new ColorHSB(h, s, b);
        String outName = "";
        ColorHSB outCol = null;
        int minDist = MAX_H * MAX_H + 2 * 100 * 100;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int hNew = StdIn.readInt();
            int sNew = StdIn.readInt();
            int bNew = StdIn.readInt();
            ColorHSB newCol = new ColorHSB(hNew, sNew, bNew);
            int dist = col.distanceSquaredTo(newCol);
            if (dist < minDist) {
                outName = name;
                outCol = newCol;
                minDist = dist;
            }
        }
        StdOut.println(outName + " " + outCol.toString());
    }
}
