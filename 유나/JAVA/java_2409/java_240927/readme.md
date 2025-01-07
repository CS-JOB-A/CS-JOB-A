# 15. 컬렉션 자료구조
# 15.1 컬렉션 프로엠 워크
- 컬렉션 프레임워크
  - 자료구조를 바탕으로 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록 인터페이스와 클래스들을 java.util 패키지에 초함
  - List, Set, Map이 주요 인터페이스

![img.png](img.png)

- List와 Set은 객체를 추가, 삭제, 검색하는 방법에 공통 메서드만 모아 Collection 인터페이스로 정의해두고 이것을 상속
- Map은 키와 값을 하나의 쌍으로 묶어서 관리하는 구조
- Collection
  - List
    - 순서를 유지하고 저장, 중복 저장 가능
    - 구현클래스 : ArrayList, Vector, LinkedList
  - Set
    - 순서를 유지하지 않고 저장, 중복 저장 안됨
    - 구현 클래스 : HashSet, TreeSet
- Map
  - 키와 값으로 구성된 엔트리 저장, 키는 중복 저장 안됨
  - HashMap, HashTable, TreeMap, Properties