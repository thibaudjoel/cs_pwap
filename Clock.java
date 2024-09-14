/*
 * Implements a class that that represents time on a 24-hour clock.
 */

public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private int h, m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("hour has to be between 0 and 23");
        }
        if (m < 0 || m >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("minute has to be between 0 and 59");
        }
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) {
            throw new IllegalArgumentException("time must be formatted in HH:MM");
        }
        if (s.charAt(2) != ':') {
            throw new IllegalArgumentException("time must be formatted in HH:MM");
        }

        int hour = Integer.parseInt(s.substring(0, 2));
        int min = Integer.parseInt(s.substring(3, 5));

        if (hour < 0 || hour >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("hour has to be between 0 and 23");
        }
        if (min < 0 || min >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("minute has to be between 0 and 59");
        }
        this.h = hour;
        this.m = min;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d", h) + ":" + String.format("%02d", m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.h < that.h) {
            return true;
        } else if (this.h == that.h) {
            return this.m < that.m;
        } else {
            return false;
        }
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.m = (this.m + 1) % MINUTES_PER_HOUR;
        if (this.m == 0) {
            this.h = (this.h + 1) % HOURS_PER_DAY;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("delta must be non-negative");
        }
        this.h = (this.h + delta / MINUTES_PER_HOUR) % HOURS_PER_DAY;
        if (delta % MINUTES_PER_HOUR >= MINUTES_PER_HOUR - this.m) {
            this.h = (this.h + 1) % HOURS_PER_DAY;
        }
        this.m = (this.m + delta % MINUTES_PER_HOUR) % MINUTES_PER_HOUR;
    }

    // Test client
    public static void main(String[] args) {
        Clock clock = new Clock(0, 0);
        System.out.println(clock);
        Clock clock1 = new Clock("01:00");
        System.out.println(clock1);
        clock.toc(120);
        System.out.println(clock);
        clock1.toc(180);
        System.out.println(clock1);
        System.out.println(clock.isEarlierThan(clock1));
        clock1.tic();
        System.out.println(clock1);
    }
}
