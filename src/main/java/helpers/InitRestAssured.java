package helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.specification.RequestSpecification;
import enums.Uri;
import java.io.File;
import static com.jayway.restassured.RestAssured.given;
import static enums.Uri.GROUP_PATH;
import static helpers.InitTest.baseUri;



public class InitRestAssured {

    static final String AUTH_HEADER = "authorization";
    static final String AUTH_HEADER_VALUE = "Basic YWRtaW46YWRtaW4=";
    static Cookies cookie;

    {
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
    }

    public RequestSpecification setBaseReqSpec(Uri basePath) {
         return  given()
                .basePath(basePath.value)
                .contentType(ContentType.JSON)
                .cookies(cookie);
    }

    public RequestSpecification setBaseReqSpecMultipart(Uri basePath, String fileName) {

        String filePath = String.format("src/test/resources/loadFiles/%s", fileName);

        return   given()
                .basePath(basePath.value)
                .header(new Header("Content-Type", "multipart/form-data"))
                .multiPart(new MultiPartSpecBuilder(new File(filePath)).controlName("taskFile").fileName(fileName).mimeType("application/vnd.ms-excel").build())
                .cookies(cookie);
    }
}
