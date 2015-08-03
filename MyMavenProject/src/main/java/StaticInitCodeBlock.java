/**
 * Created by kevin on 31/07/15.
 */
public class StaticInitCodeBlock {

        static int staticVariable;
        int nonStaticVariable;

        // Static initialization block:
        // Runs once (when the class is initialized).
        static {
            System.out.println("Static initalization.");
            staticVariable = 5;
        }

        // Instance initialization block:
        // Runs before the constructor each time you instantiate an object
        {
            System.out.println("Instance initialization.");
            nonStaticVariable = 7;
        }

        public StaticInitCodeBlock() {
            System.out.println("Constructor.");
        }

        public static void main(String[] args) {
            new StaticInitCodeBlock();
            new StaticInitCodeBlock();
        }
}
