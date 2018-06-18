package XmlParser.read;

import XmlParser.api.Audiofile;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxLevelStreamParsing {
    public static void main(String[] args) {
        List<Audiofile> files = parseStreamSTAX();
        System.out.println(files);
    }

    private static List<Audiofile> parseStreamSTAX() {
        List<Audiofile> files = new ArrayList<>();
        Audiofile audiofile = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("audio.xml"));
            int level = 0;
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("item".equals(reader.getLocalName())) {
                            audiofile = new Audiofile();
                            level++;
                        }
                        if ("enclosure".equals(reader.getLocalName())) {
                            if (level == 1) {
                                audiofile.setMp3FileUrl(reader.getAttributeValue(0));
                            }
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "title":
                                if (level == 1) {
                                    audiofile.setName(tagContent);
                                }
                                break;
                            case "author":
                                if (level == 1) {
                                    audiofile.setAuthor(tagContent);
                                }
                                break;
                            case "pubDate":
                                if (level == 1) {
                                    audiofile.setPublicationDate(tagContent);
                                }
                                break;
                            case "duration":
                                if (level == 1) {
                                    audiofile.setDuration(tagContent);
                                }
                                break;
                            case "item":
                                level--;
                                files.add(audiofile);
                                break;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return files;
    }
}
