### 문제

---

- 주어진 문자열을 뒤집을 것.
- 배열을 추가하지 말것. 추가적인 메모리 사용x.

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
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        
    }
}
```