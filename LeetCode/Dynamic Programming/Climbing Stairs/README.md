# Climbing Stairs
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/)

### 💡 구현 아이디어
---
DP 적용 <br/>
1 또는 2칸씩만 이동하는 전형적인 DP 문제이다.

1. `n < 3` 이면 `dp[n]=n`이다.
2. `n >= 3`이면, `dp[n] = dp[n-1] + dp[n-2]`이다 <br/><br/>


### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  0ms | 100.00% | 40.9MB | 37.22% | <br/><br/>


### ✏️ 마치며
---
DP 적용하여 결과를 찾을 수 있었다. <br/>
복잡한 dp문제는 점화식을 도출하기 어렵게 때문에 많은 연습이 필요할 것 같다.
