import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final Properties ENV;

    static {
            ENV = readProperties("environments.properties");
    }

    private static Properties readProperties(String filename) {
        Properties properties;
        properties = new Properties();
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {
            String message = String.format("filename should point to reachable %s file", filename);
            if (inputStream == null) {
                throw new IOException(message);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getEnv(String env) {
        return ENV.getProperty(env);
    }
}
