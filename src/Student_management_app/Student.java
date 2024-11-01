package Student_management_app;

import java.util.*;

class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {

        if (id < 0 )throw new IllegalArgumentException("id must be con-nagetive");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty");
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