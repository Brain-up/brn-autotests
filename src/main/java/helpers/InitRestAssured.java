package helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.specification.RequestSpecification;
import enums.Uri;

import static com.jayway.restassured.RestAssured.given;
import static enums.Uri.GROUP_PATH;
import static helpers.InitTest.getBaseUri;


public class InitRestAssured {

    static RequestSpecification rspec;

    static final String AUTH_HEADER = "authorization";
    static final String AUTH_HEADER_VALUE = "Basic YWRtaW46YWRtaW4=";

    static Cookies cookie;

    {
        cookie = given()
                .when()
                .header(AUTH_HEADER, AUTH_HEADER_VALUE)
                .get(getBaseUri() + GROUP_PATH.value)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies();
    }

    public void setBaseUri() {
        RestAssured.baseURI = InitTest.baseUri;
    }

    public RequestSpecification setBaseReqSpec(Uri basePath) {
        rspec = given()
                .basePath(basePath.value)
                .contentType(ContentType.JSON)
                .cookies(cookie);

        return  rspec;
    }
}
