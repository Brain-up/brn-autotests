package entities;

public class StudyHistoryPOJO {
    private int tasksCount;
    private String endTime;
    private int exerciseId;
    private int repetitionIndex;
    private String startTime;
    private int userId;

    public StudyHistoryPOJO (int tasksCount, String endTime, int exerciseId, int repetitionIndex, String startTime, int userId) {
        this.tasksCount = tasksCount;
        this.endTime = endTime;
        this.exerciseId = exerciseId;
        this.repetitionIndex = repetitionIndex;
        this.startTime = startTime;
        this.userId = userId;
    }
}
