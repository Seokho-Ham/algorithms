### **문제**

- You are climbing a staircase. It takes n steps to reach the top.
- Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

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

```java
class Solution {
    public int climbStairs(int n) {
        int[] m = new int[n+1];
        m[0] = 1;
        m[1] = 1;
        for(int i=2; i<=n; i++){
            m[i] = m[i-1] + m[i-2];
        }
        return m[n];
    }
}

//수도코드
//4의 경우 2의 경우의 수  + 3의 경우의 수다.
//즉, 자신의 앞의 숫자들의 경우의 수를 더한다.
// n = (n-1) + (n-2)
```
