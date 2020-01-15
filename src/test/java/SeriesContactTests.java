import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



@Listeners(LogListener.class)
public class SeriesContactTests extends InitTest {

    RequestSpecification rspecSeries;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspecSeries = init.setRequestSpecSeries();
    }

    @Test(description = "/series?groupId={id}")
    public void checkSeriesContract() {
        given().spec(rspecSeries).when().queryParam("groupId", "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/series_by_group.json"));
    }

    @Test(description = "/series/{seriesId}")
    public void checkSeriesContract_2() {
        given().spec(rspecSeries).when().get("/2").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/series.json"));
    }
}
