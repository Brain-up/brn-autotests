package helpers;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class InitTest {

    public static String baseUri;

    @Parameters({"env"})
    @BeforeSuite(alwaysRun = true)
    public void beforeTest(@Optional("prod") final String env) {
        switch (env) {
            case "epam":
                baseUri = PropertyUtils.getEnv("epam");
                break;
            case "prod":
                baseUri = PropertyUtils.getEnv("prod");
                break;
            default:
        }
    }
}


