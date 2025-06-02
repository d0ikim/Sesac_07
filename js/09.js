let total = 0;

for (let i = 0; i <= 100; i++) {
  if (i % 2 === 0 || i % 5 === 0) {
    total += i;
  }
}

console.log(`0~100 중 2 또는 5의 배수 총합 : ${total}`);
