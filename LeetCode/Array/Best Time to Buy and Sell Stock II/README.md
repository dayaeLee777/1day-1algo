# LeetCode Best Time to Buy and Sell Stock II
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/)

### 💡 구현 아이디어
---
`prices` 배열에 일일단위 주가가 주어지고 최대 이익을 얻을 수 있는 매입, 매도 시기를 정하여 최대 이익을 반환한다.

|                              [7,1,5,3,6,4] 배열의 최대이익                           |
| :------------------------------------------------------------------------------: |
| ![IMG_0051](https://user-images.githubusercontent.com/8343301/158069080-322a99f2-2ef2-4863-a15a-337d011f3311.jpg) |

그림과 같이, 직전일보다 다음날의 주가가 높은 날에 대해 그 차이값을 누적하면 결과적으로 최대이익을 구할 수 있다.<br/>
1. `maxprofit`을 0으로 초기화
2. 1부터 `prices` 길이만큼 반복 
3. 다음날 주가가 직전일 주가보다 높으면 `maxprofit`에 차이값을 더함 <br/><br/>


### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  1ms | 88.05% | 44.3 MB | 31.03% | <br/><br/>


### ✏️ 마치며
---
LeetCode Solution에도 나와있는 Single Pass 를 적용한 방법이다. 복잡도를 보자면, 시간복잡도 O(n), 공간복잡도 O(1)이다. 그래프를 직접 그려보니 쉽게 이해할 수 있었다.
