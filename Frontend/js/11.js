let fruits1 = [
  '사과',
  '딸기',
  '파인애플',
  '수박',
  '참외',
  '오렌지',
  '자두',
  '망고',
];
let fruits2 = ['수박', '사과', '참외', '오렌지', '파인애플', '망고'];

let same = [];
let diff = [];

same = fruits1.filter((fruit) => fruits2.includes(fruit));
console.log(`같은 과일 : ${same}`);

diff = fruits1.filter((fruit) => !fruits2.includes(fruit));
console.log(`다른 과일 : ${diff}`);
