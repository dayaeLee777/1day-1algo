# Codility CountDiv
### [문제 바로가기](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)

### 💡 구현 아이디어
--- 
A ~ B까지 숫자 중에 K로 나눌 수 있는 숫자의 갯수를 구해야하기 때문에 1 ~ A까지 K로 나눌 수 있는 갯수를 구하고 1 ~ B까지 숫자 중 K로 나눌 수 있는 갯수를 구하여 그 차이를 구하면 결과값이 된다. 다만, A가 K로 나누어 떨어질 경우에는 결과값에 1을 더한다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
위 방법으로 풀 경우 시간복잡도는 `O(1)`. <br/>
A ~ B까지 K로 나눌 수 있는지를 하나씩 확인한다면 시간초과. 