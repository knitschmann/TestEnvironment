import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by kevin on 30/09/15.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("/SpringUdemy/beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
        ((FileSystemXmlApplicationContext)context).close();

    }
}
