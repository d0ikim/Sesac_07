"use strict";
/**
 * 1) boolean
  - boolean 타입은 참(true) 또는 거짓(false) 두 가지 값만을 나타냅니다.
  - 주로 조건문, 비교연산, 그리고 어떤 상태의 유효성 검사 등에서 사용됩니다.
  - 2가지 상태 (예/아니오, 활성/비활성 등)를 표현할 때는 `boolean`을 상용해야 해요!
  - 3가지 이상의 상태를 표현하고 싶다면 `enum`이나 `string` 또는 다른 복합 타입을 사용해야 합니다.
 */
function checkUserStatus(isLoggedIn) {
    if (isLoggedIn) {
        return "사용자가 로그인되어 있습니다.";
    }
    else {
        return "사용자가 로그인되어 있지 않습니다.";
    }
}
const currentUserLoggedIn = true;
const message = checkUserStatus(currentUserLoggedIn);
console.log(message);
const guestUserLoggedIn = false;
console.log(checkUserStatus(guestUserLoggedIn));
/**
 * 2) number
  - `number` 타입은 TypeScript에서 모든 종류의 숫자를 나타냅니다.
  - 일반적인 프로그래밍 언어에서는 정수(integer)와 실수(float/double)를 구분하여 다른 타입을 사용하지만, TypeScript에서는 `number` 타입 하나로 이 모든 것을 처리합니다.
  - 심지어 2진수, 8진수, 16진수 리터럴까지도 `number` 타입으로 표현할 수 있어요.
  - 모든 수치 연산에 사용되는 값은 `number` 타입으로 명시해주세요.
 */
function calculateDiscountPrice(originalPrice, discountRate) {
    return originalPrice * (1 - discountRate);
}
const productPrice = 12500.50;
const discount = 0.15;
const finalPrice = calculateDiscountPrice(productPrice, discount);
console.log(`원가 ${productPrice}원에서 ${discount * 100}% 할인된 가격: ${finalPrice.toFixed(2)}원`);
const hexValue = 0xFF;
console.log(hexValue);
/**
 * 3) string
  - string 타입은 텍스트 데이터를 나타냅니다. 작은따옴표(''), 큰따옴표(""), 또는 백쿼트(``)를 사용하여 문자열을 표현할 수 있습니다.
  - 특히 백쿼트(``)는 ES6부터 도입된 템플릭리터럴을 사용할 때 쓰이며, 문자열 내부에 변수나 표현식을 쉽게 삽입할 수 있도록 해줍니다.
  - string 타입은 텍스트를 조작하거나, 다른 텍스트와 합치거나, 특정 문자열을 찾고 대체하는 등 다양한 텍스트 관련 작업에 활용됩니다.
 */
function generateWelcomeMessage(userName, appName) {
    return `안녕하세요 ${userName}님! ${appName}에 오신 것을 환영합니다.`;
}
const user = "김도이";
const app = "TypeScript시작";
const welcomeMessage = generateWelcomeMessage(user, app);
console.log(welcomeMessage);
/**
 * 4) Array
  - 배열은 같은 타입의 여러 원소들을 순서대로 저장하는 자료구조!
  - 특정 타입 뒤에 [ ]를 붙여서 명시
 */
function calculateAverage(grades) {
    if (grades.length === 0) {
        return 0;
    }
    let sum = 0;
    for (const grade of grades) {
        sum += grade;
    }
    return sum / grades.length;
}
const studentGrades = [88, 92, 75, 95, 80];
const averageGrade = calculateAverage(studentGrades);
console.log(`학생 평균 점수 : ${averageGrade}`);
/**
 * 5) 튜플 (Tuple)
  - 튜플은 서로 다른 타입의 원소들을 정해진 순서와 개수에 맞게 가질 수 있는 특수한 형태의 배열
  - 각 위치에 올 수 있는 원소의 타입을 미리 명확하게 정의해야 합니다.
  
  튜플하고 배열의 차이
  가장 큰 차이는 원소의 타입 규칙!

  배열
  string[] => string만 넣을 수 있음
  튜플
  [string, string, number] 각 위치에 오는 타입이 다를 수 있음, 다만 순서와 개수를 미리 지정해야 함
 */
