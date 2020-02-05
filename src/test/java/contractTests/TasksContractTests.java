package contractTests;

import com.jayway.restassured.specification.RequestSpecification;
import helpers.InitRestAssured;
import helpers.InitTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static enums.FilePathEnum.SCHEMA;
import static enums.UriEnum.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TasksContractTests extends InitTest {

    private RequestSpecification rspec;

    private final String TASKS_BY_EXERCISE_SCHEMA = SCHEMA.value + "tasks_by_exercise.json";
    private final String TASK_SCHEMA = SCHEMA.value + "task.json";

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        rspec = init.setBaseReqSpec(TASKS_PATH);
    }

    @Test(description = "/tasks?exerciseId={id}")
    public void checkTasksContract() {
        given().spec(rspec).when().queryParam(EXERCISE_ID.value, "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath(TASKS_BY_EXERCISE_SCHEMA)).statusCode(200).log().all();
    }

    @Test(description = "/tasks/{exerciseId}")
    public void checkTasksContract_2() {
        given().spec(rspec).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath(TASK_SCHEMA)).statusCode(200).log().all();
    }
}
