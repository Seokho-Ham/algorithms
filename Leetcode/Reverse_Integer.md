### 문제

> Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.<br>
> Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

### 예시

| Example | Input    | Output |
| ------- | -------- | ------ |
| 1       | x = 123  | 321    |
| 2       | x = -123 | -321   |
| 3       | x = 120  | 21     |
| 4       | x = 0    | 0      |

### 나의 풀이

```js
var reverse = function (x) {
  let reversedNum = parseInt(Math.abs(x).toString().split('').reverse().join(''));

  if (x < 0) {
    reversedNum = -reversedNum;
  }
  if (reversedNum > Math.pow(2, 31) || reversedNum < Math.pow(-2, 31)) {
    return 0;
  }
  return reversedNum;
};
```
