/*
 * Class to analyze a DNA string for Huntington’s disease and produce a
 * diagnosis.
 */
public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int maxCount = 0;
        int i = 0;
        while (i + 2 < dna.length()) {
            int count = 0;
            if (dna.startsWith("CAG", i)) {
                count++;
                i += 3;
                while (dna.startsWith("CAG", i)) {
                    count++;
                    i += 3;
                }
                maxCount = Math.max(count, maxCount);
            }
            else {
                i++;
            }
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        } else if (maxRepeats < 36) {
            return "normal";
        } else if (maxRepeats < 40) {
            return "high risk";
        } else if (maxRepeats < 181) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        In file = new In(filename);
        String dna = file.readAll();
        file.close();
        dna = removeWhitespace(dna);
        int maxRepeats = maxRepeats(dna);
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose(maxRepeats));
    }
}
