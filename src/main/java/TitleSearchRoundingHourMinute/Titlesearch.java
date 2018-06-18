package TitleSearchRoundingHourMinute;

import java.util.Calendar;
import java.util.TimeZone;

public class Titlesearch {


    public static void main(String[] args) {
        calc(10, 30);
        calc(10, 36);
        calc(10, 50);
        calc(10, 51);
        System.out.println("---");
        calcNow();

    }

    public static void calc(int hour, int minute) {

        int currentMinutes = minute;

        Double roundableMinutes = (double) currentMinutes;
        roundableMinutes = ((Math.ceil(roundableMinutes / 10)) * 10 % 60);
        int displayedMinutes = roundableMinutes.intValue();

        int displayedHour = hour;
        if (currentMinutes > 50) {
            displayedHour++;
        }

        System.out.println(displayedHour + " : " + displayedMinutes);
    }

    public static void calcNow() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));

        int currentMinutes = cal.get(Calendar.MINUTE);
        Double roundableMinutes = (double) currentMinutes;
        roundableMinutes = ((Math.ceil(roundableMinutes / 10)) * 10 % 60);
        int displayedMinutes = roundableMinutes.intValue();

        int displayedHour = cal.get(Calendar.HOUR_OF_DAY);
        if (currentMinutes > 50) {
            displayedHour++;
        }

        System.out.println(displayedHour + " : " + displayedMinutes);
    }
}
