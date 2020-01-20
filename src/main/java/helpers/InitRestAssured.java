package helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import enums.Uri;


public class InitRestAssured {

    static RequestSpecification rspec;
    static RequestSpecBuilder builder;


    public void setBaseUri() {
        RestAssured.baseURI = InitTest.baseUri;
    }

    public RequestSpecification setReqSpec(Uri basePath) {
        builder = new RequestSpecBuilder();
        builder.setBasePath(basePath.value);
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }
}
