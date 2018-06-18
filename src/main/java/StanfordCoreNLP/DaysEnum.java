package StanfordCoreNLP;

import de.jollyday.config.RelativeToEasterSunday;

/**
 * Created by kevin on 31/07/15.
 */
public enum DaysEnum {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY,FRIDAY,SATURDAY,SUNDAY;

    public String tellItLikeThis() {

        switch (this) {
            case MONDAY:
                return "Monday is awesome";
            default:
                return "Some other day";
        }
    }
}
