### 문제

> Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.<br>
> The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

### 예시

| Example | Input                                                | Output        |
| ------- | ---------------------------------------------------- | ------------- |
| 1       | nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 | [1,2,2,3,5,6] |
| 2       | nums1 = [1], m = 1, nums2 = [], n = 0                | [1]           |

### 나의 풀이

```js
var merge = function (nums1, m, nums2, n) {
  let point1 = m - 1;
  let point2 = n - 1;
  while (point2 >= 0) {
    if (nums1[point1] > nums2[point2]) {
      point1--;
    } else {
      if (point1 + 1 > m) {
        nums1[point1 + 1] = nums2[point2];
      } else {
        nums1.splice(point1 + 1, 0, nums2[point2]);
        nums1.pop();
      }
      point2--;
    }
  }
};
```
