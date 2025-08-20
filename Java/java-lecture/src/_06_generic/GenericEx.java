package _06_generic;

import java.util.ArrayList;

class CustomList{
    // 필드: list
    ArrayList<String> list = new ArrayList<>();

    // 메소드: 요소 추가, 요소 삭제, 요소 접근
    public void addElement(String element){
        list.add(element);
    }
    public void removeElement(String element){
        list.remove(element);
    }
    public String get(int i){
        return list.get(i);
    }

    @Override
    public String toString(){
        return "CustomList: "+list;
    }
}

class CustomListGeneric<T>{
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element){
        list.add(element);
    }
    public void removeElement(T element){
        list.remove(element);
    }
    public T get(int i){
        return list.get(i);
    }

    @Override
    public String toString(){
        return "CustomListGeneric: "+list;
    }
}

public class GenericEx {
    public static void main(String[] args) {
        CustomList li = new CustomList();
        li.addElement("first");
        li.addElement("second");
        li.addElement("third");
        System.out.println(li.toString());  // CustomList: [first, second, third]

        li.removeElement("second");
        System.out.println(li.toString());  // CustomList: [first, third]

        System.out.println(li.get(0));  // first

        System.out.println("=== Generic 이용 클래스를 통해 인스턴스 생성 ===");
        // 클래스이름<사용할타입> 변수명 = new 생성자이름<>();
        //              ㄴ>사용할타입은 반드시 reference type
        CustomListGeneric<Integer> gLi = new CustomListGeneric<>();
        gLi.addElement(10);
        gLi.addElement(20);
        gLi.addElement(30);
        System.out.println(gLi.toString()); // CustomListGeneric: [10, 20, 30]
        System.out.println(gLi.get(2)); // 30

        CustomListGeneric<Character> gLi2 = new CustomListGeneric<>();
        gLi2.addElement('A');
        gLi2.addElement('가');
        gLi2.addElement('@');
        gLi2.addElement('家');
        System.out.println(gLi2.toString());    // CustomListGeneric: [A, 가, @, 家]

    }
}
