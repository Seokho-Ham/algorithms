### 문제

> Implement strStr().<br>
> Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

> Clarification:<br>
> What should we return when needle is an empty string? This is a great question to ask during an interview.<br>
> For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

### 예시

| Example | Input                              | Output |
| ------- | ---------------------------------- | ------ |
| 1       | haystack = "hello", needle = "ll"  | 2      |
| 2       | haystack = "aaaaa", needle = "bba" | -1     |
| 3       | haystack = "", needle = ""         | 0      |

### 나의 풀이

```js
var strStr = function (haystack, needle) {
  if (needle.length === 0) {
    return 0;
  }

  let splitArr = haystack.split('');
  for (let i = 0; i < splitArr.length; i++) {
    if (splitArr[i] === needle[0]) {
      let word = splitArr.slice(i, i + needle.length).join('');
      if (word === needle) {
        return i;
      }
    }
  }

  return -1;
};
```
