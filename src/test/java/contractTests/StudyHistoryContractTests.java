package contractTests;

import com.jayway.restassured.specification.RequestSpecification;
import entities.StudyHistory;
import helpers.InitRestAssured;
import helpers.InitTest;
import helpers.JsonUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static enums.FilePathEnum.SCHEMA;
import static enums.UriEnum.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StudyHistoryContractTests extends InitTest {

    private RequestSpecification rspec;

    private String json;
    private final String STATUS_HIST_SCHEMA = SCHEMA.value + "status_history.json";

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        rspec = init.setBaseReqSpec(STUDY_HIST_PATH);

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

    @Test(alwaysRun = true, description = "/study-history")
    public void checkStudyHistContract() {
        given().spec(rspec).when().body(json).post("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(STATUS_HIST_SCHEMA)).log().all();
    }
}
