package _05_class;  // 패키지(디렉터리)
// 패키지?
// 여러 클래스를 가지고 있는 directory(폴더)
// 클래스를 유일하게 만들어주는 식별자 역할
// - 같은 패키지 안에 같은 클래스가 존재할 수 없도록 구분해줌
// - 서로 다른 패키지에서는 이름이 같은 클래스가 존재할 수 있음
// 패키지는 특정한 기능을 가지고 있는 클래스를 구분해주는 용도(서로 관련있는 클래스)

public class Student {
    // 1. 클래스의 필드
    public String name;
    public int grade;

    // 2. 클래스의 생성자
    public Student(String name, int grade){
        // 필드 초기화
        this.name = name;   // this 키워드는 Student 자기 자신을 의미
        this.grade = grade;
    }
    // 3. 클래스의 메소드
    // 1) 반환값 x, 인자x
    public void goToSchool() {
        System.out.println("학교에 갑니다.");
    }

    // 2) 반환값 x, 인자o
    public void study(String subject) {
        System.out.println(subject +" 과목 공부중..");
    }

    // 3) 반환값 o, 인자x
    public int getGrade() {
        return this.grade;
    }

    // 4) 반환값 o, 인자 o
    public String getTestResult(int score) {
        return this.name + " 학생의 점수: " + score;
    }

    @Override
    public String toString() {
        return "Student { name=" + this.name + ", grade=" + this.grade + " }";
    }
}
