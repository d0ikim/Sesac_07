package _07_collection._map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // 객체 저장
        map.put(1001,"홍길동");
        map.put(1002,"김민지");
        map.put(1003,"박정은");
        map.put(1004,"성춘향");
        map.put(1004,"성향"); // 수정이 됨
        System.out.println(map);    // {1001=홍길동, 1002=김민지, 1003=박정은, 1004=성춘향}

        // 요소의 개수 : size()
        System.out.println("map 의 데이터 개수: "+map.size());

        // key 로 접근
        int key = 1003;
        String value = map.get(key);
        System.out.printf("%d 번 학생의 이름은 %s\n", key, value);

        /// / 순회 ////
        System.out.println("=== map 순회(1) entrySet 과 for 이용 ===");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        // key=value >> 엔트리를 set에 저장한 것
        System.out.println(entrySet);   // [1001=홍길동, 1002=김민지, 1003=박정은, 1004=성향]
        for(Map.Entry<Integer, String> entry:entrySet){
            System.out.println(entry.getKey() + "번 학생: " + entry.getValue());   // 1001번 학생: 홍길동 ...
        }

        System.out.println("=== map 순회(2) entrySet() 과 Iterator 객체 이용 ===");
        Iterator<Map.Entry<Integer, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer, String> studentEntry = entryIterator.next();
            // studentEntry: 1001=홍길동
            Integer entryKey = studentEntry.getKey();
            String entryValue = studentEntry.getValue();
            System.out.printf("%d 번 학생: %s", entryKey,entryValue).println();
        }

        System.out.println("=== map 순회(3) keySet() 과 for 이용 ===");
        Set<Integer> keySet = map.keySet();   // [1001, 1002, 1003, 1004]
        System.out.println("keySet: "+keySet);
        for(Integer k: keySet){
            System.out.printf("Key: %d, Value: %s", k, map.get(k)).println();
        }

        // map 요소 삭제 (map 내의 entry 삭제)
        String deletedValue = map.remove(1003);   // 1003=박정은 삭제 후 value 반환됨
        System.out.println("삭제되는 value: "+deletedValue);   // 박정은
        System.out.println("삭제 후 map: "+map);   // {1001=홍길동, 1002=김민지, 1004=성향}
    }
}
