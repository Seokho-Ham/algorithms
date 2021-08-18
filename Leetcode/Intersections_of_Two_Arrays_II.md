### 문제

---

- 2개의 배열을 인자로 받아 중복된 값들을 중복된 개수만큼 새로운 배열에 담아서 반환한다.

<br>

### 예시

---

Example 1:

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
```

Example 2:

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
```

<br>

### 나의 풀이

---

2가지 방식을 사용해서 풀었다.

###### 1. 2개의 배열을 복사하여 더 긴 배열을 반복문을 돌렸다.

- 다른 한쪽의 배열에서 해당 값을 포함하고 있으면 결과값 배열에 push후 기존의 값은 delete를 통해 삭제했다.

```js
var intersect = function (nums1, nums2) {
  let result = [];
  let n1 = nums1.slice();
  let n2 = nums2.slice();
  if (nums1.length > nums2.length) {
    n1 = nums2.slice();
    n2 = nums1.slice();
  }

  for (let i = 0; i < n1.length; i++) {
    if (n2.includes(n1[i])) {
      result.push(n1[i]);
      delete n2[n2.indexOf(n1[i])];
    }
  }
  return result;
};
```

###### 2. 인자로 들어온 배열을 sort메서드로 정렬한 후 포인터를 사용하였다.

- 2개의 point를 두고 값이 같으면 결과값에 push
- 값을 비교하여 작은쪽의 point를 하나씩 늘려가며 비교했다.

```js
var intersect = function (nums1, nums2) {
  nums1 = nums1.sort((a, b) => a - b);
  nums2 = nums2.sort((a, b) => a - b);
  const result = [];
  let point1 = 0,
    point2 = 0;
  while (point1 < nums1.length && point2 < nums2.length) {
    if (nums1[point1] === nums2[point2]) {
      result.push(nums1[point1]);
      point1++;
      point2++;
    } else if (nums1[point1] > nums2[point2]) {
      point2++;
    } else if (nums1[point1] < nums2[point2]) {
      point1++;
    }
  }
  return result;
};
```
