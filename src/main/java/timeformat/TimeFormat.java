package timeformat;

public class TimeFormat {
    public static void main(String[] args) {
        int hour = 12;
        int minutes = 18;
        String result = String.format("%02d:%02d", hour, minutes);
        System.out.println(result);
    }
}
