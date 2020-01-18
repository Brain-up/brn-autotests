import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ExerciseContractTests extends InitTest {
    RequestSpecification rspecExercise;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspecExercise = init.setRequestSpecExercises();
    }

    @Test(description = "/exercises")
    public void checkExerciseContract() {
        given().spec(rspecExercise).when().queryParam("seriesId", "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/exercises_for_single_words.json"));

    }

    @Test(description = "/exercises/{exerciseId}")
    public void checkExerciseContract_2() {
        given().spec(rspecExercise).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/exercise_for_single_words.json"));

    }
}