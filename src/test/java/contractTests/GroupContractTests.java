package contractTests;

import com.jayway.restassured.specification.RequestSpecification;
import helpers.InitRestAssured;
import helpers.InitTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;
import static enums.Uri.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GroupContractTests extends InitTest {

    private RequestSpecification rspec;
    private final String GROUP = "schemas/group.json";
    private final String GROUPS = "schemas/groups.json";

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspec = init.setReqSpec(GROUP_PATH);
    }

    @Test(description = "/groups")
    public void checkGroupContract() {
        given().spec(rspec).when().get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(GROUP)).statusCode(200).log().all();

    }

    @Test(description = "/groups/{groupId}")
    public void checkGroupContract_2() {
        given().spec(rspec).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath(GROUPS)).statusCode(200).log().all();
    }
}