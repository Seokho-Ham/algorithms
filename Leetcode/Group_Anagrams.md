#### 문제

> Given an array of strings strs, group the anagrams together. You can return the answer in any order.<br>
> An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

#### example

```js
// Example 1:
Input: strs = ['eat', 'tea', 'tan', 'ate', 'nat', 'bat'];
Output: [['bat'], ['nat', 'tan'], ['ate', 'eat', 'tea']];

// Example 2:
Input: strs = [''];
Output: [['']];

// Example 3:
Input: strs = ['a'];
Output: [['a']];
```

#### 나의 풀이

```js
var groupAnagrams = function (strs) {
  const obj = {};
  const result = [];
  for (let i = 0; i < strs.length; i++) {
    let word = strs[i].split('').sort().join('');
    if (!obj[word]) {
      obj[word] = new Array(strs[i]);
    } else {
      obj[word].push(strs[i]);
    }
  }
  for (let i in obj) {
    result.push(obj[i]);
  }
  return result;
};
```

1. 빈 객체와 배열을 만들었다.
2. strs의 길이만큼 반복문을 돌렸고 word라는 변수에 각 단어의 알파벳을 정렬해서 저장했다.
3. obj에 word라는 키가 있는지 확인

- 있을 경우 : 순서만 다른 동일한 단어이기 때문에 해당 키의 배열에 push.
- 없을 경우 : 새로운 키를 만들고 값으로 현재 단어를 담은 배열을 넣음.

4. for in 문을 통해 result라는 배열에 객체가 가진 각 배열을 담아서 리턴.
