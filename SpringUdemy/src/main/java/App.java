import org.springframework.context.ApplicationContext;

/**
 * Created by kevin on 30/09/15.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context;

        Person person = new Person();
        person.speak();
    }
}
