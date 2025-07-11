/** 제너릭(Generic)
 * 프로그래밍을 하면서 다양한 데이터를 다루게 되는데, 이 데이터들을 안정적으로 처리하기 위해 타입 나왔습니다.
 * 어떤 함수나 클래스가 여러 타입을 유연하게 받아들일 수 있어야 할 때 필요하다!
 */

function createArray<T>(x:T, y:T):T[]{
 return [x,y]
}
createArray('a','b')
createArray(1,2)

createArray<string>('aa','bb')

function test<T,G>(x:T, y:G) {

}
test(1,'a')

function print(value: any): any {
  console.log(value)
  return value
}

// any를 사용하면 모든 타입을 받을 수 있지만, 타입스크립트의 가장 큰 장점인 정적 타입 검사가 없어진다.
// 아무 타입이나 들어오고 아무 타입으로 나가니 IDE나 컴파일러가 도와줄 수 없기 때문에 등장
// 제너릭은 타입을 매개변수처럼 사용하는 문법
// 마치 함수의 인자처럼, 나중에 타입을 넘길 수 있는 유연한 방식
function identity<T>(value: T): T {
  return value
}

// T는 타입 변수(Type Variable)
// identity<number>(123) 이라고 호출하면 T는 number가 되고,
// identity<string>('hello') 라고 하면 T는 string이 됩니다.
// 이처럼 제너릭은 유연성(재사용성)과 타입 안정성을 모두 챙길 수 있는 도구

/** 유틸리티 타입 (Utility Types)
 * TS의 유틸리티 타입은 기존 타입을 기반으로 새로운 타입을 쉽게 생성하고 변환할 수 있도록 돕는 강력한 기능
 * 이를 통해 코드의 재사용성을 높이고 타입 추론을 더욱 효과적으로 활용할 수 있습니다.
 * 
 * 1) Partial<T> 타입
 *    타입 T의 모든 속성을 선택적(?)으로 만듭니다.
 *    즉, 해당 타입의 객체를 생성할 때 일부 또는 모든 속성을 생략할 수 있게 해줍니다.
 *    보통은 객체의 일부 속성만 업데이트하거나, 특정 필드가 필수가 아닌 경우 사용합니다.
 */
interface Product {
  id: string,
  name: string,
  price: number,
  description?: string
}

// Partial<T>
function updateProduct(product: Product, fieldsToUpdate: Partial<Product>): Product {
  return {...product, ...fieldsToUpdate}
}
const originalProduct: Product = {
  id: "A101",
  name: "Laptop",
  price: 1200,
  description: "Powerful laptop for professionals"
}
const updatedProduct1 = updateProduct(originalProduct, {name: "Gaming Laptop"})
console.log(updatedProduct1)

const updatedProduct2 = updateProduct(originalProduct, {
  price: 1300,
  description: "New model with enhanced performance"
})

/** 2) Required<T>
 *     Required<T>는 Partial<T>와 반대로, 타입 T의 모든 속성을 필수적으로 만듬
 */
interface UserProfile {
  username: string,
  email: string
  phone?: string    // 선택적 속성
  address?: string  // 선택적 속성
}
type CompleteuserProfile = Required<UserProfile>
const newUser: CompleteuserProfile = {
  username: "john_doe",
  email: "john@example.com",
  phone: "010-1234-5678",
  address: "Seoulm South Korea"
}
// const incompleteUser: CompleteuserProfile = CompleteUserProfile = {
//   username: "jane_doe",
//   email: "jane@example.com"
// }

/** 3) Readonly<T>
 *     타입 T의 모든 속성을 읽기 전용(readonly)으로 만듭니다.
 *     한 번 할당된 속성 값은 이후에 변경할 수 없습니다.    
 */
interface Point {
  x: number
  y: number
}
const mutablePoint: Point = {x:10, y:20}
mutablePoint.x = 15
console.log(mutablePoint)

type ImmutablePoint = Readonly<Point>

const immutablePoint: ImmutablePoint = {x:30, y:40}
// immutablePoint.x = 35;
console.log(immutablePoint)

/** 4) Pick<T,K>
 *     Pick<T,K>는 타입 T에서 K에 해당하는 속성들만 선택하여 새로운 타입
 *     여기서 K는 T의 속성 이름들의 유니온 타입
 */
interface Customer {
  id: string
  firstName: string
  lastName: string
  email: string
  phoneNumber?: string
}
type CustomerName = Pick<Customer, "firstName" | "lastName">

const customerInfo: CustomerName = {
  firstName: "Alice",
  lastName: "Smith"
}
console.log(customerInfo) // { firstName: 'Alice', lastName: 'Smith' }

const invalidCustomerInfo: CustomerName = {
  firstName: "Bob",
  lastName: "Johnson",
  // email: "bob@example.com"
}

/** 5) Omit<T,K>
 *     Pick<T,K>와 반대로, 타입T에서 K에 해당하는 속성들만 제외하여 새로운 타입을 만듬
 *     기존 타입에서 불필요한 속성들을 제거하여 새로운 타입을 정의할 때 사용
 */
interface Employee {
  id: string
  name: string
  department: string
  salary: number
  hireDate: Date
}
type PublicEmployeeInfo = Omit<Employee, "salary" | "hireDate">

const publicInfo: PublicEmployeeInfo = {
  id: "EMP001",
  name: "Charlie Brown",
  department: "Marketing"
}
console.log(publicInfo)

