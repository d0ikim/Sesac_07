package _06_generic;

import _05_class._a_access_modifier.pack3.A;

class Person{}

class Student extends Person{}

class Teacher extends Person{}

class WebStudent extends Student{}

class MobileStudent extends Student{}
/*
* Person
* ㄴ Student
*       ㄴ WebStudent
*       ㄴ MobileStudent
* ㄴ Teacher
 */

class Applicant<T>{
    public T kind;  // 지원자의 종류

    public Applicant(T kind){
        this.kind = kind;
    }
}

class Course{
    public static void registerCourseA(Applicant<?> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course A를 등록했습니다.");
    }
    // 타입 제한(자식 타입만 허용)
    public static void registerCourseB(Applicant<? extends Student> applicant){
        // applicant: Student 를 상속받는 타입(클래스)만 올 수 있음
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course B를 등록했습니다.");
    }
    // super로 타입 제한(부모 타입만 허용)
    public static void registerCourseC(Applicant<? super Teacher> applicant){
        // applicant : Teacher 클래스의 부모가 되는 타입(클래스)만 올 수 있음(Teacher 포함)
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course C를 등록했습니다.");
    }
}
// getClass(), getSimpleName() 메소드
// - Object 클래스에서 제공하는 메소드
// - getClass(): 객체의 클래스 정보를 반환 (java.lang.String)
// - getSimpleName(): 패키지 정보를 제외한 클래스 이름만 반환 (String)

public class GenericEx3 {
    public static void main(String[] args) {
        Course.registerCourseA(new Applicant<String>("string applicant!")); // String이(가) Course A를 등록했습니다.

        // Course B >> ? extends Student : (Applicant)Student 의 자식들만 가능
//        Course.registerCourseB(new Applicant<Person>(new Person()));  // error! Person != Student의 자식
//        Course.registerCourseB(new Applicant<Teacher>(new Teacher()));    //  error! Teacher != Student의 자식
        Course.registerCourseB(new Applicant<Student>(new Student()));  // Student이(가) Course B를 등록했습니다.
        Course.registerCourseB(new Applicant<MobileStudent>(new MobileStudent()));  // MobileStudent이(가) Course B를 등록했습니다.
        Course.registerCourseB(new Applicant<WebStudent>(new WebStudent()));    // WebStudent이(가) Course B를 등록했습니다.

        // Course C >> ? super Teacher : (Applicant)Teacher 의 부모만 가능
        Course.registerCourseC(new Applicant<Person>(new Person()));    // Person == Teacher의 부모
        Course.registerCourseC(new Applicant<Teacher>(new Teacher()));
//        Course.registerCourseC(new Applicant<Student>(new Student()));  // error! Student != Teacher의 부모
    }
}
