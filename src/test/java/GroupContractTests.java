import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GroupContractTests extends InitTest {

    RequestSpecification rspecGroup;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspecGroup = init.setRequestSpecGroup();
    }

    @Test(description = "/groups")
    public void checkGroupContract() {
        given().spec(rspecGroup).when().get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/group.json")).statusCode(200);

    }

    @Test(description = "/groups/{groupId}")
    public void checkGroupContract_2() {
        given().spec(rspecGroup).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/groups.json")).statusCode(200);
    }
}
