package enums;

public enum UriEnum {

    GROUP_PATH ("api/groups"),
    SERIES_PATH("api/series"),
    EXERCISE_PATH("api/exercises"),
    TASKS_PATH("api/tasks"),
    STUDY_HIST_PATH("api/study-history"),
    LOAD_TASK_FILE_PATH("api/loadTasksFile"),

    SERIES_ID("seriesId"),
    USER_ID("userId"),
    GROUP_ID("groupId"),
    EXERCISE_ID("exerciseId"),

    NO_NOISE("audio/no_noise/"),
    PIC ("pictures/")
    ;

    public String value;

    UriEnum(String value) {
        this.value = value;
    }
}
