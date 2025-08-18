package _05_class._d_inheritance;

public class Practice {
    public static void main(String[] args) {
        Cat cat = new Cat("고양이", "나비", 1);
        Dog dog = new Dog("강아지", "짱아", 14);

        cat.makeSound();
        dog.makeSound();

        cat.hunt("쥐");
        dog.bring("공");
    }
}

