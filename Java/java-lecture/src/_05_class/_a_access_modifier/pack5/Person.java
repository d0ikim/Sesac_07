package _05_class._a_access_modifier.pack5;

public class Person {
    private int age;
    private String name;

    // 생성자
    public Person(String name){
        this.name = name;
    }

    // getter 와 setter
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        if(age<0){
            this.age = 0;
        } else {
            this.age = age;
        }
    }
    public void setName(String name){
        this.name = name;
    }


}
