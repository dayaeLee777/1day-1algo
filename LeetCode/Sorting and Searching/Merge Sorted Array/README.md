# Merge Sorted Array
### [문제 바로가기](https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/)

### 💡 구현 아이디어
---
투 포인터 <br/>
정렬된 두 개의 배열을 정렬된 하나의 배열로 만들어야한다.
nums1 배열에 결과를 담아야하기 때문에 마지막 인덱스부터 두 수를 비교하며 nums1 배열에 값을 넣는다. 

1. n과 m이 모두 0보다 크면, `nums1`가 `nums2`의 마지막 인덱스부터 비교한다.
2. 더 큰 값은 `nums1[n+m-1]`에 대입하고 해당 배열의 인덱스를 나타내는 `n` 또는 `m`은 1을 뺀다.
3. 1번 while문을 벗어나서도, 만약 n이 0보다 크면  `n>0`인 동안 반복하며 `nums1[n-1]`의 값에 값으 넣는다.
4. `m > 0` 이면 이미 적절한 위치의 nums1 배열에 값이 들어가있기 때문에 고려하지 않아도 된다.   <br/><br/>


### ⛳️ 실행결과
---
| Runtime | Runtime Beats | Memory Usage | Memory Usage Beats |
| ------ | ------ | ------ | ------ |
|  0ms | 100.00% | 43MB | 36.75% | <br/><br/>


### ✏️ 마치며
---
투 포인터를 적용하여 시간복잡도 O(N+M)의 결과를 얻을 수 있다.
