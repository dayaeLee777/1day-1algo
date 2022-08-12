# Codility NumberSolitaire
### [문제 바로가기](https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/)

### 💡 구현 아이디어
--- 
주어진 배열(0 ~ N-1)에는 조약돌의 숫자가 적혀있다.
1~6까지 적힌 주사위를 돌려 나온 숫자 만큼 이동하며 해당 칸에 있는 조약돌을 가진다.
0에서부터 출발하며 N-1에 도달했을 때 최대로 가질 수 있는 조약돌의 갯수를 구하는 것이다. <br/><br/>
아래와 같이 값이 주어진다고 가정한다.
| A[0] | A[1] | A[2] | A[3] | A[4] | A[5] |
| ------ | ------ | ------ | ------ | ------ | ------ |
|  1 | -1 | 0 | 9 | -1 | -2 |

예로, 3에 도달할 수 있는 방법은 아래와 같다.
1. 0 -> +1(1) -> +1(2) -> +1(3) => 9
2. 0 -> +2(2) -> +1(3) => 10
3. 0 -> +1(1) -> +2(3) => 9

따라서 3에 도달시 최대로 가질 수 있는 조약돌의 개수는 10이 된다.

이와 같이 이 문제는 dp[n]은 MAX(dp[n-d] + A[n](1 <= d <= 6)) 의 규칙을 갖는다. 이러한 규칙을 적용하여 풀이하는 것이 다이나믹 프로그래밍이다.

### 💡 구현 방법
1. n번째 위치에 있을 때 갖을 수 있는 최대의 조약돌의 수를 담은 배열 dp 초기화
2. 반드시 0에서 출발하며 0은 주사위로 이동할 수 없기 때문에 `dp[0] = A[0]`이 됨
3. for문을 반복(1 <= n < A.length)하며 `pre` 변수에 `dp[n-1] + A[n]` 값을 초기화해준다.(주사위가 1이 나왔을 때의 조약돌 개수)<br/> 
`pre변수` : 주사위의 크기만큼 반복하며 해당위치에서 갖을 수 있는 최대의 조약돌의 수를 나타낸디.
4. 주사위가 2~6의 값으로 이동했을 때의 값을 구한다.<br/> 
`dp[n-d] + A[n]`
5. 주사위 1~6의 값으로 이동한 모든값을 구해 그중 최대값을 `dp[n]`에 넣는다.
<br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness | Performance |
| ------ | ------ | ------ |
|  100% | 100% | 100% | 

 <br/><br/>


### ✏️ 마치며
---
시간복잡도 `O(N)` <br/>
DP 허접이라고 생각했었는데 몇 문제 풀어보고 문제에 대한 이해를 바탕으로 규칙성을 차분히 찾다보니 생각보다 쉽게 문제를 해결할 수 있었다.(뿌듯.. 어제의 나보다 성장했어..😎) <br/>
오늘의 깨달음 : 대부분의 DP 문제는 주어진 규칙 내에서 MAX, MIN을 구하는 문제가 많은 것 같다.(아마도..?)