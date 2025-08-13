package _04_exception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("배열의 크기를 입력해주세요: ");
            int size = scan.nextInt();  // 에외 발생 가능 > InputMismatchException
            
            if(size<=0) {
                throw new IllegalArgumentException("잘못된 값이 전달됐습니다.");
                // 0이나 음수가 들어왔을 때, 에외 만들기
            }
            int[] arr = new int[size];

            for(int i=0;i<size;i++){
                System.out.print("정수 입력: ");
                arr[i] = scan.nextInt();
            }
            // 중복될 요소들 개수를 모르기때문에, 동적할당 arrayList 사용
            ArrayList<Integer> duplicates = findDuplicates(arr);
            if(duplicates.isEmpty()) {
                System.out.println("중복된 요소가 없습니다.");
            } else{
                System.out.println("중복된 요소: "+duplicates);
            }

        } catch(InputMismatchException e){
            System.out.println("배열의 크기로는 정수를 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("배열의 크기는 1이상의 자연수이어야 합니다.");
        } finally {
            scan.close();
        }
    }

    public static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        // 중복될 요소가 몇 개일지 확실하지 않음 -> 정적할당 불가
        // 배열의 크기를 조절할 수 있는 arrayList 사용! == 동적할당 가능

        // [1,2,3,4,5]
        // 1 vs 2,3,4,5
        // 2 vs 3,4,5
        // 3 vs 4,5 => 요소가 같은지 비교하고, 같다면 duplicates에 add()
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){    // 선택된 것 vs 그 다음 ~ 끝까지 비교
                if(arr[i] == arr[j] && !duplicates.contains(arr[i])) {
                    // arr 배열에 중복된 요소가 있고
                    // duplicates에 해당 요소가 없는 경우
                    duplicates.add(arr[i]);
                }
            }
        }

        return duplicates;
    }
}
