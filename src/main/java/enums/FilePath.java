package enums;

public enum FilePath {

    SCHEMA ("schemas/"),
    LOAD_FILES("loadFiles/")
    ;

    public String value;

    FilePath(String value) {
        this.value = value;
    }
}
