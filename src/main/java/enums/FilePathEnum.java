package enums;

public enum FilePathEnum {

    SCHEMA ("schemas/"),
    LOAD_FILES("loadFiles/"),
    HAR_FILE("results/")
    ;

    public String value;

    FilePathEnum(String value) {
        this.value = value;
    }
}
