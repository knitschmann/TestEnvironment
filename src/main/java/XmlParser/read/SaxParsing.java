package XmlParser.read;

import XmlParser.api.Employee;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParsing {
    public static void main(String[] args) {
        List<Employee> employeeList = parseSAX();
        System.out.println(employeeList);
    }

    private static List<Employee> parseSAX() {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = null;
        MySaxHandler handler = null;
        try {
            parser = parserFactor.newSAXParser();
            handler = new MySaxHandler();

            parser.parse(ClassLoader.getSystemResourceAsStream("employees.xml"),
                    handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (handler != null) {
            return handler.getEmpList();
        } else {
            return null;
        }
    }
}
