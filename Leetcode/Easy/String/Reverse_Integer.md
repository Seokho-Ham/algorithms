### 문제

---

- Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.<br>
- Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

### 예시

---

| Example | Input    | Output |
| ------- | -------- | ------ |
| 1       | x = 123  | 321    |
| 2       | x = -123 | -321   |
| 3       | x = 120  | 21     |
| 4       | x = 0    | 0      |

### 나의 풀이

---

```java
class Solution {
    public int reverse(int x) {
        try {
            int num = Math.abs(x);
            String[] str = String.valueOf(num).split("");
            String result = "";

            if (x < 0) {
                result += "-";
            }
            for (int i = str.length - 1; i >= 0; i--) {
                result += str[i];
            }
            return Integer.valueOf(result);

        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
```

### 다른 사람들 풀이

---
```java

 class Solution {
     public int reverse(int x) {
         int res = 0;
         while (x != 0) {
             int tmp = res * 10 + x % 10;
             if ((tmp - x % 10) / 10 != res) return 0;

             res = tmp;
             x = x / 10;
         }
         return res;
     }
 }
```
