package Exp_Stack_Frames;

public class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        if (id < 0) throw new IllegalArgumentException("ID must be non-negative");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (score < 0.0 || score > 10.0) throw new IllegalArgumentException("Score must be between 0.0 and 10.0");
        this.id = id;
        this.name = name;
        this.score = score;
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

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", score=" + score + '}';
    }
}