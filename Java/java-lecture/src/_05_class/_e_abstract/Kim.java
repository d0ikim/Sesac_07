package _05_class._e_abstract;

public class Kim extends Student{
    public Kim(String name, String school, int age, int studentId){
        super(name, school, age, studentId);
        System.out.printf("학교: %s\n나이: %d\n학번: %d\n", school, age, studentId);
    }

    @Override
    public void todo(){
        System.out.println("점심은 김가네 김밥");
    }

    public static void main(String[] args) {
        System.out.println("==== 김철수 학생의 정보 ====");
        Kim kim = new Kim("김철수", "ABC 고등학교", 17, 20220001);
        kim.todo();

        System.out.println("\n==== 백영희 학생의 정보 ====");
        Baek baek = new Baek("백영희", "XYZ 고등학교", 18, 20220002);
        baek.todo();
    }
}

class Baek extends Student{
    public Baek(String name, String school, int age, int studentId){
        super(name, school, age, studentId);
        System.out.printf("학교: %s\n나이: %d\n학번: %d\n", school, age, studentId);
    }

    @Override
    public void todo(){
        System.out.println("점심은 백종원 피자");
    }
}
