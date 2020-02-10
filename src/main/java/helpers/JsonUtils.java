package helpers;
import com.google.gson.GsonBuilder;
import net.minidev.json.JSONArray;
import static com.jayway.jsonpath.JsonPath.parse;
import static helpers.BrowserProxy.readFile;

public class JsonUtils {
    public static String toJson (Object object) {
       return new GsonBuilder().create().toJson(object);
    }

    public static JSONArray getUrlHar (String har) {
        return parse(readFile(har)).read("$..url");
    }
}
