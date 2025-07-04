// string
let username = 10
let message: string = `Hello, ${username}`;

// number
let age: number = 27;
let pi: number = 3.14

// boolean
let isLoggedIn: boolean = true;
let hasPermission: boolean = false;

// null, undefined
// strictNullChecks tsconfig에 설정 필요
let nothing: null = null;
let notAssigned: undefined = undefined;

// any (최대한 쓰지 않는 것을 TS가 권장)
let data: any = 123;
data = "문자열도 가능";
data = true;

// unknown (무조건 사용 전에 타입검사해서 any보다 안전)
let value: unknown = "문자열";

if (typeof value === "string") {
  console.log(value.toUpperCase());
}

// void (함수에만 쓰임)
// 함수가 값을 반환하지 않을 때 사용
function logMessage(message: string): void {
  console.log(message);
}

// never
// 절대 반환하지 않는 함수에 사용
function throwError(): never {
  throw new Error("예외 발생!")
}

// object
let obj: object = { name: "Alice" }
let obj2: { name:string } = { name:"Alice" }  // 실제론 거의 이렇게 구조분해할당처럼 다 펼쳐놓는다. 어떤 모양인지 미리 알 수 있게 작성함

// 배열
let fruits: string[] = ["test1", "test2"]