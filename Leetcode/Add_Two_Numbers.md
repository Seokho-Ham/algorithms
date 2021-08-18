### 문제

> 2개의 양수의 값이 담겨있는 linked list가 주어집니다. 해당 리스트는 값이 역순으로 담겨있습니다.<br>
> 2개의 리스트의 값을 더한 값을 새로운 리스트에 역순으로 담아 결과로 반환해야합니다.<br>
> 아래 예시가 있습니다.

```js
l1 = [2, 4, 3];
l2 = [5, 6, 4];
//342 + 465= 807
output = [7, 0, 8];
```

### 나의 풀이

1. 결과값으로 사용할 새로운 list node를 result라는 변수에 담았습니다.

- cur : 현재 가리키는 list node
- num1 : 더하기를 한 후 10을 넘어가면 10의자리 값을 저장하는 변수

2. while문을 사용해 list의 next값이 존재하지 않을때까지 반복작업을 하도록 했습니다.
3. 각 value 값을 더한 결과를 sum이라는 변수에 담습니다. 이때 Math.floor 함수를 사용해 정수값만 할당했습니다.
   이후 sum값이 10을 넘어갈경우, 1의 자리는 현재 노드의 value값으로 저장하고 10의 자리는 num1변수에 저장합니다.
4. 주어진 리스트들에서 다음 리스트 노드가 존재할 경우에만 cur.next값에 새로운 리스트 노드를 생성했습니다.

```js
var addTwoNumbers = function (l1, l2) {
  //(1)
  let result = new ListNode();
  let cur = result;
  let num1 = 0;

  //(2)
  while (l1 || l2 || num1) {
    //(3)
    let sum = Math.floor((l1 ? l1.val : 0) + (l2 ? l2.val : 0) + num1);
    cur.val = sum >= 10 ? sum % 10 : sum;
    num1 = sum >= 10 ? sum / 10 : 0;
    //(4)
    if ((l1 && l1.next) || (l2 && l2.next) || num1) cur.next = new ListNode();
    cur = cur.next;
    if (l1) l1 = l1.next;
    if (l2) l2 = l2.next;
  }
  return result;
};
```
