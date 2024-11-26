package Student_management_app;

class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        validateId(id);
        validateName(name);
        validateScore(score);
        this.id = id;
        this.name = name;
        this.score = score;
    }

    private void validateId(int id) {
        if (id < 0) {
            throw new InvalidStudentDataException("ID must be non-negative");
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStudentDataException("Name cannot be null or empty");
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new InvalidStudentDataException("Name contains invalid characters");
        }
    }

    private void validateScore(double score) {
        if (score < 0.0 || score > 10.0) {
            throw new InvalidStudentDataException("Score must be between 0.0 and 10.0");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getRanking() {
        if (score < 5.0) {
            return "Fail";
        } else if (score < 6.5) {
            return "Medium";
        } else if (score < 7.5) {
            return "Good";
        } else if (score < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", ranking='" + getRanking() + '\'' +
                '}';
    }
}