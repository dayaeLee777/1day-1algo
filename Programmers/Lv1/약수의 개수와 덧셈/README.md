# Programmers 약수의 개수와 덧셈
### [문제 바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/77884)
난이도 : Lv1 

<br/>

### 💡 아이디어 및 구현
---
Left~Right까지 for문을 돌며 각 i에 대한 약수의 개수를 구한다.

1. i를 Index로 나누었을 때 나머지가 0이면 약수이다.
2. Index는 i~1까지 확인한다.
3. 약수의 개수가 짝수이면 결과값에 더하고, 홀수이면 결과값에서 뺀다. 
<br/><br/>


### ✏️ 마치며
---
값을 하나씩 확인하는 방법으로 구현했다. <br/>
