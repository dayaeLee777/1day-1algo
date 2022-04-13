# Programmers 로또의 최고 순위와 최저 순위
### [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/77484)
난이도 : Lv1 

### 💡 구현 아이디어
---
lottos, win_num의 이중 for문을 돌며 조건에 해당할 때 count_zero, count_match 를 더한다. <br/>

#### 구현
1. lottos 배열 중 0이 있다면 count_zero에 1을 더함
2. lottos 배열에 있는 값과 win_nums 배열에 있는 값이 같다면 count_match에 1을 더함</br> <br/><br/>


### ✏️ 마치며
---
map를 적용하여 lottos에 있는 값이 win_nums 배열에 있는지 확인하는 과정을 거친다면 시간복잡도가 줄어들 것 같다. <br/>
