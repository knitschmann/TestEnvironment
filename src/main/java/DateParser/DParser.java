package DateParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DParser {

    static String input = "Fri, 15 Jun 2018 11:03:15 +0200";
    static SimpleDateFormat GoogleHomeFormatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    public static void main(String[] args) throws ParseException {
        Date parse = GoogleHomeFormatter.parse(input);
        System.out.println(parse);
    }

}
