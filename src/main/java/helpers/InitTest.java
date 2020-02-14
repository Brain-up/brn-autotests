package helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Cookies;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.jayway.restassured.RestAssured.given;
import static enums.UriEnum.GROUP_PATH;

public class InitTest {

    public static String baseUri;
    static final String AUTH_HEADER = "authorization";
    public static final String AUTH_HEADER_VALUE = "Basic YWRtaW46YWRtaW4=";
    public static Cookies cookie;


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
        }

        RestAssured.baseURI = InitTest.baseUri;

        cookie = given()
                .when()
                .header(AUTH_HEADER, AUTH_HEADER_VALUE)
                .get(baseUri + GROUP_PATH.value)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies();

        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
    }
}


