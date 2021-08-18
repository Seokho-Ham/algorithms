### 문제

---

- 카펫이 주어지며 테두리는 갈색, 가운데는 노란색으로 채워져있다.
- 갈색 카펫의 개수, 노란색 카펫이 input으로 주어진다.
- 카펫의 가로, 세로를 배열에 담아 반환해야한다.

<br>

### 제한사항

---

- 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
- 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
- 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

<br>

### 예시

---

```js
//Ex1
Input: 10, 2
Output:[4, 3]
//Ex2
Input: 8, 1
Output:[3, 3]
//Ex3
Input: 24	24
Output:[8, 6]
```

<br>

### 나의 풀이 :

---

- brown + yellow의 값이 size(총면적)를 나타낸다.
- size의 약수들이 정답이 되는데 가로>=세로 이다.
- for문을 사용해 size를 i로 나눈 나머지가 0일 경우 약수다.
- 약수일 경우 width, height 변수에 각 가로, 세로 길이를 담는다.
- 테두리가 모두 갈색이기 때문에 노란 카펫의 가로 세로는 각 값에서 -2를 한 것의 곱이다.

```js
function solution(brown, yellow) {
  let size = brown + yellow;
  for (let i = 2; i <= size; i++) {
    if (size % i === 0) {
      let width = size / i > i ? size / i : i;
      let height = size / i > i ? i : size / i;

      if ((width - 2) * (height - 2) === yellow) {
        return [width, height];
      }
    }
  }
}
// 수도 코드
// brown + yellow = 가로 * 세로 = 총면적
// brown + yellow의 약수들이 곧 정답.
// for문 사용해서 전체 크기를 i로 나눈다.
// 나머지가 0일 경우 약수에 해당
// 노란색의 가로 길이 = 가로 -2
// 노란색의 세로 길이 = 세로 - 2
// 두개를 곱한 값이 yellow의 길이와 같으면 정답.
```

<br>

##### 추가

---

- 페어분이 작성하신 코드를 보고 더 깔끔한 것 같아 추가한다.
- for문을 사용할때 증가하는 값을 세로축으로 생각하고 사용하면 굳이 값을 비교하지 않아도 가로가 무조건 더 큰값이 된다.

```js
function solution(brown, yellow) {
  let size = brown + yellow;
  for (let i = 2; i <= size; i++) {
    if (size % i === 0) {
      let width = size / i;
      let height = i;

      if ((width - 2) * (height - 2) === yellow) {
        return [width, height];
      }
    }
  }
}
```
