### 문제 설명

> 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
> <br>
> 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
> array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
> <br>
> 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
> <br>
> 2에서 나온 배열의 3번째 숫자는 5입니다.
> <br>
> 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한사항

> 1. array의 길이는 1 이상 100 이하입니다.
>    <br>
> 2. array의 각 원소는 1 이상 100 이하입니다.
>    <br>
> 3. commands의 길이는 1 이상 50 이하입니다.
>    <br>
> 4. commands의 각 원소는 길이가 3입니다.

### 나의 풀이

```js
function solution(array, commands) {
  var answer = [];

  function helper(command, arr) {
    const [i, j, k] = command;
    //slice메서드의 첫번째 인자는 시작점을 의미하기 때문에 -1을 해줬다.
    //배열의 인덱스는 0부터 시작하기 때문에 실제로 k번째 자리의 값을 구하기 위해서는 -1을 해주어야 한다.
    return arr.slice(i - 1, j).sort((a, b) => a - b)[k - 1];
  }
  commands.forEach(el => {
    answer.push(helper(el, array));
  });
  return answer;
}
```

- 인자로 2개의 배열을 갖는 helper 함수를 만들었다.
- 첫번째 인자는 인덱스가 들어있는 배열, 두번째는 전체 엘리먼트가 들어있는 배열.
- 리턴값으로는 i와 j값을 기준으로 전체 배열에서 slice함수를 사용하여 요구하는 부분을 잘라냈고 순서대로 정렬하여 요구하는 위치의 값을 반환한다.
