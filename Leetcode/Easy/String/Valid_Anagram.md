### 문제

---

- 두개의 문자열 s,t가 주어진다.
- t가 s의 anagram이면 true, 아니면 false를 반환하라.

### 예시

---

```md
Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

```
```md
Example 2:

Input: s = "rat", t = "car"
Output: false
```



### 나의 풀이

---

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] memory = new int[256];

        for(int i=0; i<s.length(); i++){
            memory[(int)s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); i++){
            memory[(int)t.charAt(i)]--;
        }
        for(int i=0; i<memory.length; i++){
            if(memory[i]!=0){
                return false;
            }
        }
        return true;
    }
}
```