package _03_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Java Collections
* ㄴ List
*   - ArrayList
*   - LinkedList
*   - Vector
* ㄴ Set
*   - HashSet
*   - TreeSet
* ㄴ Map
*   - HashMap
*   - HashTable
*   - TreeMap
 */
public class ArrayListEx {
    public static void main(String[] args) {
        // List<reference타입> list = new ArrayList<>();
        List<Integer> numbers = new java.util.ArrayList<>();
        System.out.println(numbers);

        // 1. 빈배열여부 isEmpty()
        System.out.println("isEntpy? "+numbers.isEmpty());

        // 2. 요소 추가 add()
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        System.out.println(numbers);
        System.out.println("contains: "+numbers.contains(10));
        System.out.println("contains: "+numbers.contains(11));

        // 3. 요소 접근 get()
        // System.out.println(numbers[0]);  // error, 이렇게 접근x
        System.out.println("0번째 인덱스 : "+numbers.get(0));
        System.out.println("0번째 인덱스 : "+numbers.get(1));

        // 4. 요소 수정 set()
        // numbers.set(인덱스번호, 바꿀값)
        numbers.set(1,77);
        System.out.println(numbers);    // [10, 77, 30, 40, 50]

        // 요소 삽입 add()
//        numbers.add(인덱스번호, 요소)
        numbers.add(1,7);   // [10, 7, 77, 30, 40, 50]
        System.out.println(numbers);

        // 6. ArrayList 끼리 연결 : addAll()
        System.out.println(Arrays.asList(99,35,55));    // asList() : 배열 -> list 로 변경하는 메소드

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(100,99,98));
        System.out.println("numbers2 :: "+numbers2);    // [100, 99, 98]
        numbers.addAll(numbers2);   // numbers arrayList가 변경
        System.out.println("연결됐는지 확인 : "+numbers);
        // [10, 7, 77, 30, 40, 50, 100, 99, 98]

        // 7. 요소의 위치를 찾기 indexOf(찾을 요소의 값)
        System.out.println(numbers.indexOf(50));    // 50은 5번 인덱스
        System.out.println(numbers2.indexOf(1));    // -1 (요소가 없을 때)

        // 8. 요소 삭제 remove(인덱스)
        numbers.remove(2);  // 77 삭제
        System.out.println(numbers);
        // [10, 7, 30, 40, 50, 100, 99, 98]

        // 9. 리스트 크기 확인 size()
//        System.out.println(numbers.length);
        System.out.println("리스트의 크기: "+numbers.size());

        // 10. 모든 요소 출력
        for(int n:numbers) {
            System.out.print(n+" ");
        }

        System.out.println();

        // 11. 모든 요소 삭제 clear()
        numbers.clear();
        System.out.println(numbers);    // []

        /// /////////////////////////////////////////////
        // Student 타입의 ArrayList 생성
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", 10));
        students.add(new Student("B", 11));
        students.add(new Student("C", 12));
        students.add(new Student("D", 13));

        System.out.println("학생수: "+students.size());
        Student std1 = students.get(0);
        System.out.println(std1.getName()+ "학생의 나이는 "+std1.getAge());

        System.out.println("==학생 명단==");
        for(Student std:students){
            System.out.println(std.getName() + "("+std.getAge()+")");
        }

        students.remove(2);
        System.out.println("삭제 후 >> "+students);

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "Student{"+
                "name="+ name + '\''+
                ", age="+ age +
                "}";
    }
}
