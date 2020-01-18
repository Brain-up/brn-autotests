import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TasksContractTests extends InitTest {

    RequestSpecification rspecTasks;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspecTasks = init.setRequestSpecTasks();
    }

    @Test(description = "/tasks?exerciseId={id}")
    public void checkTasksContract() {
        given().spec(rspecTasks).when().queryParam("exerciseId", "1").get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/tasks_by_exercise.json")).statusCode(200);
    }

    @Test(description = "/tasks/{exerciseId}")
    public void checkTasksContract_2() {
        given().spec(rspecTasks).when().get("/1").then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/task.json")).statusCode(200);
    }


}
