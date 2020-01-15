import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;


public class InitRestAssured {

    static RequestSpecification rspec;
    static RequestSpecBuilder builder;


    public void setBaseUri() {
        RestAssured.baseURI = InitTest.baseUri;
    }

    public RequestSpecification setRequestSpecGroup() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/groups");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecSeries() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/series");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecExercises() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/exercises");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecTasks() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/tasks");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecStudyHist() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/study-history");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecLoadFile() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/admin/loadFile");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }

    public RequestSpecification setRequestSpecLoadTasksFile() {
        builder = new RequestSpecBuilder();
        builder.setBasePath("api/admin/loadTasksFile");
        builder.setContentType(ContentType.JSON);
        rspec = builder.build();

        return  rspec;
    }
}
