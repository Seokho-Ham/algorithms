### 문제

---

- 각 stock의 가격이 담긴 prices 배열을 인자로 받는다.
- 각 날짜는 해당 element의 index다.
- stock을 사고 팔아서 남길수 있는 최대의 이윤을 반환한다.
- stock을 사기전에 반드시 팔아야하며, 같은 날에 사고 파는게 가능하다.

<br/>

### 예시

---

Example 1

```js
Input: prices = [7, 1, 5, 3, 6, 4];
Output: 7;
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```

Example 2

```js
Input: prices = [1, 2, 3, 4, 5];
Output: 4;
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
```

Example 3

```js
Input: prices = [7, 6, 4, 3, 1];
Output: 0;
// Explanation: In this case, no transaction is done, i.e., max profit = 0.
```

<br/>

### 나의 풀이

---
```java
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                result += prices[i+1]-prices[i];
            }
        }
        return result;
    }
}
//수도 코드
//1. 다음 인덱스 값이 현재 값보다 작으면 0, 크면 다음값-현재값을 결과값에 더한다.
```