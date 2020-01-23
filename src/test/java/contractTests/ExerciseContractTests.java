package contractTests;

import com.jayway.restassured.specification.RequestSpecification;
import helpers.InitRestAssured;
import helpers.InitTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static enums.Uri.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ExerciseContractTests extends InitTest {

    private RequestSpecification rspec;
    private final String EXERC_SINGLE_WORD_SERIES = "schemas/exercises_for_single_words.json";
    private final String EXERC_SEQ_WORD_SERIES = "schemas/exercises_for_sequence_words.json";
    private final String EXERC = "schemas/exercise.json";

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspec = init.setBaseReqSpec(EXERCISE_PATH);
    }

    @Test(description = "single words series /exercises?seriesId={id}")
    public void checkExerciseContract() {
        given().spec(rspec).when().queryParam(SERIES_ID.value, "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC_SINGLE_WORD_SERIES)).statusCode(200).log().all();

    }

    @Test(description = "single words series /exercises?seriesId={id}&userId={id}")
    public void checkExerciseContract_2() {
        given().spec(rspec).when().queryParam(SERIES_ID.value, "1").queryParam(USER_ID.value, "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC_SINGLE_WORD_SERIES)).statusCode(200).log().all();

    }

    @Test(description = "sequence words series /exercises?seriesId={id}")
    public void checkExerciseContract_3() {
        given().spec(rspec).when().queryParam(SERIES_ID.value, "2").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC_SEQ_WORD_SERIES)).statusCode(200).log().all();

    }

    @Test(description = "sequence words series /exercises?seriesId={id}&userId={id}")
    public void checkExerciseContract_4() {
        given().spec(rspec).when().queryParam(SERIES_ID.value, "2").queryParam(USER_ID.value, "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC_SEQ_WORD_SERIES)).statusCode(200).log().all();

    }

    @Test(description = "single words series /exercises/{exerciseId}")
    public void checkExerciseContract_5() {
        given().spec(rspec).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC)).statusCode(200).log().all();

    }

    @Test(description = "sequence words series /exercises/{exerciseId}")
    public void checkExerciseContract_6() {
        given().spec(rspec).when().get("/2").then()
                .assertThat().body(matchesJsonSchemaInClasspath(EXERC)).statusCode(200).log().all();
    }
}
