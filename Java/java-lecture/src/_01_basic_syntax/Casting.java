package _01_basic_syntax;

// 형변환
public class Casting {
    public static void main(String[] args) {
        // 1. 묵시적 형변환
        // - 더 작은 타입에서 더 큰 타입으로의 자동 형변환
        // - 반대의 경우는 자동으로 형변환되지 않음 >> 명시적으로 변환 필수!
        int smallerNumber = 10;
        double bigNumber = smallerNumber;   // int>double 자동형변환 일어남 10.0
        System.out.println("bigNumber: "+bigNumber);

        // 2. 명시적 형변환
        double anotherBigNumber = 20.7;
        int anotherSmallnumber = (int) anotherBigNumber;    // double>>int 명시적 형변환 이루어지고있음
        System.out.println("anotherBigNumber: "+ anotherBigNumber);     //20.7
        System.out.println("anotherSmallnumber: "+anotherSmallnumber);  // 20 데이터 유실 발생 가능

        int largeNumber = 1000;
        byte smallByte = (byte) largeNumber;
        System.out.println("largeNumber: "+largeNumber);    // 1000
        System.out.println("smallByte: "+smallByte);        // -24 >> 데이터 유실됨!
        // 데이터 손실이 일어날 수 있으니 주의해야합니다
    }
}
