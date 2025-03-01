# 로또 게임

## 기능 요구 
---

### 프로그램 목표

>사용자가 구매한 로또를 통한 당첨 내역 및 수익률 출력


## **기능 동작 사항**
---
1. 로또 구입 **금액 입력**
2. 구입 금액에 해당하는 만큼 로또 발행
   - 로또 1장 = 1,000원
3. 당첨 번호 입력
    - 번호는 1~45 사이의 숫자
4. 구매한 로또 번호와 당첨 번호 비교
5. 당첨 내역 및 수익률 출력
6. 로또 게임 종료


### 금액
```
1등 : 6개 번호 일치 / 2,000,000,000원
2등 : 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등 : 5개 번호 일치 / 1,500,000원
4등 : 4개 번호 일치 / 50,000원
5등 : 3개 번호 일치 / 5,000원
```


## **예외 처리**
---
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 예외 처리

### **출력 형식**
>출력형식 : [ERROR] ...


## **입출력 요구 사항**
---
### **입력**

+ **로또 입력**
  + 1,000원 단위로 입력
  + 1,000 단위로 나눠 떨어지지 않으면 **예외 처리**
+ **당청 번호 입력**
  + 쉼포(,)를 기준으로 구분
+ **보너스 번호 입력**
  + 번호 입력

### **출력**
+ **구매 내역 출력**
  + 로또 수량 및 번호 출력
  + 단, 각 로또는 *오름차순 정렬*
  ```
    8개를 구매했습니다.
  [8, 21, 23, 41, 42, 43] 
  [3, 5, 11, 16, 32, 38] 
  [7, 11, 16, 35, 36, 44] 
  [1, 8, 11, 31, 41, 42] 
  [13, 14, 16, 38, 42, 45] 
  [7, 11, 30, 40, 42, 43] 
  [2, 13, 22, 32, 38, 45] 
  [1, 3, 5, 14, 22, 45]
  ```
+ **당첨 내역 출력**
  ```
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ``` 
+ **수익률 출력**
  + 소수점 둘째 자리에서 반올림
  ```
  총 수익률은 62.5%
  ```

### 최종 출력 결과물 형식
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## 게임 외 요구 사항
---
- 프로그램 시작점 : `Application`의 `main()`
- indent depth 2까지만 허용
- 3항 연산자 쓰지 않느다.
- 함수의 길이 15라인 넘어가지 않도록 구현
- else 예약어를 쓰지 않는다.
- Java Enum을 적용한다
- 단위 테스트를 구현해야 한다.

### Lotto 클래스
- 제공된 `Lotto` 클래스 활용 구현
- `Lotto`에 매개 변수가 없는 생성자 추가 불가
- `numbers`의 접근자 private 접근 불가
- `Lott`o에 필드를 추가 불가
- `Lotto` 패캐지 변경 가능

## 필요 기능 목록
---
- [X] 로또 구입 금액 및 갯수 입출력 함수
- [x] 구입 금액에 해당하는 만큼 로또 발행 함수
- [X] 당첨 번호 입출력 함수
- [x] 보너스 번호 입출력 함수
- [X] 구매한 로또 번호와 당첨 번호 비교 함수
- [x] 당첨 내역 및 수익률 출력 
- [X] 로또 게임 종료


### **예외 기능 목록**
- [X] 입력 금액의 숫자 이외의 값 처리 추가
- [X] 빈 문자열 입력 예외 처리 추가
- [x] 최소단위 (1,000)원으로 나눠 떨어지지 않는 예외 처리 추가
- [x] 로또 선택 가능 숫자 범위 예외 처리 추가
- [x] 로또 자동 선택 갯수 예외 처리 추가  
- [X] 로또 당첨 번호 자체 중복 여부 확인
- [x] 보너스 번호 입력 예외 처리