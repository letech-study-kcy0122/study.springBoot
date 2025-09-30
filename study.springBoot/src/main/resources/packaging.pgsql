kr.letech.study.springBoot
 ├── Application.java
 │
 ├── common                   ← 공용 모듈 (여기서 말하는 cmmn 대체)
 │    ├── config               ← 설정 (RestConfig 등)
 │    ├── envelope             ← 응답 템플릿, 예외 Wrapper
 │    ├── exception            ← 글로벌 예외 핸들러, ProblemDetail
 │    ├── util                 ← AES256Util 같은 범용 유틸
 │    │
 │    ├── code                 ← 공통 코드 관리
 │    │    ├── controller
 │    │    ├── entity
 │    │    ├── repository
 │    │    ├── service
 │    │    │    └── impl
 │    │    └── dto
 │    │
 │    └── file                 ← 파일 업로드/다운로드 공통 모듈
 │         ├── controller
 │         ├── entity
 │         ├── repository
 │         ├── service
 │         │    └── impl
 │         └── dto
 │
 ├── user
 │    ├── controller
 │    ├── entity
 │    ├── repository
 │    ├── service
 │    │    └── impl
 │    └── dto
 │
 ├── role
 │    ├── controller
 │    ├── entity
 │    ├── repository
 │    ├── service
 │    │    └── impl
 │    └── dto
 │
 ├── board                     ← 새 도메인 생기면 이렇게 추가
 │    ├── controller
 │    ├── entity
 │    ├── repository
 │    ├── service
 │    │    └── impl
 │    └── dto
 │
 └── sample01                   ← 샘플 기능 (실서비스엔 삭제 예정)
      ├── controller
      ├── entity
      ├── repository
      ├── service
      │    └── impl
      └── dto

      
      
      
      