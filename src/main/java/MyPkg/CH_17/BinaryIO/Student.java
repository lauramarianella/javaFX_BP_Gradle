package MyPkg.CH_17.BinaryIO;
import java.io.Serializable;

class Student implements Serializable {
    
    private String name;
    private String course;
    private double grade;
    
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
        this.grade = 100;
    }
 
    @Override
    public String toString() {
        return "Student: " + name + ", class: " + course + ", grade: " + grade;
    }
}