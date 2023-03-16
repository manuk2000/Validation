import java.net.URL;

public class URLvalid {
    boolean URLValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
