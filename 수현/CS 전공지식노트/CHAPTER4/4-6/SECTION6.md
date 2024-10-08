# 데이터베이스

## 조인의 종류

- 조인이란 하나의 테이블이 아닌 두 개 이상의 테이블을 묶어서 하나의 결과물을 만드는 것을 말한다
- MYSQL에서는 JOIN이라는 쿼리로, MongoDB에서는 lookup이라는 쿼리로 이를 처리할 수 있다
- 참고로 MongoDB를 사용할 때 lookpup은 되도록 사용하지 말아야 한다
- MongoDB는 조인 연산에 대해 관계형 데이터베이스보다 성능이 떨어진다고 여러 벤치마크 테스트에서 알려져 있다
- 따라서 여러 테이블을 조인하는 작업이 많을 경우 MongoDB보다는 관계형 데이터베이스를 써야한다

![alt text](image.png)

1. 내부 조인(inner join) : 왼쪽 테이블과 오른쪽 테이블의 두 행이 모두 일치하는 행이 있는 부분만 표기
2. 왼쪽 조인(left outer join) : 왼쪽 테이블의 모든 행이 결과 테이블에 표기된다
3. 오른쪽 조인(right outer join) : 오른쪽 테이블의 모든 행이 결과 테이블에 표기된다
4. 합집합 조인(full outer join) : 두 개의 테이블을 기반으로 조인 조건에 만족하지 않는 행까지 모두 표기


### 내부 조인

- 내부 조인은 두 테이블 간에 교집합을 나타낸다
``` SQL
SELECT * FROM TableA A
INNER JOIN TableB B ON
A.key = B.key
```

###  왼쪽 조인

- 왼쪽 조인은 테이블의 B의 일치하는 부분의 레코드와 함께 테이블 A를 기준으로 완전한 레코드 집합을 생성한다
- 만약 테이블 B에 일치하는 항목이 없으면 해당 값은 null 값이 된다
``` SQL
SELECT * FROM TableA A
LEFT JOIN TableB B ON
A.key = B.key
```

### 오른쪽 조인

- 오른쪽 조인은 테이블 A에서 일치하는 부분의 레코드와 함께 테이블 B를 기준으로오나전한 레코드 집합을 생성
- 만약 테이블 A에 일치하는 항목이 없으면 해당 값은 null값이 된다
``` SQL
SELECT * FROM TableA A
RIGHT JOIN TableB B ON
A.key = B.key
```

### 합집합 조인

- 합집합 조인은 양쪽 테이블에서 일치하는 레코드와 함께 테이블 A와 테이블 B의 모든 레코드 집합을 생성한다
- 이때 일치하는 항목이 없으면 누락된 쪽에 null 값이 포함되어 출력된다
``` SQL
SELECT * FROM Table A
FULL OUTER JOIN TableB B ON
A.key = B.key
```