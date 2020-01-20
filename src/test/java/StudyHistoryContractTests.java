import com.jayway.restassured.specification.RequestSpecification;
import entities.StudyHistory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StudyHistoryContractTests extends InitTest{

    RequestSpecification rspecStudyHist;
    String json;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspecStudyHist = init.setRequestSpecStudyHist();

        StudyHistory req = StudyHistory.newBuilder()
                .setTaskCount(1)
                .setEndTime("2019-12-18T13:53:06.366Z")
                .setExerciseId(2)
                .setRepetitionIndex(1)
                .setStartTime("2019-12-18T13:53:06.366Z")
                .setUserId(2)
                .build();

        json = JsonUtils.toJson(req);
    }

    @Test(description = "/study-history")
    public void checkStudyHistContract() {
        given().spec(rspecStudyHist).when().body(json).post("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/status_history.json")).statusCode(200).log().all();
    }
}
