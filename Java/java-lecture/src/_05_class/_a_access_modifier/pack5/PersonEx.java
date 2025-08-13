package _05_class._a_access_modifier.pack5;

public class PersonEx {
    public static void main(String[] args) {
        Person p1 = new Person("pooh");
        Person p2 = new Person("eeyore");

        System.out.println(p1.getName() + "의 나이는 "+p1.getAge()+"살 입니다.");
        p1.setAge(10);
        System.out.println(p1.getName() + "의 나이는 "+p1.getAge()+"살 입니다.");

        p2.setAge(-100);
        System.out.printf("%s의 나이: %d", p2.getName(), p2.getAge());
    }
}
