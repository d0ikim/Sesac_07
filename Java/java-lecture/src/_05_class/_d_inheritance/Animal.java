package _05_class._d_inheritance;

public class Animal {
    private String species;
    private String name;
    private int age;

    public Animal(String species, String name, int age){
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void setSpecies(String s){
        this.species = s;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setAge(int a){
        this.age = a;
    }
    public String getSpecies(){
        return this.species;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    void makeSound(){
        System.out.println("동물은 소리를 낸다");  // 야옹야옹, 멍멍, ..
    }
}
