package _05_class._e_abstract;

public abstract class Student {
    String name;
    String school;
    int age;
    int studentId;

    public Student(String name, String school, int age, int studentId){
        this.name = name;
        this.school = school;
        this.age = age;
        this.studentId = studentId;
    }

    public abstract void todo();
}
