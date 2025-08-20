package _07_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("이름과 나이를 입력하세요. '종료'를 입력하면 종료됩니다.");
        Map<String, Integer> map = new HashMap<>();
//        Set<Map.Entry<String, Integer>> entry = map.entrySet();

        while(true){
            System.out.print("이름 입력: ");
            String name = scan.next();

            if(name.equals("종료")){
                break;
            }

            System.out.print("나이 입력: ");
            Integer age = scan.nextInt();

            map.put(name, age);
        }

        System.out.println("\n== 입력 받은 이름과 나이 목록 ==");
        Set<String> keySet = map.keySet();
        for(String k: keySet){
            System.out.printf("이름: %s, 나이: %d", k, map.get(k)).println();
        }
    }
}
