package Student_management_app;

public class InvalidStudentDataException extends IllegalArgumentException {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}
