# LeetCode Valid Palindrome
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/)

### 💡 구현 아이디어
---
1. s의 각 char를 확인, 앞뒤로 같은지 확인
    - 알파벳 또는 숫자일때만 StringBuilder에 append한다.
    - 새로 생긴 문자열의 앞뒤가 같은지 확인

2. 정규식, StirngBuffer 사용
    - 정규식 `[^A-Za-z0-9]`을 사용하여 알파벳 또는 숫자남 남김
    - `StringBuffer`의 `reverse`를 적용하여 문자열을 뒤집음
    - 원래 문자열과 뒤집은 문자열이 같은지 비교
    

<br/>

### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  5ms | 69.18% | 44.3B | 37.18% | 
|  847ms | 15.40% | 46.8MB | 27.12% |  <br/><br/>


### ✏️ 마치며
---
코드상으로는 정규식과 StringBuffer를 적용한 코드가 간결해보인다. <br/>
하지만 String 을 처리하는 과정에서 속도가 확연하게 증가한다.

