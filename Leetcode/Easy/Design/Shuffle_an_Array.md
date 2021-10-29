### **문제**

> Given an integer array nums, design an algorithm to randomly shuffle the array.<br>
> Implement the Solution class:
>
> - Solution(int[] nums) Initializes the object with the integer array nums.
> - int[] reset() Resets the array to its original configuration and returns it.
> - int[] shuffle() Returns a random shuffling of the array.

### **예시**

```md
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle(); // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset(); // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle(); // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
```

### **나의 풀이**

```js
var Solution = function (nums) {
  this.nums = nums;
};

/**
 * Resets the array to its original configuration and return it.
 * @return {number[]}
 */
Solution.prototype.reset = function () {
  return this.nums.sort();
};

/**
 * Returns a random shuffling of the array.
 * @return {number[]}
 */
Solution.prototype.shuffle = function () {
  for (let i = this.nums.length - 1; i >= 0; i--) {
    let random = Math.floor(Math.random() * (i + 1));
    let tmp = this.nums[i];
    this.nums[i] = this.nums[random];
    this.nums[random] = tmp;
  }
  return this.nums;
};
```
