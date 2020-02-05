package helpers;
import com.google.gson.GsonBuilder;
import net.minidev.json.JSONArray;

import static com.jayway.jsonpath.JsonPath.parse;
import static helpers.BrowserProxy.readFile;
import static helpers.InitTest.*;

public class JsonUtils {
    public static String toJson (Object object) {
       return new GsonBuilder().create().toJson(object);
    }

    public static JSONArray getParsedHar (String har, String path, String parameter) {
       return parse(readFile(har)).read(String.format("$..[?(@.url=='%s')]", baseUri + path + parameter));
    }
}
