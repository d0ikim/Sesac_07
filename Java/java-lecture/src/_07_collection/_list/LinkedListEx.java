package _07_collection._list;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        System.out.println("초기 linked list: "+list);    // [apple, banana, cherry]

        // addFirst(), addLast() : LinkedList 에 특화된 메소드(ArrayList 에 없음)
        list.addFirst("grape");
        list.addLast("orange");
        System.out.println("요소 추가 후: "+list);   // [grape, apple, banana, cherry, orange]

        list.add(2,"kiwi");
        System.out.println("중간 요소 추가 후: "+list);    // [grape, apple, kiwi, banana, cherry, orange]

        list.remove("banana");
        System.out.println("banana 삭제 후: "+list);   // [grape, apple, kiwi, cherry, orange]
        String first = list.removeFirst();
        String last = list.removeLast();
        System.out.println("삭제된 요소: "+first);   // grape
        System.out.println("삭제된 요소: "+last);    // orange
        System.out.println("삭제 후 list: "+list); // [apple, kiwi, cherry]

        /// /// 요소 검색 //////
        boolean containsCherry = list.contains("cherry");   // true
        int indexOfCherry = list.indexOf("cherry"); // 2
        System.out.println("cherry 포함 여부: "+containsCherry);
        System.out.println("cherry index 번호: "+indexOfCherry);

        ///  Linked List 순회 ///
        for(String f: list){
            System.out.println("fruit: "+f);
        }
        System.out.println("Linked list 의 크기: "+list.size());   // 3
        list.clear();
        System.out.println("Linked list 의 크기(clear 후): "+list.size());   // 0
    }
}
