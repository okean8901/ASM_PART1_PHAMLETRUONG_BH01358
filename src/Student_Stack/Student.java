package Student_Stack;

class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.marks = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Mark: " + marks;
    }
}