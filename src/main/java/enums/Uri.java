package enums;

import helpers.InitTest;

public enum Uri {

    BASE_URI (InitTest.baseUri),
    GROUP_PATH ("api/groups"),
    SERIES_PATH("api/series"),
    EXERCISE_PATH("api/exercises"),
    TASKS_PATH("api/tasks"),
    STUDY_HIST_PATH("api/study-history"),
    LOAD_FILE_PATH("/api/admin/loadFile"),
    LOAD_TASK_FILE_PATH("/api/admin/loadTasksFile"),

    SERIES_ID("seriesId"),
    USER_ID("userId"),
    GROUP_ID("groupId"),
    EXERCISE_ID("exerciseId")
    ;

    public String value;

    Uri(String value) {
        this.value = value;
    }
}
