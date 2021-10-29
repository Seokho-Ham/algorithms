### **문제**

- You are given an array prices where prices[i] is the price of a given stock on the ith day.
- You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

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

```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;

        for(int i=1; i<prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
            }
            else if(result < prices[i]-min){
                result = prices[i]-min;
            }
        }
        return result;
    }
}

//수도 코드
//최소값을 둔다.
//최소값보다 현재값이 더 작으면 최소값을 현재값으로 변경한다.
//결과 값은 0으로 초기화한다.
//현재값에서 최소값을 빼서 결과값보다 클 경우 결과값을 바꾼다.
```
