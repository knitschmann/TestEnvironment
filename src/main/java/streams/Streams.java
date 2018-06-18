package streams;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("2");
        list.add("three");
        list.add("4");
        list.add("five");
        list.add("6");
        list.add("seven");

        list = list
                .stream()
                .filter(entry -> isSomething(entry))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static boolean isSomething(String input) {
        if (StringUtils.isNumeric(input)) {
            return true;
        }
        return false;
    }
}
