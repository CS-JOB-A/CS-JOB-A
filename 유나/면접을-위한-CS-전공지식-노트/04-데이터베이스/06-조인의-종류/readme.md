# 4.6 조인(join)의 종류
- 조인 : 하나의 테이블이 아닌 두 개 이상의 테이블을 묶어서 하나의 결과물을 만드는 것을 말함
  - MySQL -> JOIN / MongoDB -> lookup 쿼리로 처리
  - MongoDB의 lookup은 되도록 사용 X -> 관계형 데이터베이스보다 성능이 떨어진다고 알려져 있음
  - 관계형 데이터베이스가 조인 작업에 더 적합
- 내부 조인(inner join) : 왼쪽 테이블과 오른쩍 테이블의 두 행이 모두 일치하는 행이 있는 부분만 표기
- 왼쪽 조인(outer join) : 왼쪽 테이블의 모든 행이 결과 테이블에 표기
- 오른쪽조인(outer join) : 오른쪽 테이블의 모든 행이 결과 테이블에 표기
- 합집합 조인(full outer join) : 두 개의 테이블을 기반으로 조인 조건에 만족하지 않는 행까지 모두 표기

# 4.6.1 내부 조인(inner join)
- 두 테이블 간에 교집합을 나타냄

```sql
SELECT * From TableA A
INNER JOIN TableB ON
A.key = B.key
```

# 4.6.2 왼쪽 조인(outer join)
- 테이블 B의 일치하는 부분의 레코드와 함께 A를 기준으로 완전한 레크드 집합을 생성
- 테이블 B에 일치하는 항목이 없으면 해당 값은 null 값이 됨

```sql
SELECT * From TableA A
LEFT JOIN JOIN TableB ON
A.key = B.key
```

# 4.6.3 오른쪽조인(outer join)
- 테이블 A의 일치하는 부분의 레코드와 함께 B를 기준으로 완전한 레크드 집합을 생성
- 테이블 A에 일치하는 항목이 없으면 해당 값은 null 값이 됨

```sql
SELECT * From TableA A
RIGHT JOIN JOIN TableB ON
A.key = B.key
```

# 4.6.4 합집합 조인(full outer join)
- 양쪽 테이블에서 일치하는 레크드와 함께 테이블 A와 테이블 B의 모든 레코드 집합을 생성
- 일치하는 항목이 없으면 누락된 쪽에 null 값이 포함되어 출력

```sql
SELECT * From TableA A
OUTER JOIN TableB ON
A.key = B.key
```