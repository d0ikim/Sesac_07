package _09_others.wrapper;

// 포장 값 비교
// - 포장 객체는 내부 값을 비교하기 위해 ==, != 사용 불가능
// - 내부 값을 비교하는 것이 아니라 포장 객체의 '번지'를 비교하기 때문
// - 따라서, equals() 메소드로 내부 값을 비교해야 함

// 예외!
// - byte, short, int = -128 ~ 127
// - boolean: true, false
// - char: \u0000 ~ \u007f
// 위 범위에 포함하는 값을 포장 객체 공유(같은 참조), 이 범위 이외의 값을 가지면 다른 참조!
public class ValueCompareEx {
    public static void main(String[] args) {
        // - 128 ~ 127 이내 값을 갖는 경우
        Integer obj1 = 10;
        Integer obj2 = 10;
        System.out.printf("%d == %d : %b%n", obj1, obj2, obj1 == obj2);
        System.out.printf("%d equals %d : %b%n%n", obj1, obj2, obj1.equals(obj2));

        // - 128 ~ 127 초과 값을 갖는 경우
        Integer obj3 = 1000;
        Integer obj4 = 1000;
        System.out.printf("%d == %d : %b%n", obj3, obj4, obj3 == obj4); // 번지수를 비교했기 때문
        System.out.printf("%d equals %d : %b%n%n", obj3, obj4, obj3.equals(obj4));

        // boolean
        Boolean bool1 = true;
        Boolean bool2 = true;
        System.out.printf("%b == %b : %b%n", bool1, bool2, bool1 == bool2);
        System.out.printf("%b equals %b : %b%n%n", bool1, bool2, bool1.equals(bool2));

        // char: \u0000 ~ \u007f
        Character char1 = 'A';
        Character char2 = 'A';
        System.out.printf("%c == %c : %b%n", char1, char2, char1 == char2);
        System.out.printf("%c equals %c : %b%n%n", char1, char2, char1.equals(char2));

        Character char3 = '\u0101';  // 유니코드 0101에 해당하는 문자 (ā)
        Character char4 = '\u0101';
        System.out.printf("%c == %c : %b%n", char3, char4, char3 == char4); // 번지수를 비교했기 때문
        System.out.printf("%c equals %c : %b%n", char3, char4, char3.equals(char4));
    }
}