package XmlParser.read;

import XmlParser.api.Employee;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class StaxEventParsing {
    public static void main(String[] args) {
        List<Employee> employeeList = parseEventSTAX();
        System.out.println(employeeList);
    }

    private static List<Employee> parseEventSTAX() {
        List<Employee> employeeList = null;
        Employee currentEmployee = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = null;
        try {
            reader = factory.createXMLEventReader(ClassLoader.getSystemResourceAsStream("employees.xml"));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_DOCUMENT:
                        employeeList = new ArrayList<>();
                        break;

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        if ("employee".equals(startElement.getName().getLocalPart())) {
                            currentEmployee = new Employee();
                            currentEmployee.setId(String.valueOf(startElement.getAttributeByName(new QName("id"))));
                        }
                        if ("employees".equals(startElement.getName().getLocalPart())) {
                            employeeList = new ArrayList<>();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        tagContent = characters.getData().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        switch (endElement.getName().toString()) {
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


