package sitepackageNewsletter;

import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class NewsletterSitepackageConnection {

    public static void main(String[] args) {
        try {
            String url = "http://formular.sitepackage.de/senden.php?email=kni%40ethinking.de&vorname=kevin&nachname=nitschmann&anrede=Herr&domain=dev.antenne.com";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            conn.connect();
            String result = IOUtils.toString(conn.getInputStream(), "UTF-8");
            if (result.startsWith("{")) {
                if (result.contains("code:0")){
                    System.out.println("YAY");
                }
            }else{
                System.out.println("god damn html");
            }
        } catch (Exception e) {
            //TODO
        }
    }
}
