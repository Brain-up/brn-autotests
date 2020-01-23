package contractTests;

import com.jayway.restassured.specification.RequestSpecification;
import helpers.InitRestAssured;
import helpers.InitTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;
import static enums.Uri.GROUP_ID;
import static enums.Uri.SERIES_PATH;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class SeriesContactTests extends InitTest {

    private RequestSpecification rspec;
    private final String SERIES_BY_GROUP = "schemas/series_by_group.json";
    private final String SERIES = "schemas/series.json";

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspec = init.setBaseReqSpec(SERIES_PATH);
    }

    @Test(description = "/series?groupId={id}")
    public void checkSeriesContract() {
        given().spec(rspec).when().queryParam(GROUP_ID.value, "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(SERIES_BY_GROUP)).statusCode(200).log().all();
    }

    @Test(description = "/series/{seriesId}")
    public void checkSeriesContract_2() {
        given().spec(rspec).when().get("/2").then()
                .assertThat().body(matchesJsonSchemaInClasspath(SERIES)).statusCode(200).log().all();
    }
}
