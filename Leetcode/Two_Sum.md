### 문제

---

- nums라는 배열과 target 이라는 숫자를 인자로 받는다.
- nums에서 2개의 값을 더해서 target값이 되는 elements들의 index값을 담은 배열을 반환해라.

<br>

### 예시

---

```
//Ex1
Input: nums = [2, 7, 13, 15], target = 9;
Output: [0, 1];
//Ex2
Input: nums = [3, 2, 4], target = 6;
Output: [1, 2];
```

<br>

##### 나의 풀이 :

---

- 첫번째 방식은 2차원 배열을 사용했다.

```js
var twoSum = function (nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        return [i, j];
      }
    }
  }
};
```

- 두번째 방식은 추가 제한사항에 시간복잡도를 O(n^2)이하로 만들어보라는 조건이 있어서 hash의 개념을 사용해서 풀었다.

```js
var twoSum = function (nums, target) {
  let obj = {};
  for (let i = 0; i < nums.length; i++) {
    if (obj[target - nums[i]] !== undefined) {
      return [obj[target - nums[i]], i];
    }
    obj[nums[i]] = i;
  }
};
```
