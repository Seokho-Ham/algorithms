## **Climbing Stairs**

### **문제**

> You are climbing a staircase. It takes n steps to reach the top.
> Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

<!-- more -->

### **예시**

```md
(1)
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps

(2)
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

### **나의 풀이**

```js
var climbStairs = function (n) {
  let arr = new Array(n + 1);
  for (let i = 0; i < arr.length; i++) {
    if (i === 0 || i === 1) {
      arr[i] = 1;
    } else {
      arr[i] = arr[i - 1] + arr[i - 2];
    }
  }
  return arr[n];
};
```

---

## **Best Time to Buy and Sell Stock**

### **문제**

> You are given an array prices where prices[i] is the price of a given stock on the ith day.
> You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
> Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

### **예시**

```md
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

### **나의 풀이**

```js
var maxProfit = function (prices) {
  let result = 0;
  let min = prices[0];
  for (let i = 1; i < prices.length; i++) {
    min = prices[i] < min ? prices[i] : min;
    result = prices[i] - min > result ? prices[i] - min : result;
  }
  return result;
};
```

---

## **Maximum Subarray**

### **문제**

> Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

### **예시**

```md
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [1]
Output: 1

Input: nums = [0]
Output: 0

Input: nums = [-1]
Output: -1

Input: nums = [-100000]
Output: -100000
```

### **나의 풀이**

```js
//일반 풀이 방식
var maxSubArray = function (nums) {
  let arr = [];
  for (let i = 0; i < nums.length; i++) {
    let max = [nums[i]];
    for (let j = i + 1; j < nums.length; j++) {
      max.push(max[max.length - 1] + nums[j]);
    }
    arr.push(Math.max(...max));
  }
  return Math.max(...arr);
};

//카데인 알고리즘
var maxSubArray = function (nums) {
  let arr = [nums[0]];
  for (let i = 1; i < nums.length; i++) {
    let sum = arr[arr.length - 1] + nums[i];
    arr.push(nums[i] < sum ? sum : nums[i]);
  }
  return Math.max(...arr);
};
```
