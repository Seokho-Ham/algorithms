### 문제 설명

> 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
> <br>
> s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. '
> <br>
> p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

### 제한사항

> 1. 문자열 s의 길이 : 50 이하의 자연수
> 2. 문자열 s는 알파벳으로만 이루어져 있습니다.

### 입출력 예

| s       | answer |
| ------- | ------ |
| pPoooyY | true   |
| Pyy     | false  |

### 나의 풀이

```js 문제풀이 1
function solution(s) {
  var answer = true;
  let word = s.toLowerCase();
  let pcount = 0;
  let ycount = 0;
  for (let i = 0; i < word.length; i++) {
    if (word[i] === 'p') {
      pcount++;
    }
    if (word[i] === 'y') {
      ycount++;
    }
  }

  if (pcount !== ycount) {
    return false;
  }
  return answer;
}
```

```js 문제풀이 2
function solution(s) {
  let word = s.toLowerCase().split('');
  return word.filter(el => el === 'p').length === word.filter(el => el === 'y').length;
}
```

### 1번

- 단순하게 문자열의 길이만큼 반복문을 돌려 p와 y의 개수를 각각 카운트하는 식으로 풀었다.

### 2번

- 앞의 코드가 쉽지만 길어지길래 다른 방식을 고민해 푼 방식.

1. 인자로 들어온 문자열을 모두 소문자로 변경한 후 배열로 만들었다.
2. 이후 filter 메서드를 사용해 p와 y를 각각 추출한 배열의 길이를 비교한 결과를 리턴하도록 짰다.
