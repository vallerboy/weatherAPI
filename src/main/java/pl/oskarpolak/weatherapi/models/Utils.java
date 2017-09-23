package pl.oskarpolak.weatherapi.models;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {
    public static String makeHttpRequest(String url){
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            StringBuilder builder = new StringBuilder();
            int read;
            while ((read = urlConnection.getInputStream().read()) != -1){
                builder.append((char) read);
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
