public class Student {
    // Step 1: Fields
    private String name;
    private int rollNumber;
    private double grade;

    // Step 2: Constructor
    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Step 3: Getters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    // Step 4: Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Step 5: A simple display method
    public void displayInfo() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber + ", Grade: " + grade);
    }
}
