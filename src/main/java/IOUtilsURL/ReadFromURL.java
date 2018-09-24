package IOUtilsURL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadFromURL {

    public static void main(String[] args) throws IOException {
        String link = "https://itunes.apple.com/search?term=sido+feat+andreas+bourani+astronaut&media=music&country=de";
        URL url = new URL(link);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        InputStream ins = null;
        if (404 != request.getResponseCode()) {
            InputStream inputStream = request.getInputStream();

        } else {
            System.out.println("404 thrown");
        }
        JSONObject content = new JSONObject(IOUtils.toString(ins, "UTF-8"));
        System.out.println("done");
    }
}
