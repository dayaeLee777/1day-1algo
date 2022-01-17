# Programmers 신고 결과 받기
### [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/92334)
난이도 : Lv1 

### 💡 구현 아이디어
---
신고한 사람과 신고당한 사람을 담을 자료구조가 필요하다. <br/>
중복을 방지하기 위해 `HashMap`을 사용했다. <br/>
또한, 신고한 사람은 본인이 신고한 사람의 집합도 가지고 있어야하기 때문에 이를 저장하기 위해 `Set` 자료구조를 사용했다.</br>

#### 변수 
- reporter : 입력받은 report 중 신고를 한 유저
- singo : 입력받은 report 중 신고를 당한 유저
- reporterArr : 신고한 사람을 저장하는 HashMap
    - key : 신고를 한 유저(String)
    - value : key가 신고한 유저들의 집합(set)
- singoArr : 신고당한 사람을 저장하는 HashMap 
    - key : 신고당한 유저(String)
    - value : key가 신고당한 횟수(int)
- answer : 결과값을 나타내는 1차원 배열

#### 구현
1. id_list 배열에 따라 `reporterArr`, `singoArr` 초기화
2-1. `reporterArr`에 `reporter`-`singo` set이 존재하면 이미 신고한 사람이 있는 것이므로 continue
2-2. 존재하지 않으면 신고당한 사람의 카운트가 증가해야 하기 때문에 `singoArr`에 `singo`에 해당하는 value값에 1을 더함
3. singoArr에서 신고당한 횟수가 K보다 작으면 해당 `singo`는 `reporterArr`에서 제거
4. `id_list`에 해당하는 `reporterArr`의 갯수를 `answer`에 저장  <br/><br/>


### ✏️ 마치며
---
HashMap, Set의 특성을 이해하여 적합한 문제에 적용할 수 있는 능력을 향상해야할 것 같다. 
처음에 이중for문만 돌리고.. 문제의 특성에 맞는 자료구조를 생각해내지 못해 시간낭비(?)를 했다. 
또한, 각 자료구조가 가지고있는 메소드를 정확히 알고 IDE없이 코드를 작성하는 연습을 많이 해야할 것 같다!
