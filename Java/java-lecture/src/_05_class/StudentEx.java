package _05_class;

public class StudentEx {
    public static void main(String[] args) {
        Student s1 = new Student("allie",1);
        System.out.println(s1);

        // 인스턴스 내부 메소드 사용
        s1.goToSchool();
        s1.study("Java 프로그래밍");

        System.out.println("grade: "+ s1.getGrade());
        System.out.println(s1.getTestResult(100));

        System.out.println("s1의 필드: "+s1.grade);
        System.out.println("s1의 필드: "+s1.name);

        Student s2 = new Student("rumon",2);
        System.out.println(s2);
    }
}
