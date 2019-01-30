package FizzBuzz;

public class Fizz {

    public static void main(String[] args) {
        fizzBuzz(100);
    }

    public static void fizzBuzz(int num) {
        if (num >= 0) {
            if (num % 3 == 0) {
                System.out.println("fizz");
                fizzBuzz(--num);
            } else if (num % 5 == 0) {
                System.out.println("buzz");
                fizzBuzz(--num);
            } else {
                System.out.println(num);
                fizzBuzz(--num);
            }
        }
    }

//    https://www.chrisnewland.com/high-performance-modulo-operation-317
//    public static int fastModulo(int dividend, int divisor) {
//        return dividend & (divisor - 1);
//    }
}
