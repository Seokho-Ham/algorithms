##### **문제**

> Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
> <br>
> Notice that the solution set must not contain duplicate triplets.

##### **Example 1:**

> Input: nums = [-1,0,1,2,-1,-4] <br>
> Output: [[-1,-1,2],[-1,0,1]]

##### **Example 2:**

> Input: nums = [] <br>
> Output: []

##### **Example 3:**

> Input: nums = [0] <br>
> Output: []

##### **나의 풀이**

```js
var threeSum = function (nums) {
  let sortedArray = nums.sort((a, b) => a - b);
  let answer = [];
  for (let i = 0; i < sortedArray.length; i++) {
    let num = sortedArray[i];

    for (let k = i + 1; k < sortedArray.length; k++) {
      for (let j = k + 1; j < sortedArray.length; j++) {
        if (num + sortedArray[k] + sortedArray[j] === 0) {
          answer.push([num, sortedArray[k], sortedArray[j]]);
        }
      }
    }
  }

  //걸러내는 작업을 다시 해보자.
  for (let i = 0; i < answer.length; i++) {
    for (let j = i + 1; j < answer.length; j++) {
      let count = 0;
      for (let k = 0; k < answer[i].length; k++) {
        if (answer[i][k] === answer[j][k]) {
          count++;
        }
      }
      if (count === 3) {
        answer[j] = -1;
      }
    }
  }

  return answer.filter(el => Array.isArray(el) === true);
};
```

1. 먼저 파라미터로 들어온 배열을 정렬한 후 3중 반복문을 돌려 합이 0이 되는 숫자들을 배열형태로 만들었다.
2. 중복되는 배열을 걸러내기 위해 다시한번 3중 반복문을 사용했다. -> 여기서 시간초과가 발생하는것 같다.

- 포인터를 사용해서 푸는 문제라는데 아직 해결책을 못찾았다.

테스트 케이스에서 실패.. 내일 다시 풀어보는 걸로.
