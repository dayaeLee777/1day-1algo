# Codility Triangle
### [문제 바로가기](https://app.codility.com/programmers/lessons/6-sorting/triangle/)

### 💡 구현 아이디어
---
주어진 배열에서 3개의 값을 뽑아 삼각형을 만들 수 있으면 1을 return하고 삼각형을 만들 수 없다면 0을 return한다.
삼각형을 만들 수 있는 조건은 아래와 같다.
    A[P] + A[Q] > A[R],
    A[Q] + A[R] > A[P],
    A[R] + A[P] > A[Q].
1. 배열을 정렬한다.
2. 연속된 3개의 값을 뽑아 위 조건에 만족하는지 확인한다.
3. 참이면 1을 return한다.
4. for문이 종료되면 0을 return한다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
각 요소의 합이 int타입의 범위를 넘을 수 있으므로 P, Q, R은 long타입으로 선언한다.
시간 복잡도 `O(N*log(N))`이다.

