## 항해99 취업 리부트 역량 평가 

### 패키지 구성 

```
com.spartaweb
├── api
│   └── item
│       ├── controller      # Item 관련 API 컨트롤러 클래스
│       │   └── dto         # Item 요청 및 응답 데이터 전송 객체(DTO)
│       └── service         # Item 관련 비즈니스 로직 클래스
└── domain
    └── item                # Item 관련 엔티티 클래스 (entity와 repository 위치)
```

### 그 외 

- JPA 사용하여 구현
- Item 테이블의 deleted 칼럼 만들어 true/false 형태로 삭제처리 관리
