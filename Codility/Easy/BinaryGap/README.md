# Codility BinaryGap
### [문제 바로가기](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/)

### 💡 구현 아이디어
---
숫자 N을 이진수로 변환하였을 때, 1로 둘러싸인 0의 길이가 가장 긴 것을 찾아야한다. <br/>

1. N을 이진수로 변환하여 `StringBuilder` 에 저장
2. 1로 시작하는 시퀀스라면 인덱스를 이동하며 0이 존재할 때마다 `zero`에 1을 더함
3. 1로 종료되면, 현재 zero 시퀀스의 길이가 가장 긴 시퀀스인지 확인
4. 결과값 반환 <br/><br/>


### ⛳️ 실행결과
---
| Task Score | Correctness |
| ------ | ------ |
|  100% | 100% | <br/><br/>


### ✏️ 마치며
---
십진수를 이진수로 변환하는 로직을 적용하여 쉽게 풀 수 있었던 문제였다.
하지만, 이진수를 핸들링할 때 StringBuilder 를 적용했는데 이를 더 효율적인 방식으로 적용할 수 있는지 찾아봐야겠다.
