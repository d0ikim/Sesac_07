// 사용자 인터페이스 (User Interface) 정의
enum Role {
  Admin = "admin",
  Regular = "regular",
}
interface User {
  // interface
  // 역할 : 객체가 가져야 할 속성과 메서드 구조를 정의하는 타입 선언서
  // 실행 시 존재 여부 : 컴파일 후 사라지고, 타입 검사에만 사용됨
  // 목적 : 타입 안전성 보장과 코드 문서화 목적, 계약(contract) 정의
  id: string
  name: string
  role: 'admin' | 'regular' // 위에 enum 해놈
}
const admin:User = {
  id: "admin-001",
  name: "관리자",
  role: "admin"
}
const user:User = {
  id: "user-001",
  name: "김도이",
  role: "regular"
}
console.log(admin)
console.log(user)

// 도서정보 인터페이스 정의
interface Book {
  isbn: string
  title: string
  author: string
  publishedYear: number
  isAvailable : boolean
}
interface LoanRecord {
  loanId: number
  bookIsgn: string
  userId: string
  loanDate: Date
  dueDate: Date
  returnDate?: Date
}

// 데이터 정의
// 도서 목록을 저장
let libraryBooks: Book[] = []
// 회원 목록을 저장
let libraryUsers: User[] = []
// 대출 기록을 저장
let loanRecords: LoanRecord[] = []

function isAdmin(user: User): boolean {
  return user.role === Role.Admin
}
function isRegularUser(user: User): boolean
 {
  return user.name === Role.Regular
 }

const book: Book = {
  isbn:"1234-5678-1234-5678",
  title:"1Q84",
  author:"무라카미 하루키",
  publishedYear: 1999,
  isAvailable:true
}
// console.log(book)

 // 1. 도서 등록 기능 : 관리자만 등록이 가능함
 function addBook(user: User, newBook:Book): void {
  // user가 권한이 있는지 확인
  if (!isAdmin(user)) {
    console.log('권한이 없는 유저입니다.\n');  // 권한 없을 시 종료
  }

  // book정보가 이미 등록되어 있는지 확인
  if (libraryBooks.some(registeredBook => registeredBook.isbn === newBook.isbn)) {
    console.log('이미 등록된 도서입니다.\n')
    return  // 종료
  }

  // 없는 경우에만 등록
  libraryBooks.push(newBook)
  console.log(`'${newBook.title}' 도서가 등록되었습니다.\n`)
  console.log(`등록된 도서목록\n${JSON.stringify(libraryBooks, null, 2)}\n`)
 }
 addBook(admin, book);

 // 2. 도서 삭제 기능 : 관리자만 삭제가 가능함
 function removeBook(user: User, isbn:Pick<Book, 'isbn'>): void {
  // user가 권한이 있는지 확인
  if (!isAdmin(user)) {
    console.log('권한이 없는 유저입니다.\n');  // 권한 없을 시 종료
  }

  // 도서 찾기
  const bookIndex = libraryBooks.findIndex(book => book.isbn === isbn.isbn);
  if (bookIndex === -1) {
    console.log('등록되지 않은 도서입니다.\n');
    return;
  }
  const bookToRemove = libraryBooks[bookIndex];

  // 대출 중인지 확인
  if (bookToRemove.isAvailable === false) {
    console.log('대출 중인 도서이므로 삭제할 수 없습니다.\n');
    return;
  }

  // 삭제
  libraryBooks.splice(bookIndex, 1);
  console.log(`'${bookToRemove.title}' 도서가 도서목록에서 삭제되었습니다.\n`);
  console.log(`도서목록\n${JSON.stringify(libraryBooks, null, 2)}\n`);
 }
//  removeBook(admin, book)

 // 3. 도서 대출 기능
 function borrowBook(user: User, isbn: string): number {
  // 입력받은 isbn이 도서 목록에 있는지 확인
  if (!libraryBooks.some(registeredBook => registeredBook.isbn === isbn)) {
    console.log('도서 목록에 없습니다.')
    return -1
  }

  // 해당 도서가 대출 중인지 확인
  const bookIndex = libraryBooks.findIndex(book => book.isbn === isbn)
  if (!libraryBooks[bookIndex].isAvailable) {
    console.log('해당 도서는 대출 중 입니다.')
    return -1
  } else {  // 대출이 가능하면 index값 반환
    console.log(`${user.name} 회원이 '${libraryBooks[bookIndex].title}' 도서를 대출합니다.`)
    return bookIndex
  }
 }
// borrowBook(user, book.isbn)

// 4. 유저 등록 기능 : 관리자만 등록이 가능함
function registerUser(admin: User, { id, name, role }: User) {
  // 관리자인지 확인
  if (!isAdmin(admin)) {
    console.log('관리자가 아닙니다.\n')
    return
  }

  // 등록된 유저인지 확인
  if (libraryUsers.some(user => user.id === id)) {
    console.log('이미 등록된 유저입니다.\n')
    return
  }

  // 유저 등록
  libraryUsers.push({
  id,
  name,
  role
})
  console.log(`${name}(${id}) 회원이 정상적으로 등록되었습니다.\n`)
}
registerUser(admin, user);
registerUser(admin, user);