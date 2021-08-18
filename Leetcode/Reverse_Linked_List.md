### 문제

> Reverse a singly linked list.

```md example
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

### 나의 풀이

```js
var reverseList = function (head) {
  if (!head) {
    return null;
  }
  let prev = null;
  let cur = head;
  let next = cur.next;

  while (cur) {
    cur.next = prev;
    prev = cur;
    cur = next;
    if (next) {
      next = next.next;
    }
  }
  return prev;
};
```
