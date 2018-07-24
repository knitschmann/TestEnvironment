package BbwJSoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JSoupParser {
    public static void main(String[] args) {
        File input = new File("/Users/kni/Documents/dev/TestEnvironment/src/main/resources/trudeau-article.html");
        List<Element> figureElements = getGalleryFigureElements(input);
        for (Element figure : figureElements){
            String id = figure.attr("id");
            System.out.println(id);
        }
    }

    public static List<Element> getGalleryFigureElements(File input) {
        Document doc = null;
        ArrayList<Element> galleryFigureList = new ArrayList();
        try {
            doc = Jsoup.parse(input, "UTF-8");
            Elements rawFigureElements = doc.select(".p402_hide:first-child figure");
            //eliminate duplicates
            ArrayList foundFigureIds = new ArrayList<>();
            for (Element figure : rawFigureElements){
                String id = figure.attr("id");
                if(!foundFigureIds.contains(id)){
                    foundFigureIds.add(id);
                    galleryFigureList.add(figure);
                }
            }
            //todo (impossible?!) start the lightbox with the image that has been clicked in the article
        } catch (Exception e) {
            System.out.println("jsoup parsing error: " + e);
        }
        return galleryFigureList;
    }
}
