/**
 * Created by kevin on 17/09/15.
 */
public class CallbyValue {
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        foo(aDog);

        if (aDog.getName().equals("Max")) { //true
            System.out.println("Java passes by value.");

        } else if (aDog.getName().equals("Fifi")) {
            System.out.println("Java passes by reference.");
        }
    }

    public static void foo(Dog d) {
//        d.setName("Fifi");
        System.out.println(d.getName().equals("Max")); // true
        d = new Dog("Fifi");
        System.out.println(d.getName().equals("Fifi")); // true

    }

    static class Dog {
        public String name;

        public Dog(String txt) {
            this.name = txt;
        }

        public String getName() {
            return this.name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
