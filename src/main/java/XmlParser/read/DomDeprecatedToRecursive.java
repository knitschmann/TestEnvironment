package XmlParser.read;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.xerces.dom.DeferredElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomDeprecatedToRecursive {
    public static void main(String[] args) {
        Node root = prepare();
        String result1 = getNodeInfo(root, "Datum");
        System.out.println(result1);
        String result2 = getNodeInfoDeprecated(root, "Datum");
        System.out.println(result2);
    }

    public static Node prepare() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("mini_bvg.xml"));
            Node entry = document.getElementsByTagName("ANDMeldung").item(0);
            return entry;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNodeInfoDeprecated(Node node, String elementName) {
        Node infoNode = ((DeferredElementImpl) node).getElementsByTagName(elementName).item(0);
        if (infoNode != null) {
            String textContent = infoNode.getTextContent();
            return StringEscapeUtils.unescapeXml(textContent)
                    .replaceAll("\n", "")
                    .replace("<br/>", "")
                    .replace("<br />", "");
        }
        return null;
    }

    public static String getNodeInfo(Node node, String elementName) {
        String result = null;
        if (node.getNodeName().equals(elementName)) {
            result = node.getTextContent();
            result = StringEscapeUtils.unescapeXml(result)
                    .replaceAll("\n", "")
                    .replace("<br/>", "")
                    .replace("<br />", "");
            return result;

        } else {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                String content = getNodeInfo(childNode, elementName);
                if (content != null) {
                    result = content;
                    return result;
                }
            }
        }
        return result;
    }
}
