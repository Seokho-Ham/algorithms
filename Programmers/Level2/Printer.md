### 문제

> 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. <br>
> 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

```
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
```

<br>

### 제한사항

> 1. 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
> 2. 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
> 3. location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

<br>

### 입출력 예

| priorities         | location | return |
| ------------------ | -------- | ------ |
| [2, 1, 3, 2]       | 2        | 1      |
| [1, 1, 9, 1, 1, 1] | 0        | 5      |

<br>

### 나의 풀이

```js
function solution(priorities, location) {
  var answer = 0;
  let arr = [];
  priorities[location] = { val: priorities[location] };

  while (priorities.length > 0) {
    let current = priorities[0].val ? priorities[0].val : priorities[0];
    let bool = false;
    for (let i = 1; i < priorities.length; i++) {
      if (current < (priorities[i].val ? priorities[i].val : priorities[i])) {
        bool = true;
        break;
      }
    }
    if (bool) {
      priorities.push(priorities.shift());
    } else {
      arr.push(priorities.shift());
    }
  }

  arr.forEach(el => {
    if (typeof el !== 'number') {
      answer = arr.indexOf(el) + 1;
    }
  });
  return answer;
}
```

막상 풀고나니 굳이 필요없는 변수들을 만들어 풀었다는 것을 발견했다.

- priorities의 값들을 모두 객체 형태로 바꾸어서 풀면 굳이 삼항연산자를 사용하지 않아도 된다.
- arr에 값들을 옮겨담지 않아도 되며, 값이 빠질때만다 answer값에 1씩 더해주면 된다.

### **새로운 풀이**

```js
function solution(priorities, location) {
  var answer = 0;
  let arr = priorities.map((el, i) => {
    if (i === location) {
      return {
        val: el,
        index: i,
      };
    } else {
      return { val: el };
    }
  });

  while (true) {
    let current = arr.shift();
    if (arr.some(el => el.val > current.val)) {
      arr.push(current);
    } else {
      answer++;
      if (current.index !== undefined) {
        return answer;
      }
    }
  }
}
//
```
