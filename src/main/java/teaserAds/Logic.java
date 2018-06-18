package teaserAds;

import java.util.Arrays;
import java.util.List;

public class Logic {
    public static void main(String[] args) {
        renderTeasers();
    }

    public static void renderTeasers() {
        List<String> resultItems = Arrays.asList("I1I ", "I2I ", "I3I ", "I4I ", "I5I ", "I6I ", "I7I ", "I8I ", "I9I ", "I10I ", "I11I ", "I12I ");
        List<Integer> adPositions = Arrays.asList(1, 2, 3, 999);

        int count = 0;
        int end = resultItems.size() + adPositions.size();
        for (int i = 1; i <= (end); i++) {
            if (adPositions.contains(i) || resultItems.size() <= count) {
                System.out.print("mr ");
            } else {
                String resultItem = resultItems.get(count);
                System.out.print(resultItem);
                count++;
            }
        }
    }
}
