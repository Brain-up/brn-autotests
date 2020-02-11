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
    NOISE_6DB("audio/noise_6db/"),
    NOISE_9DB("audio/noise_9db/"),
    PIC ("pictures/"),

    WITH_WORD ("pictures/withWord/"),
    SERIES_2 ("audio/series2/")

    ;

    public String value;

    UriEnum(String value) {
        this.value = value;
    }
}
