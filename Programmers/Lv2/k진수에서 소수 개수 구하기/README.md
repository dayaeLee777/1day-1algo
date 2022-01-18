# Programmers k진수에서 소수 개수 구하기
### [문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/92335)
난이도 : Lv2

### 💡 구현 아이디어
---
1. 입력받은 n을 k진수로 변환하는 과정이 필요
2. P가 조건에 해당하는지 확인(P 사이에 0이 있을 수 없음)</br>
2-1. 0P0</br>
2-2. P0</br>
2-3. 0P</br>
2-4. P</br>
3. P가 소수인지 확인
4. 조건에 맞으면 answer를 1씩 증가


#### 변수 
- sb : n을 k진수로 변환하는 과정에서 사용할 변수(StringBuilder)
- change : k진수로 변환된 문자열 값
- tmp : 변환된 수 안의 P(long 타입)

#### 함수
- is_prime(long num) : 매개변수 num이 소수인지 확인하여 T/F를 반환하는 함수 

#### 구현
1. n을 k진수로 변환
```
while (n >= k) {
        sb.insert(0, n % k);
        n /= k;
    }
    sb.insert(0, n);
```
2. P가 `0P0`, `P0`, `0P`, `P` 조건에 해당하고 소수인지 확인
```
long tmp = 0L; // 변환된 수 안의 P
        for (int i = 0; i < change.length(); i++) {
            // 0을 만나면 P가 소수인지 확인
            // 소수이면 answer에 1을 더해주고 P는 0으로 초기화
            if (change.charAt(i) == '0') {
                if (tmp != 0L && is_prime(tmp)) {
                    answer++;
                }
                tmp = 0L;
                // 0이 아니면 P에 값을 더함
            } else {
                tmp = tmp * 10 + change.charAt(i) - '0';
            }
        }
        // for문을 돌고 난 후에는 '0P'가 존재할 수 있기 때문에 확인 필요
        if (tmp % 10 != 0L && is_prime(tmp))
            answer++;
```
2-1. P가 소수인지 확인
```
private static boolean is_prime(long num) {
        if (num == 1)
            return false;
        // 루트로 소수 구하기
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
```
3. 결과 answer 출력 <br/><br/>


### ✏️ 마치며
---
소수 구하는 방법은 다양하지만 시간초과를 방지하기 위해선 가장 효율적인 방식을 알아두고 있는 것이 좋을 것 같다. 이번 풀이에서 적용한 방법은 해당 숫자의 √N 까지 확인하는 것으로 약수의 중심을 구하는 방법이었다.O(√N)
