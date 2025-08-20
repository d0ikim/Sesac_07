package _07_collection._list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompareList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){
            list1.add(0,String.valueOf(i)); // i 를 String 으로 변환
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 소요 시간: "+(endTime - startTime));

        startTime = System.nanoTime();
        for(int i=0;i<10000;i++){
            list2.add(0,String.valueOf(i)); // i 를 String 으로 변환
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 소요 시간: "+(endTime - startTime)); // 항상 ArrayList보다 훨씬 빠르다
        /*
        * ArrayList 소요 시간: 7417300
        * LinkedList 소요 시간: 2250401
         */
    }
}
