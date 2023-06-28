package JavaBasics;

import java.util.Calendar;
import static java.lang.System.out;

public class FullMoons {
    static int DAY_IM = 1000 * 3600 * 24;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0 ,7 ,15, 40);
        out.println("current date and time: " + c.getTime());

        long day1 = c.getTimeInMillis();
        for (int x = 0; x < 5; x++) {
            day1 += DAY_IM * 29.52;
            c.setTimeInMillis(day1);
            out.println(String.format("full moon on %tc", c));
        }
    }
}
