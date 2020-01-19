package entities;

public class StudyHistory {
    private int tasksCount;
    private String endTime;
    private int exerciseId;
    private int repetitionIndex;
    private String startTime;
    private int userId;

    public static Builder newBuilder() {
        return new StudyHistory().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setTaskCount(int tasksCount) {
            StudyHistory.this.tasksCount = tasksCount;
            return this;
        }

        public Builder setEndTime(String endTime) {
            StudyHistory.this.endTime = endTime;
            return this;
        }

        public Builder setExerciseId(int exerciseId) {
            StudyHistory.this.exerciseId = exerciseId;
            return this;
        }

        public Builder setRepetitionIndex(int repetitionIndex) {
            StudyHistory.this.repetitionIndex = repetitionIndex;
            return this;
        }

        public Builder setStartTime(String startTime) {
            StudyHistory.this.startTime = startTime;
            return this;
        }

        public Builder setUserId(int userId) {
            StudyHistory.this.userId = userId;
            return this;
        }

        public StudyHistory build() {
            return StudyHistory.this;
        }
    }
}
