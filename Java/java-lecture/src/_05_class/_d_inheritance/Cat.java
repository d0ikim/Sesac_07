package _05_class._d_inheritance;

public class Cat extends Animal{
    public Cat(String species, String name, int age){
        super(species, name, age);
    }

    void hunt(String prey){
        System.out.println(prey+"를(을) 사냥합니다.");
    }

    @Override
    void makeSound(){
        System.out.println("야옹");
    }

}
