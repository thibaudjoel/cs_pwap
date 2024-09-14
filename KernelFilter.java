/*
 * Implements a class for applying various kernel filters to images.
 */
import java.awt.Color;



public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        return new Picture(picture);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        Picture out = new Picture(picture.width(), picture.height());
        int[][] red = new int[picture.width()][picture.height()];
        int[][] green = new int[picture.width()][picture.height()];
        int[][] blue = new int[picture.width()][picture.height()];

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                red[j][i] = picture.get(j, i).getRed();
                green[j][i] = picture.get(j, i).getGreen();
                blue[j][i] = picture.get(j, i).getBlue();
            }
        }
        int[][] filter = {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}
        };

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int row = 0; row < filter.length; row++) {
                    for (int col = 0; col < filter[0].length; col++) {
                        r += filter[row][col] * red[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        g += filter[row][col] * green[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        b += filter[row][col] * blue[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                    }
                }
                r = Math.max(Math.min((int) Math.round(r / 16.), 255), 0);
                g = Math.max(Math.min((int) Math.round(g / 16.), 255), 0);
                b = Math.max(Math.min((int) Math.round(b / 16.), 255), 0);
                out.set(j, i, new Color(r, g, b));
            }
        }
        return out;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        Picture out = new Picture(picture.width(), picture.height());
        int[][] red = new int[picture.width()][picture.height()];
        int[][] green = new int[picture.width()][picture.height()];
        int[][] blue = new int[picture.width()][picture.height()];

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                red[j][i] = picture.get(j, i).getRed();
                green[j][i] = picture.get(j, i).getGreen();
                blue[j][i] = picture.get(j, i).getBlue();
            }
        }
        int[][] filter = {
                {0, -1, 0},
                {-1, 5, -1},
                {0, -1, 0}
        };

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int row = 0; row < filter.length; row++) {
                    for (int col = 0; col < filter[0].length; col++) {
                        r += filter[row][col] * red[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        g += filter[row][col] * green[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        b += filter[row][col] * blue[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                    }
                }
                r = Math.max(Math.min(r, 255), 0);
                g = Math.max(Math.min(g, 255), 0);
                b = Math.max(Math.min(b, 255), 0);
                out.set(j, i, new Color(r, g, b));
            }
        }

        return out;
    }

    // Returns a new picture that applies a Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        Picture out = new Picture(picture.width(), picture.height());
        int[][] red = new int[picture.width()][picture.height()];
        int[][] green = new int[picture.width()][picture.height()];
        int[][] blue = new int[picture.width()][picture.height()];

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                red[j][i] = picture.get(j, i).getRed();
                green[j][i] = picture.get(j, i).getGreen();
                blue[j][i] = picture.get(j, i).getBlue();
            }
        }
        int[][] filter = {
                {-1, -1, -1},
                {-1,  8, -1},
                {-1, -1, -1}
        };

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int row = 0; row < filter.length; row++) {
                    for (int col = 0; col < filter[0].length; col++) {
                        r += filter[row][col] * red[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        g += filter[row][col] * green[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        b += filter[row][col] * blue[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                    }
                }
                r = Math.max(Math.min(r, 255), 0);
                g = Math.max(Math.min(g, 255), 0);
                b = Math.max(Math.min(b, 255), 0);
                out.set(j, i, new Color(r, g, b));
            }
        }
        return out;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        Picture out = new Picture(picture.width(), picture.height());
        int[][] red = new int[picture.width()][picture.height()];
        int[][] green = new int[picture.width()][picture.height()];
        int[][] blue = new int[picture.width()][picture.height()];

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                red[j][i] = picture.get(j, i).getRed();
                green[j][i] = picture.get(j, i).getGreen();
                blue[j][i] = picture.get(j, i).getBlue();
            }
        }
        int[][] filter = {
                {-2, -1, 0},
                {-1,  1, 1},
                { 0,  1, 2}
        };

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int row = 0; row < filter.length; row++) {
                    for (int col = 0; col < filter[0].length; col++) {
                        r += filter[row][col] * red[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        g += filter[row][col] * green[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                        b += filter[row][col] * blue[(j + col - 1 + out.width()) % out.width()][(i + row - 1 + out.height()) % out.height()];
                    }
                }
                r = Math.max(Math.min(r, 255), 0);
                g = Math.max(Math.min(g, 255), 0);
                b = Math.max(Math.min(b, 255), 0);
                out.set(j, i, new Color(r, g, b));
            }
        }
        return out;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        Picture out = new Picture(picture.width(), picture.height());
        int[][] red = new int[picture.width()][picture.height()];
        int[][] green = new int[picture.width()][picture.height()];
        int[][] blue = new int[picture.width()][picture.height()];

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                red[j][i] = picture.get(j, i).getRed();
                green[j][i] = picture.get(j, i).getGreen();
                blue[j][i] = picture.get(j, i).getBlue();
            }
        }

        for (int i = 0; i < out.height(); i++) {
            for (int j = 0; j < out.width(); j++) {
                int r = 0;
                int g = 0;
                int b = 0;
                for (int k = 0; k < 9; k++) {
                        r += red[(j + k - 4 + out.width()) % out.width()][(i + k - 4 + out.height()) % out.height()];
                        g += green[(j + k - 4 + out.width()) % out.width()][(i + k - 4 + out.height()) % out.height()];
                        b += blue[(j + k - 4 + out.width()) % out.width()][(i + k - 4 + out.height()) % out.height()];
                }
                r = Math.max(Math.min((int) Math.round(r / 9.), 255), 0);
                g = Math.max(Math.min((int) Math.round(g / 9.), 255), 0);
                b = Math.max(Math.min((int) Math.round(b / 9.), 255), 0);
                out.set(j, i, new Color(r, g, b));
            }
        }
        return out;
    }

    // Test client
    public static void main(String[] args) {
        Picture picture = new Picture("baboon.png");
        Picture iden = identity(picture);
        Picture gauss = gaussian(picture);
        Picture sharp = sharpen(picture);
        Picture laplace = laplacian(picture);
        Picture emb = emboss(picture);
        Picture blur = motionBlur(picture);
        iden.show();
        gauss.show();
        sharp.show();
        laplace.show();
        emb.show();
        blur.show();
    }

}

