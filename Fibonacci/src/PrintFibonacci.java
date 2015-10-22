import java.util.ArrayList;
import java.util.List;

public class PrintFibonacci {
    public static void main(String[] args) {
        List<Long> list = generateFib(15);
        System. out.println(list .toString());

    }

    public static List<Long> generateFib(int fibLength) {
        if(fibLength < 0) return null;
        List<Long> result = new ArrayList<>();
        if (fibLength == 0) {
            result.add(0L);
            return result ;
        }
        if (fibLength == 1) {
            result.add(1L);
            return result ;
        }
        if (fibLength == 2) {
            result.add(1L);
            result.add(1L);
            return result ;
        }
        if (fibLength > 2) {
            result.add(1L);
            result.add(1L);
            for (int i = 2; i < fibLength ; i ++) {
                result.add( result.get( i - 2) + result.get( i - 1));
            }
        }
        return result ;
    }
}