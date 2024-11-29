package Student_management_app_scenario;

public class InvalidStudentDataException extends IllegalArgumentException {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}
