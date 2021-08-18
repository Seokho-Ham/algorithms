#### 문제

---

- 배열로 주어진 숫자에 1을 더해서 반환하는 문제.

<br>

#### 예시

---

```js
//Ex1
Input: digits = [1, 2, 3];
Output: [1, 2, 4];
//Ex2
Input: digits = [4, 3, 2, 1];
Output: [4, 3, 2, 2];
```

<br>

#### 나의 풀이 :

---

```js
var plusOne = function (digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    if (digits[i] !== 9) {
      digits[i]++;
      return digits;
    } else {
      digits[i] = 0;
    }
  }
  digits.unshift(1);
  return digits;
};
```

처음에는 배열로 주어진 값을 join 함수를 사용해 Number로 바꾸는 방식을 사용했다.
<br>
하지만 숫자의 길이가 15자리를 넘어가는 케이스에서는 정확한 값이 안나오길래 검새해보니 Javascript에서는 64비트 부동 소수점 방식으로 저장하기 때문에 정수는 15자리까지 정밀도가 유지된다는것을 발견했다.
<br><br>
그래서 for문을 사용해 뒤에서부터 값이 9가 아니면 1을 더하고 digits를 리턴, 아니면 현재 값을 0으로 변경.
<br>
unshift 메소드는 for문이 끝까지 돌았을 경우, 모든 숫자가 9였다는 의미이기 때문에 1을 앞에 추가해주도록 사용했다.
