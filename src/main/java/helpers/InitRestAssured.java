package helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.MultiPartSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.specification.RequestSpecification;
import enums.UriEnum;
import java.io.File;
import static com.jayway.restassured.RestAssured.given;
import static helpers.InitTest.*;



public class InitRestAssured {

    public RequestSpecification setBaseReqSpec(UriEnum basePath) {
         return  given()
                .basePath(basePath.value)
                .contentType(ContentType.JSON)
                .cookies(cookie);
    }

    public RequestSpecification setBaseReqSpecMultipart(UriEnum basePath, String fileName) {

        String filePath = String.format("src/test/resources/loadFiles/%s", fileName);

        return   given()
                .basePath(basePath.value)
                .header(new Header("Content-Type", "multipart/form-data"))
                .multiPart(new MultiPartSpecBuilder(new File(filePath)).controlName("taskFile").fileName(fileName).mimeType("application/vnd.ms-excel").build())
                .cookies(cookie);
    }
}
