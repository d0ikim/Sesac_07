// 필요한 파일들을 가지고 오는 부분(import)
import '../src/App.css'
import { useState } from 'react'
import {HandlerEx} from '../src/components/ex/HandlerEx'
/** 컴포넌트란
 * React의 핵심 빌딩 블록으로, UI를 표현하는 최소한의 단위!
 * 화면에 특정 부분이 어떻게 생겼는지 정하는 선언체라고 할 수 있음!
 * JSX로 UI 구조를 선언하면, React가 실제 화면에 맞게 그리는 방식
 * 
 * 컴포넌트 사용 이유
 * 1. 재사용성
 *    한번 만들어 놓은 컴포넌트는 여러 곳에서 재사용 가능
 * 2. 조합이 가능
 *    여러 컴포넌트를 조합하여 복잡한 UI를 구성할 수 있음
 * 3. 독립적
 *    각 컴포넌트는 독립적으로 동작하고 관리할 수 있음
 */

/** 명령형 vs 선언형 프로그래밍
 * - 명령형 프로그래밍
 * 어떻게(How)를 중심으로 프로그래밍
 * DOM을 직접 조작하여 단계별로 명령 실행!
 * 원하는 UI 상태를 선언하면 React 알아서 만듬
 * 1. 요소를 찾기
 * const container = document.getElementById('root')
 * 2. 요소 생성
 * const heading = document.createElement('h1')
 * 3. 텍스트 설정
 * heading.textContent = "텍스트"
 * 4. 스타일 설정
 * heading.style.color = "red"
 * heading.style.fontSize = "3rem"
 * 5. DOM에 추가
 * container.appendChild(heading)
 * 
 * - 선언형 프로그래밍
 * const App = () => {
 *  return (
 *    <h1 style={{
 *      color: 'blue',
 *      fontSize: '2rem'
 *     }}>
 *      텍스트
 *    </h1>
 *  )
 * }
 * ReactDOM.render(<App/>, document.getElementById('root'));
 * - 무엇을 만드는지에 대해 집중!
 * - 리액트가 DOM 조작을 알아서 하기 때문에 개발자의 실수로 인한 버그가 없어짐
 * - 복잡한 DOM을 조작을 빠르게 할 수 있음
 * - jsx로 데이터랑 화면구조를 한 파일에서 관리하여 유지보수 향상!   
 */

/** 불변성 
 * 불변성이란 메모리에 있는 값을 직접 변경하지 않는 것을 말합니다.
 * 새로운 값을 만들어서 기존 값을 대체하는 방식입니다.
 * 불변성이 있는 데이터 => 값
 * 숫자 / 문자열 / 불리언 / null / undefined
 * 
 * 불변성이 없는 데이터 => 주소값
 * 객체 / 배열 / 함수
 * 
 * State는 변화를 메모리의 주소로 판단
 * 주소가 같다면, 새로 렌더링 안함
 * 주소가 다르면, 새로 렌더링!
 * 
 */

/** State
 * State란 컴포넌트 내부에서 바뀔 수 있는 값 의미
 * UI 엘리먼트의 변경을 위해 사용
 */
const App = () => {
  // 자바스크립트를 사용할 수 있는 부분
  const [items, setItems] = useState([1,2,3]);
  const addItem = () => {
    setItems([...items, items.length+1])
  }
  const removeItem = (index) => {
    setItems(items.filter((_,i) => i !== index))
  }
  
  return (
    <div>
      <h1>렌더링 예제</h1>
      <Counter />
    </div>
  );
}

function Counter() {
  console.log('Counter 컴포넌트 렌더링!')
  const [count, setCount] = useState(0)
  const increment = () => {
    setCount(count+1)
  }

  return (
    <div>
      <h2>카운트 : {count}</h2>
      <button onClick={increment}>증가</button>
    </div>
  )
}

/** Props
 * Props는 객체(Object) 형태의 데이터
 * JavaScript의 구조분해할당(Destructuring)을 활용
*/
/**Prop Drilling
 * [부모] -> [자식] -> [그 자식] -> [그 자식의 자식] -> [그 놈의 자식]
 * Prop Drilling의 문제점
 * 중간 컴포넌트들이 사용하지 않는 props를 계속 전달해야 함
 * 코드가 복잡해지고 유지보수가 어려워짐
 * 컴포넌트 간 의존성이 높아짐
 * 이러한 문제를 해결하기 위해 Redux, Context API와 같은 상태관리 도구 사용!
 */

export default App;
