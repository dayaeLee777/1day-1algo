# Maximum Depth of Binary Tree
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/)

### 💡 구현 아이디어
---
재귀함수 적용 <br/>
현재 노드의 max 값은 왼쪽 자식과 오른쪽 자식 중 큰 값에 1을 더한 것이다.

1. `root`가 `null` 이면 0 을 반환한다
2. 현재 노드의 최대깊이는 왼쪽 자식의 최대깊이와 오른쪽 자식의 최대깊이 중 큰 값에 1을 더함 <br/><br/>


### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  0ms | 100.00% | 43MB | 47.19% | <br/><br/>


### ✏️ 마치며
---
재귀함수를 적용하여 O(N)의 결과를 얻을 수 있다.