const userInfo = ["이순신", 35, true];
console.log(`이름: ${userInfo[0]}, 나이: ${userInfo[1]}, 활성: ${userInfo[2]}`);
/**
 * 6) enum
  - enum은 열거형 데이터 타입이라고 불림
  - 관련된 상수값의 집합에 의미있는 이름을 부여하여 코드를 더 쉽게 관리할 수 있게 만들어주는 타입
  - enum 내부의 각 요소는 별도로 설정 값을 지정하지 않으면, 0으로 시작함
  - enum에는 숫자, string만 할당 가능 (다른 데이터타입은 TS에서 할당 불가)
 */
var UserRole;
(function (UserRole) {
    UserRole["ADMIN"] = "ADMIN";
    UserRole["EDITOR"] = "EDITOR";
    UserRole["USER"] = "USER";
})(UserRole || (UserRole = {}));
var DayOfWeek;
(function (DayOfWeek) {
    DayOfWeek[DayOfWeek["SUNDAY"] = 0] = "SUNDAY";
    DayOfWeek[DayOfWeek["MONDAY"] = 1] = "MONDAY";
    DayOfWeek[DayOfWeek["TUESDAY"] = 2] = "TUESDAY";
    DayOfWeek[DayOfWeek["WEDNESDAY"] = 3] = "WEDNESDAY";
    DayOfWeek[DayOfWeek["THURSDAY"] = 4] = "THURSDAY";
    DayOfWeek[DayOfWeek["FRIDAY"] = 5] = "FRIDAY";
    DayOfWeek[DayOfWeek["SATURDAY"] = 6] = "SATURDAY"; // 6
})(DayOfWeek || (DayOfWeek = {}));
const today = DayOfWeek.MONDAY;
console.log(`현재 요일: ${DayOfWeek} (${today})`);
/**
 * const
 * 상수를 선언할 때 사용
 * const numbers = [1,2,3,4,5]
 * numbers.push(6)
 * numbers = [1,2,3,4,5,6]
 * - 객체나 배열 내부의 속성 또는 원소는 변경될 수 있다는 것
 */
const PI = 3.14159;
console.log(`원주율 PI: ${PI}`);
const colors = ["red", "green", "blue"];
console.log(`초기 색상 배열: ${colors}`);
colors.push("yellow");
console.log(`원소 추가 후: ${colors}`);
/**
 * readOnly
 * - readOnly 키워드는 TS에서만 사용되는 키워드입니다.
 * - 클래스의 속성이나 인터페이스의 속성을 불변으로 만들 때 사용
 * - readOnly로 선언된 속성은 생성자 내부에서 한 번만 초기화될 수 있으며,
 *   그 이후로는 값을 변경할 수 없습니다.
 * - const가 변수 자체의 재할당을 막는다면, readOnly는 객체 속성의 재할당을 막는 데 특화되어 있습니다.
 */
// class Product {
//   readonly productId: string;
//   productName: string;
//   price: number;
//   constructor(id:string, name:string, price:number) {
//     this.productId = id;
//     this.productName = name;
//     this.price = price;
//   }
// }
// const laptop = new Product("LAPTOP001", "최신형 노트북", 1500000)
// console.log(`제품 ID: ${laptop.productId}`)
// console.log(`제품명: ${laptop.productName}`)
// laptop.productName = "고급형 노트북"
// console.log(`변경제품명: ${laptop.productName}`)
/**
 * any
 * any 타입은 모든 타입의 슈퍼 타입
 * any 타입으로 선언된 변수에는 어떤 타입의 값이든 저장할 수 있다는 의미
 * JS의 Object 타입처럼, 모든 값을 수용할 수 있는 '만능' 타입
 *
 * any 타입은 TS의 타입 안정성을 포기하게 만드는 가장 위험한 도구
 * any를 사용하면 TS의 타입 검사 기능이 무력화되어, 잠재적인 런타임 오류를 컴파일 시점에 잡아내지 못하게 됩니다.
 */
let flesibleValue;
flesibleValue = 10;
console.log(flesibleValue);
flesibleValue = "자유로운 문자열";
console.log(flesibleValue);
flesibleValue = { id: 1, type: "data" };
console.log(flesibleValue);
let num = flesibleValue;
console.log(num);
/**
 * union 타입
 * - unknown 타입은 안전하게 타입을 다룰 수 있지만, 결국 값을 사용할 때마다 매번 타입을 확인해야 하는 번거로움
 * - union 타입은 변수가 여러 타입 중 하나를 가질 수 있도록 선언할 때 사용
 * - A 또는 B 또는 C 와 같은 논리적 OR(|) 연산자처럼, 정의된 여러 타입 중 하나만 만족 OK
 *
 *
 *
 * unknown
 * unknown 타입은 any 타입과 비슷하게 모든 타입의 값을 저장할 수 있습니다.
 * any와는 다르게 더 안전한 방식으로 동작
 * unknown 타입의 변수에 할당된 값을 다른 특정 타입의 변수에 할당하거나, 그 값을 직접 사용하려면 명시적으로 타입이 무엇인지 확인
 *
 * 즉, 사용하기 전에 반드시 타입 체크를 하도록 강제하게 만듬
 */
