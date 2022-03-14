# Codility OddOccurrencesInArray
### [문제 바로가기](https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/)

### 💡 구현 아이디어
---
#### sort 후 같은 숫자의 갯수가 홀수일때 결과값 반환
시간복잡도 : O(N^2) <br/><br/>

#### xor 연산
홀수번만 입력되는 숫자는 xor 연산 후에 남아있게 된다.
시간복잡도 : O(N)

0000 ^ 1001 = 1001
1001 ^ 0011 = 1010
1010 ^ 1001 = 0011
0011 ^ 0011 = 0000
0000 ^ 1001 = 1001
1001 ^ 0111 = 1110
1110 ^ 1001 = 0111

### ⛳️ 실행결과
---
| Task Score | Correctness | Performance |
| ------ | ------ |------ |
|  750% | 100% | 50% |
|  100% | 100% | 100% | <br/><br/>


### ✏️ 마치며
---
sorting 후 같은 수의 갯수를 비교했을 때는 시간복잡도가 O(N^2)이 되어 시간초과가 났다.<br/>
xor 연산은 한번의 for문으로 결과를 도출할 수 있기 때문에 시간복잡도를 O(N) 가진다.
