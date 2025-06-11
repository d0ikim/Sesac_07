let answer = [];

for (let i = 1; i <= 10000; i++) {
  if (i % 13 === 0 && i % 2 === 1) {
    console.log(`13의 배수이면서 홀수인 수: ${i}`);
    answer.push(i);
  }
}

console.log(answer);

// + prompt 이용해서 입력받은 수까지 13의 배수면서 홀수인 숫자를 찾는 프로그램
let inputNumber = prompt('숫자를 입력하세요');
let answer2 = [];

for (let i = 1; i <= inputNumber; i++) {
  if (i % 13 === 0 && i % 2 === 1) {
    console.log(`13의 배수이면서 홀수인 수: ${i}`);
    answer2.push(i);
  }
}

console.log(answer2);
