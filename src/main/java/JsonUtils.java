import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    public static String toJson (Object object) {
        String json;
        Gson gson = new GsonBuilder().create();
        return  json = gson.toJson(object);
    }
}
