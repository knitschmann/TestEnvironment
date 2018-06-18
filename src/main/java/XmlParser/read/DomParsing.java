package XmlParser.read;

import XmlParser.api.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParsing {

    public static void main(String[] args) {
        List<Employee> employeeList = parseDOM();
        System.out.println(employeeList);
    }

    private static List<Employee> parseDOM() {
        List<Employee> employeeList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(ClassLoader.getSystemResourceAsStream("employees.xml"));

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Employee currentEmployee = new Employee();
                    currentEmployee.setId(node.getAttributes().getNamedItem("id").getNodeValue());

                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node cNode = childNodes.item(j);

                        //Identifying the child tag of currentEmployee encountered.
                        if (cNode instanceof Element) {
                            String content = cNode.getLastChild().
                                    getTextContent().trim();
                            switch (cNode.getNodeName()) {
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
                    }
                    employeeList.add(currentEmployee);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
