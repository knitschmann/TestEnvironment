package XmlParser.read;

import XmlParser.api.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MySaxHandler extends DefaultHandler {

    List<Employee> empList = new ArrayList<>();
    Employee currentEmployee = null;
    String content = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            //Create a new Employee object when the start tag is found
            case "employee":
                currentEmployee = new Employee();
                currentEmployee.setId(attributes.getValue("id"));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            //Add the employee to list once end tag is found
            case "employee":
                empList.add(currentEmployee);
                break;
            //For all other end tags the employee has to be updated.
            case "firstName":
                currentEmployee.setFirstName(content);
                break;
            case "lastName":
                currentEmployee.setLastName(content);
                break;
            case "location":
                currentEmployee.setLocation(content);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public List<Employee> getEmpList() {
        return empList;
    }
}
