# LeetCode Valid Anagram
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/)

### 💡 구현 아이디어
---
1. char 배열 2개 & Arrays.sort 적용
    - String을 char 배열로 변환하고 sorting하여 순서대로 비교하며 같지 않으면 fasle를 반환한다.

2. 한 개의 Map 적용
    - 각 알파벳을 map의 key 값에 대응시킨다.
    - s에 속하는 알파벳은 map의 value를 1씩 증가시킨다.
    - t에 속하는 알파벳은 map의 value를 1씩 감소시킨다.
    
3. 한 개의 int 배열 적용
    - 알파벳 갯수만큼 int 배열을 생성한다.
    - s에 속하는 알파벳은 해당 배열의 값에 1씩 증가시킨다.
    - t에 속하는 알파벳은 해당 배열의 값에 1씩 감소시킨다.

<br/>

### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  6ms | 54.83% | 44.9B | 32.43% | 
|  23ms | 17.000% | 43.8MB | 51.30% |
|  6ms | 54.83% | 42.8B | 77.18% |  <br/><br/>


### ✏️ 마치며
---
속도나 메모리 측면에서 3번째 방식이 가장 효율적임을 알 수 있다!
