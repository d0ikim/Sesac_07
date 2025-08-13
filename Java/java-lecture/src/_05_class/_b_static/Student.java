package _05_class._b_static;

public class Student {
    String name;
    int student_ID;
    int grade;
    static int totalStudents = 0;

    public Student(String name, int student_ID, int grade){
        this.name = name;
        this.student_ID = student_ID;
        this.grade = grade;
        totalStudents++;
    }

    public String getName(){
        return this.name;
    }
    public int getStudent_ID(){
        return this.student_ID;
    }
    public int getGrade(){
        return this.grade;
    }

    public void setName(String n){
        this.name = n;
    }
    public void setStudent_ID(int sId){
        this.student_ID = sId;
    }
    public void setGrade(int g){
        this.grade = g;
    }

    public void displayInfo(){
        System.out.println("=== 학생 정보 ===");
        System.out.println("이름: "+this.getName());
        System.out.println("학번: "+this.getStudent_ID());
        System.out.println("학년: "+this.getGrade()+"\n");
    }
}
