package XmlParser.read;

import XmlParser.api.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxStreamParsing {
    public static void main(String[] args) {
        List<Employee> employeeList = parseStreamSTAX();
        System.out.println(employeeList);
    }

    private static List<Employee> parseStreamSTAX() {
        List<Employee> employeeList = null;
        Employee currentEmployee = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("employees.xml"));
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("employees".equals(reader.getLocalName())) {
                            employeeList = new ArrayList<>();
                        }

                        if ("employee".equals(reader.getLocalName())) {
                            currentEmployee = new Employee();
                            currentEmployee.setId(reader.getAttributeValue(0));
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "employee":
                                employeeList.add(currentEmployee);
                                break;
                            case "firstName":
                                currentEmployee.setFirstName(tagContent);
                                break;
                            case "lastName":
                                currentEmployee.setLastName(tagContent);
                                break;
                            case "location":
                                currentEmployee.setLocation(tagContent);
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}


