package XmlParser.read;

import XmlParser.api.Employee;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupParsing {
    public static void main(String[] args) {
        File input = new File("/Users/kni/Documents/dev/TestEnvironment/src/main/resources/employees.xml");
        List<Employee> employees = parseJsoup(input);
        System.out.println(employees);
    }

    private static List<Employee> parseJsoup(File file) {
        List<Employee> result = new ArrayList<>();
        try {
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements employeeNodes = doc.getElementsByTag("employee");
            for (Element ele: employeeNodes) {
                Employee employee = new Employee();
                Element firstName = ele.getElementsByTag("firstName").first();
                if(firstName != null){
                    employee.setFirstName(firstName.text());
                }
                Element lastName = ele.getElementsByTag("lastName").first();
                if(lastName != null){
                    employee.setLastName(lastName.text());
                }
                Element location = ele.getElementsByTag("location").first();
                if(location != null){
                    employee.setLocation(location.text());
                }
                employee.setId(ele.attr("id"));
                result.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
