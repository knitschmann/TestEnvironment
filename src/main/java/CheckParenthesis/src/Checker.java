package CheckParenthesis.src;

import java.util.Stack;

/**
 * Created by kevin on 22/10/15.
 */
public class Checker {

    public static void main(String[] args) {
        System.out.println(checkP("(aa){{}}"));
        System.out.println(checkP("(aa))"));
    }

    private static boolean checkP(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '{') stack.push(c);

            if (c == ')') {
                if (stack.isEmpty()) return false;
                else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }

            if (c == '}') {
                if (stack.isEmpty()) return false;
                else {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }


        }
        return stack.isEmpty();
    }


}
