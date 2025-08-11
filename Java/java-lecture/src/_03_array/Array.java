package _03_array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

// 표준 배열
public class Array {
    public static void main(String[] args) {
        int[] arr1; // 관례적으로 이 방법을 더 많이 사용
        int arr2[];

        String[] temp = null;
        System.out.println(temp);

        int[] intArray = {10, 22, 25, 45, 55};
        System.out.println("intArray[0]: "+intArray[0]);
        System.out.println("intArray: "+intArray);
        intArray[1] = 20;   // 값 변경 가능
        System.out.println("intArray: "+ Arrays.toString(intArray));

        char[] charArray = {'a', 'A', '2', 66};
        System.out.println(charArray[2]);   // 2
        System.out.println(charArray[3]);   // B

        double[] doubleArray = new double[3];   // 길이가 변하지 않는 정적 할당
        System.out.println(doubleArray[0]); // 0.0이 double의 기본값
        System.out.println(doubleArray[1]);
        System.out.println(doubleArray[2]);

        // 값 수정
        doubleArray[0] = 0.1;
        doubleArray[1] = 2.4;
        doubleArray[2] = 1.8;

        System.out.println("doubleArray: "+Arrays.toString(doubleArray));
        System.out.println("배열의 길이: "+doubleArray.length);

        // 다차원 배열
        int[][] matrix = {{1,2,3},{4,5,6}}; // 2X3
        // 숫자 2를 뽑는 방법
        System.out.println(matrix[0][1]);
        // 숫자 6을 뽑는 방법
        System.out.println(matrix[1][2]);

        int[][] matrix2 = new int[3][2];
        matrix2[0][0] = 1;
        matrix2[0][1] = 2;
        matrix2[1][0] = 3;
        matrix2[1][1] = 4;
        matrix2[2][0] = 5;
        matrix2[2][1] = 6;
        // {{1,2}, {3,4}, {5,6}}

        // 객체를 참조하는 배열
        // - primitive 타입의 배열은 각 항목에 값만 저장
        // - reference 타입의 배열은 각 항목에 주소를 저장
        String[] langs = new String[3];
        langs[0]="Java";
        langs[1]="Java";
        langs[2]=new String("Java");

        System.out.println(langs[0]==langs[1]); // 주소 비교, true (문자열 리터럴)
        System.out.println(langs[1]==langs[2]); // 주소 비교, false (문자열 리터럴과 객체)
        System.out.println(langs[0].equals(langs[2]));  // 값 비교, true

        // 배열 복사
        // ver1. for문으로 요소 하나씩 복사
        int[] originArray = {1,2,3};
        int[] newArray = new int[5];
        System.out.println(Arrays.toString(newArray));  // [0, 0, 0, 0, 0]
        for(int i=0; i<originArray.length; i++){
            newArray[i] = originArray[i];   // 복사
        }
        System.out.println("복사 후 결과, "+Arrays.toString(newArray));  // [1, 2, 3, 0, 0]

        // ver2. arrayCopy() 메소드 사용
        // arrayCopy(Object src, int srcPos, Object dest, int destPos, int length)
        /*
         * Object src: 원본 배열
         * int srcPos: 원본 배열 복사 시작 index
         * Object dest: 새로운 배열
         * int destPos: 새 배열의 어디부터 붙여넣을지 index
         * int length: 복사 항목 수
         */
        String[] originFruits = {"apple", "banana", "coconut"};
        String[] newFruits = new String[5];
        System.out.println(Arrays.toString(newFruits));
        System.arraycopy(originFruits, 1, newFruits, 1, originFruits.length-1);
        System.out.println(Arrays.toString(originFruits));  // [apple, banana, coconut]
        System.out.println(Arrays.toString(newFruits)); // [null, banana, coconut, null, null]

        /////////// java.util.Arrays 의 메소드 사용 ///////////
        /* 1. Arrays.copyOf() : 처음부터 복사하되, 인자로 전달되는 길이만큼 복사 */
        int[] originArr = {1,2,3,4,5};
        int[] copiedArray = Arrays.copyOf(originArr, 3);    // [1,2,3]
        int[] copiedArray2 = Arrays.copyOf(originArr, 7);   // [1,2,3,4,5,0,0]
        System.out.println("copiedArray: "+Arrays.toString(copiedArray));
        System.out.println("copiedArray2: "+Arrays.toString(copiedArray2));


        /* 2. Arrays.copyOfRange(arr, sIdx포함, eIdx전까지) */
        // sIdx <= copy < eIdx(포함x)
        int[] rangeArray = Arrays.copyOfRange(originArr, 1, 4);   // [2,3,4]
        System.out.println("Range Array: "+Arrays.toString(rangeArray));


        /* 3. Arrays.fill(arr, val) : arr 의 모든 요소를 val로 채움 */
        int[] filledArray = new int[5];
        System.out.println("filledArray (before) :: "+Arrays.toString(filledArray));
        Arrays.fill(filledArray, 7);
        System.out.println("filledArray (after) :: "+Arrays.toString(filledArray));


        /* 4. Arrays.sort(arr) : 배열을 무조건 오름차순으로 정렬 */
        int[] unSortedArray = {5,3,1,2,4};
        Arrays.sort(unSortedArray);
        System.out.println("정렬 후: "+Arrays.toString(unSortedArray));

        // 참고) 내림차순 정렬시 - int가 아닌 Integer로 선언해야 한다(reference type으로 선언)
        Integer[] intArr1 = new Integer[]{5,6,10,0,2};
        Arrays.sort(intArr1, Collections.reverseOrder());
        System.out.println("내림차순 정렬 후: "+Arrays.toString(intArr1));

        Integer[] intArr2 = new Integer[]{5,6,10,0,2};
        Arrays.sort(intArr2, (a,b)-> b-a);
        System.out.println("내림차순 정렬 후 :"+Arrays.toString(intArr2));


        /* 5. Arrays.equals(arr1, arr2) : 배열의 주소가 아닌 순서에 따른 값이 일치하는지 검사 */
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        int[] array3 = {4,2,3};
        System.out.println("Arrays 연산자(==) 비교: "+ (array1==array2));    // false
        System.out.println("Arrays 연산자(==) 비교: "+ (array1==array3));    // false

        boolean arrayEqual = Arrays.equals(array1, array2);
        boolean arrayEqual2 = Arrays.equals(array1, array3);
        System.out.println("Arrays Equal 메소드 비교(1,2): "+arrayEqual);    // true
        System.out.println("Arrays Equal 메소드 비교(1,3): "+arrayEqual2);   // false


        /* 6. Arrays.deepEquals(arr1, arr2) : 깊게 들어가 비교 */
        int[][] deepArray1={{1,2},{3,4}};
        int[][] deepArray2={{1,2},{3,4}};
        int[][] deepArray3={{1,2},{3,5}};

        System.out.println("2차원 배열 비교(Equals): "+Arrays.equals(deepArray1,deepArray2)); // false
        System.out.println("2차원 배열 비교(deepEquals): "+Arrays.deepEquals(deepArray1,deepArray2)); // true
        System.out.println("2차원 배열 비교(deepEquals): "+Arrays.deepEquals(deepArray1,deepArray3)); // false


        /* 7. Arrays.binarySearch(arr, val) : 정렬된 배열 기준, 몇 번째 요소인지 index 반환 */
        int[] sortedArray={10,30,50,70,90,99,102};  // 오름차순 정렬
        int index = Arrays.binarySearch(sortedArray, 50);   // 2
        int index2 = Arrays.binarySearch(sortedArray, 90);  // 4
        int index3 = Arrays.binarySearch(sortedArray, 60);  // ?
        System.out.println("index 50: "+index);
        System.out.println("index 90: "+index2);
        System.out.println("index 60: "+index3);    // 검색결과 없을 때, 무작위의 "음수" 반환



    }
}
