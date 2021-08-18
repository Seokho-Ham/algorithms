### 문제

> 숫자 n이 주어지면 1부터 n까지 반복되는 recursive함수를 구현하는 문제.<br>
> The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
>
> - countAndSay(1) = "1"
> - countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.

<!-- more -->

> To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. <br>Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

### 예시

```md 예시
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
```

### 나의 풀이

```js count and say
var countAndSay = function (n) {
  if (n === 1) {
    return '1';
  }

  function recursive(num, str) {
    if (num === n) {
      return str;
    }
    let result = '';
    let firstWord = str[0];
    let count = 0;
    for (let i = 0; i < str.length; i++) {
      if (str[i] === firstWord) {
        count++;
      } else {
        result += count + firstWord;
        count = 1;
        firstWord = str[i];
      }
    }

    return recursive(num + 1, result + count + firstWord);
  }

  return recursive(1, '1');
};
```
