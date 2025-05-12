// 1. 내장객체 Date를 이용해서 오늘이 평일인지 주말인지 콘솔창에 출력해주세요
// 2. 조건문과 함께 프로그램을 작성해주세요
let today = new Date().getDay(); // 0(일) ~ 6(토)까지의 숫자
console.log(today === 0 && today === 6 ? '주말' : '평일');
