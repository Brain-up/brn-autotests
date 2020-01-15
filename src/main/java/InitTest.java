import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class InitTest {

    static String baseUri;

    @Parameters({"env"})
    @BeforeSuite(alwaysRun = true)
    public void beforeTest(@Optional("epam") final String env) {
        switch (env) {
            case "epam":
                baseUri = PropertiesUtils.getEnv("epam");
                break;
            case "prod":
                baseUri = PropertiesUtils.getEnv("prod");
                break;
            default:
        }
    }
}