function printId(id) {
    if (typeof id === 'string') {
        console.log(`ID는 문자열입니다: ${id.toUpperCase()}`);
    }
    else {
        console.log(`ID는 숫자입니다: ${id.toFixed(2)}`);
    }
}
printId("spartan123");
printId(789012);
/**
 * TypeScript 사용하는 이유는 코드의 안정성과 유지보수성을 높이려고 사용합니다
 *
 * any, unknown 을 남용 = 악마의 유혹
 * 변수가 가질 수 있는 타입을 최대한 구체적으로 명시하려는 습관을 들이는 것이 중요합니다.
 *
 * union 타입과 같은 기능을 적극적으로 활용하여 불필요한 타입 오류를 방지하고, 더 견고하고 예측 가능한 코드를 작성
 */
/** 타입 가드 (Type Guard)
 * TS는 코드를 실행하기 전에 타입 오류를 잡는 강력한 기능을 제공하지만, 때로는 런타임에 변수의 실제 타입을 확인하고 싶을 때가 있습니다.
 *
 * 이때 사용하는 것이 바로 타입 가드 입니다.
 *
 * 타입 가드는 특정 스코프 내에서 변수의 타입을 좁히는 역할을 하여, 해당 타입의 속성이나 메서드를 안전하게 사용할 수 있도록 돕습니다.
 *
 * typeof
 * 원시 타입(string, number, boolean, symbol, bigint, ...) 을 확인할 때 사용
 *
 * instanceof
 * 특정 클래스의 인스턴스인지 확인할 때 사용
 *
 * in 연산자
 * 객체에 특정 속성이 존재하는지 확인할 때 사용
 *
 * 사용자 정의 타입 가드
 * 개발자가 직접 타입을 좁히는 함수를 정의
 * 반환 타입에 parameter is Type 형태의 타입 프레디케이트(Type Predicate)를 사용
 */
class Car {
    drive() {
        console.log("자동차가 운전됩니다.");
    }
}
class Bicycle {
    pedal() {
        console.log("자전거 페달을 밟습니다.");
    }
}
function moveVehicle(vehicle) {
    if (vehicle instanceof Car) {
        vehicle.drive();
    }
    else {
        vehicle.pedal();
    }
}
function makeSound(animal) {
    if ('bark' in animal) {
        animal.bark();
        console.log(`품종: ${animal.breed}`);
    }
    else {
        animal.meow();
        console.log(`골골송 여부: ${animal.purr}`);
    }
}
const myDog = { bark: () => console.log("멍멍!"), breed: "골든 리트리버" };
const myCat = { meow: () => console.log("야옹~"), purr: true };
makeSound(myCat);
function isFish(animal) {
    return animal.swim !== undefined;
}
const laptop = {
    id: 101,
    name: "울트라북",
    price: 1500000,
    createdAt: new Date()
};
const keyboard = {
    id: 102,
    name: "기계식 키보드",
    price: 120000,
    createdAt: new Date()
};
let mySearch;
mySearch = function (src, sub) {
    const result = src.indexOf(sub);
    return result > -1;
};
console.log(mySearch("안녕하세요 TypeScript", "Type"));
let myArray;
myArray = ["Hello", "World"];
console.log(myArray[0]);
let myDictionary = {
    name: "김도이",
    city: "서울"
};
console.log(myDictionary["name"]);
// myDictionary["age"] = 30;
myDictionary["country"] = "대한민국";
const myCircle = {
    color: "red",
    radius: 5
};
const myComplexCircle = {
    color: "blue",
    radius: 10,
    borderWidth: 2,
    borderColor: "black"
};
const userAge = 30;
const greetingName = "TypeScript";
console.log(`${greetingName}의 나이: ${userAge}`);
function showStatus(status) {
    console.log(`처리 상태: ${status}`);
}
showStatus("success");
const point = { x: 10, y: 20 };
console.log(`좌표: (${point.x}, ${point.y})`);
const employee = {
    name: "김도이",
    age: 28,
    employeeId: "EMP-001",
    department: "개발"
};
console.log(employee);
