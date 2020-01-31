package helpers;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    public static String toJson (Object object) {
       return new GsonBuilder().create().toJson(object);
    }
}
