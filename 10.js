let arr = [];

// 1~100까지의 배열을 for문을 사용해서 만들기
for (let i = 1; i <= 100; i++) {
  arr.push(i);
}

// 해당 배열의 합을 for문을 사용해서 구하기
let sum = 0;
for (let i = 0; i < arr.length; i++) {
  sum += arr[i];
}
console.log(`for문을 사용한 합 : ${sum}`);

// 해당 배열의 합을 for of문을 사용해서 구하기
let sum2 = 0;
for (let num of arr) {
  sum2 += num;
}
console.log(`for of문을 사용한 합 : ${sum2}`);

// 해당 배열의 합을 forEach문을 사용해서 구하기
let sum3 = 0;
arr.forEach((num) => {
  sum3 += num;
});
console.log(`forEach문을 사용한 합 : ${sum3}`);
