### 문제

---

- 반복되지 않는 문자의 인덱스 값을 반환하라.
- 없으면 -1을 반환할것.


### 예시

---

```md
Input: s = "leetcode"
Output: 0
```
```md
Input: s = "loveleetcode"
Output: 2
```
```md
Input: s = "aabb"
Output: -1
```


### 나의 풀이

---

```java
class Solution {
    public int firstUniqChar(String s) {
        if(s.length()==1){
            return 0;
        }
        String[] arr = s.split("");
        for(int i=0; i<s.length(); i++){
            if(s.indexOf(arr[i])==s.lastIndexOf(arr[i])){
                return i;
            }
        }
        return -1;
    }
}

```