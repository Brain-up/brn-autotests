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

public class LoadTasksContractTests extends InitTest {

    private RequestSpecification rspec;

    private final String LOAD_TASK_SCHEMA = SCHEMA.value + "loadTaskFile.json";

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        rspec = init.setBaseReqSpecMultipart(LOAD_TASK_FILE_PATH, "loadTask.csv");
    }

    @Test
    public void checkLoadingFile() {
       given().spec(rspec).when().post().then()
               .assertThat().body(matchesJsonSchemaInClasspath(LOAD_TASK_SCHEMA)).statusCode(201).log().all();
    }
}
