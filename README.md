# study.springBoot
Spring Boot REST API 서버

## study.springBoot.zip 디렉토리 + 파일 계층구조 분석

- ZIP: `study.springBoot.zip`
- 총 디렉토리: 127개
- 총 파일: 116개
- 총 용량(압축 전 기준): 218.19 KB

### 1) 전체 트리 (파일 포함, 파일은 크기 표기)
```text
└── study.springBoot/
    ├── .mvn/
    │   └── wrapper/
    │       └── maven-wrapper.properties (168.0 B)
    ├── .settings/
    │   ├── org.eclipse.core.resources.prefs (155.0 B)
    │   ├── org.eclipse.jdt.core.prefs (494.0 B)
    │   └── org.eclipse.m2e.core.prefs (90.0 B)
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── kr/
    │   │   │       └── letech/
    │   │   │           └── study/
    │   │   │               └── springBoot/
    │   │   │                   ├── cmmn/
    │   │   │                   │   ├── code/
    │   │   │                   │   │   ├── controller/
    │   │   │                   │   │   │   └── RESTCommonCodeController.java (1.56 KB)
    │   │   │                   │   │   ├── entity/
    │   │   │                   │   │   │   └── CommonCodeEntity.java (875.0 B)
    │   │   │                   │   │   ├── repository/
    │   │   │                   │   │   │   └── CommonCodeRepository.java (704.0 B)
    │   │   │                   │   │   └── service/
    │   │   │                   │   │       ├── impl/
    │   │   │                   │   │       │   └── CommonCodeServiceImpl.java (1.25 KB)
    │   │   │                   │   │       └── CommonCodeService.java (487.0 B)
    │   │   │                   │   ├── config/
    │   │   │                   │   │   ├── CORSConfig.java (1013.0 B)
    │   │   │                   │   │   ├── JacksonConfig.java (1.01 KB)
    │   │   │                   │   │   ├── RestConfig.java (574.0 B)
    │   │   │                   │   │   └── SecurityConfig.java (1.43 KB)
    │   │   │                   │   ├── entity/
    │   │   │                   │   │   ├── AbstractCrudService.java (1.25 KB)
    │   │   │                   │   │   ├── BaseEntity.java (1.44 KB)
    │   │   │                   │   │   └── UpdatableEntity.java (561.0 B)
    │   │   │                   │   ├── files/
    │   │   │                   │   │   ├── controller/
    │   │   │                   │   │   │   └── RESTFileController.java (2.12 KB)
    │   │   │                   │   │   ├── entity/
    │   │   │                   │   │   │   ├── FilesEntity.java (1.63 KB)
    │   │   │                   │   │   │   └── FilesId.java (848.0 B)
    │   │   │                   │   │   ├── repository/
    │   │   │                   │   │   │   └── FileRepository.java (2.25 KB)
    │   │   │                   │   │   └── service/
    │   │   │                   │   │       ├── impl/
    │   │   │                   │   │       │   └── FileServiceImpl.java (1.86 KB)
    │   │   │                   │   │       └── FileService.java (544.0 B)
    │   │   │                   │   ├── restTemplate/
    │   │   │                   │   │   ├── envelope/
    │   │   │                   │   │   │   ├── Envelope.java (2.8 KB)
    │   │   │                   │   │   │   └── EnvelopeAdvice.java (2.13 KB)
    │   │   │                   │   │   └── error/
    │   │   │                   │   │       ├── ProblemDetail.java (1.21 KB)
    │   │   │                   │   │       └── ProblemHandler.java (2.24 KB)
    │   │   │                   │   ├── role/
    │   │   │                   │   │   ├── controller/
    │   │   │                   │   │   │   └── RESTUserRoleController.java (2.19 KB)
    │   │   │                   │   │   ├── entity/
    │   │   │                   │   │   │   ├── UserRoleEntity.java (2.22 KB)
    │   │   │                   │   │   │   └── UserRoleId.java (848.0 B)
    │   │   │                   │   │   ├── repository/
    │   │   │                   │   │   │   └── UserRoleRepository.java (2.05 KB)
    │   │   │                   │   │   └── service/
    │   │   │                   │   │       ├── impl/
    │   │   │                   │   │       │   └── UserRoleServiceImpl.java (4.93 KB)
    │   │   │                   │   │       └── UserRoleService.java (832.0 B)
    │   │   │                   │   └── sec/
    │   │   │                   │       ├── controller/
    │   │   │                   │       │   ├── AuthController.java (2.34 KB)
    │   │   │                   │       │   └── RESTSecurityController.java (1.85 KB)
    │   │   │                   │       ├── repository/
    │   │   │                   │       │   └── SecurityRepository.java (553.0 B)
    │   │   │                   │       ├── service/
    │   │   │                   │       │   ├── impl/
    │   │   │                   │       │   │   └── SecurityServiceImpl.java (1.97 KB)
    │   │   │                   │       │   └── SecurityService.java (439.0 B)
    │   │   │                   │       ├── JwtAuthorizationFilter_backup.java (1.89 KB)
    │   │   │                   │       └── JwtUtil_backup.java (1.48 KB)
    │   │   │                   ├── hello/
    │   │   │                   │   └── controller/
    │   │   │                   │       └── HelloController.java (1.28 KB)
    │   │   │                   ├── sample01/
    │   │   │                   │   ├── controller/
    │   │   │                   │   │   └── Sample01Controller.java (1.34 KB)
    │   │   │                   │   ├── entity/
    │   │   │                   │   │   └── Sample01Users.java (643.0 B)
    │   │   │                   │   ├── repository/
    │   │   │                   │   │   └── Sample01Repository.java (667.0 B)
    │   │   │                   │   └── service/
    │   │   │                   │       ├── impl/
    │   │   │                   │       │   └── Sample01ServiceImpl.java (1.27 KB)
    │   │   │                   │       └── Sample01Service.java (530.0 B)
    │   │   │                   ├── user/
    │   │   │                   │   ├── controller/
    │   │   │                   │   │   └── RESTUserController.java (3.71 KB)
    │   │   │                   │   ├── entity/
    │   │   │                   │   │   └── UserEntity.java (2.11 KB)
    │   │   │                   │   ├── repository/
    │   │   │                   │   │   └── UserRepository.java (1.98 KB)
    │   │   │                   │   └── service/
    │   │   │                   │       ├── impl/
    │   │   │                   │       │   └── UserServiceImpl.java (4.14 KB)
    │   │   │                   │       └── UserService.java (745.0 B)
    │   │   │                   └── Application.java (307.0 B)
    │   │   └── resources/
    │   │       ├── static/
    │   │       ├── templates/
    │   │       ├── application.properties (2.67 KB)
    │   │       └── packaging.pgsql (1.92 KB)
    │   └── test/
    │       └── java/
    │           └── kr/
    │               └── letech/
    │                   └── study/
    │                       └── springBoot/
    │                           ├── user/
    │                           │   └── repository/
    │                           │       └── TestUserRepository.java (2.22 KB)
    │                           └── ApplicationTests.java (212.0 B)
    ├── target/
    │   ├── classes/
    │   │   ├── META-INF/
    │   │   │   ├── maven/
    │   │   │   │   └── kr.letech/
    │   │   │   │       └── study.RestApi/
    │   │   │   │           ├── pom.properties (260.0 B)
    │   │   │   │           └── pom.xml (3.9 KB)
    │   │   │   └── MANIFEST.MF (234.0 B)
    │   │   ├── kr/
    │   │   │   └── letech/
    │   │   │       └── study/
    │   │   │           └── springBoot/
    │   │   │               ├── cmmn/
    │   │   │               │   ├── code/
    │   │   │               │   │   ├── controller/
    │   │   │               │   │   │   └── RESTCommonCodeController.class (2.54 KB)
    │   │   │               │   │   ├── entity/
    │   │   │               │   │   │   └── CommonCodeEntity.class (1.9 KB)
    │   │   │               │   │   ├── repository/
    │   │   │               │   │   │   └── CommonCodeRepository.class (781.0 B)
    │   │   │               │   │   └── service/
    │   │   │               │   │       ├── impl/
    │   │   │               │   │       │   └── CommonCodeServiceImpl.class (1.96 KB)
    │   │   │               │   │       └── CommonCodeService.class (393.0 B)
    │   │   │               │   ├── config/
    │   │   │               │   │   ├── CORSConfig$1.class (1.88 KB)
    │   │   │               │   │   ├── CORSConfig.class (800.0 B)
    │   │   │               │   │   ├── JacksonConfig.class (1.22 KB)
    │   │   │               │   │   ├── RestConfig.class (673.0 B)
    │   │   │               │   │   └── SecurityConfig.class (740.0 B)
    │   │   │               │   ├── entity/
    │   │   │               │   │   ├── AbstractCrudService.class (2.19 KB)
    │   │   │               │   │   ├── BaseEntity.class (1.91 KB)
    │   │   │               │   │   └── UpdatableEntity.class (308.0 B)
    │   │   │               │   ├── files/
    │   │   │               │   │   ├── controller/
    │   │   │               │   │   │   └── RESTFileController.class (3.44 KB)
    │   │   │               │   │   ├── entity/
    │   │   │               │   │   │   ├── FilesEntity.class (4.32 KB)
    │   │   │               │   │   │   └── FilesId.class (2.37 KB)
    │   │   │               │   │   ├── repository/
    │   │   │               │   │   │   └── FileRepository.class (2.18 KB)
    │   │   │               │   │   └── service/
    │   │   │               │   │       ├── impl/
    │   │   │               │   │       │   └── FileServiceImpl.class (3.0 KB)
    │   │   │               │   │       └── FileService.class (536.0 B)
    │   │   │               │   ├── restTemplate/
    │   │   │               │   │   ├── envelope/
    │   │   │               │   │   │   ├── Envelope$1.class (1.05 KB)
    │   │   │               │   │   │   ├── Envelope.class (4.68 KB)
    │   │   │               │   │   │   └── EnvelopeAdvice.class (2.99 KB)
    │   │   │               │   │   └── error/
    │   │   │               │   │       ├── ProblemDetail.class (1.62 KB)
    │   │   │               │   │       └── ProblemHandler.class (4.97 KB)
    │   │   │               │   ├── role/
    │   │   │               │   │   ├── controller/
    │   │   │               │   │   │   └── RESTUserRoleController.class (3.34 KB)
    │   │   │               │   │   ├── entity/
    │   │   │               │   │   │   ├── UserRoleEntity.class (2.74 KB)
    │   │   │               │   │   │   └── UserRoleId.class (2.23 KB)
    │   │   │               │   │   ├── repository/
    │   │   │               │   │   │   └── UserRoleRepository.class (1.93 KB)
    │   │   │               │   │   └── service/
    │   │   │               │   │       ├── impl/
    │   │   │               │   │       │   └── UserRoleServiceImpl.class (5.74 KB)
    │   │   │               │   │       └── UserRoleService.class (785.0 B)
    │   │   │               │   └── sec/
    │   │   │               │       ├── controller/
    │   │   │               │       │   └── RESTSecurityController.class (2.7 KB)
    │   │   │               │       ├── repository/
    │   │   │               │       │   └── SecurityRepository.class (478.0 B)
    │   │   │               │       └── service/
    │   │   │               │           ├── impl/
    │   │   │               │           │   └── SecurityServiceImpl.class (3.37 KB)
    │   │   │               │           └── SecurityService.class (442.0 B)
    │   │   │               ├── hello/
    │   │   │               │   └── controller/
    │   │   │               │       └── HelloController.class (1.9 KB)
    │   │   │               ├── sample01/
    │   │   │               │   ├── controller/
    │   │   │               │   │   └── Sample01Controller.class (1.69 KB)
    │   │   │               │   ├── entity/
    │   │   │               │   │   └── Sample01Users.class (1.03 KB)
    │   │   │               │   ├── repository/
    │   │   │               │   │   └── Sample01Repository.class (714.0 B)
    │   │   │               │   └── service/
    │   │   │               │       ├── impl/
    │   │   │               │       │   └── Sample01ServiceImpl.class (1.61 KB)
    │   │   │               │       └── Sample01Service.class (503.0 B)
    │   │   │               ├── user/
    │   │   │               │   ├── controller/
    │   │   │               │   │   └── RESTUserController.class (5.83 KB)
    │   │   │               │   ├── entity/
    │   │   │               │   │   └── UserEntity.class (2.46 KB)
    │   │   │               │   ├── repository/
    │   │   │               │   │   └── UserRepository.class (1.86 KB)
    │   │   │               │   └── service/
    │   │   │               │       ├── impl/
    │   │   │               │       │   └── UserServiceImpl.class (5.41 KB)
    │   │   │               │       └── UserService.class (987.0 B)
    │   │   │               └── Application.class (741.0 B)
    │   │   ├── application.properties (2.67 KB)
    │   │   └── packaging.pgsql (1.92 KB)
    │   ├── generated-sources/
    │   │   └── annotations/
    │   └── test-classes/
    │       └── kr/
    │           └── letech/
    │               └── study/
    │                   └── springBoot/
    │                       ├── user/
    │                       │   └── repository/
    │                       │       └── TestUserRepository.class (3.14 KB)
    │                       └── ApplicationTests.class (539.0 B)
    ├── .classpath (1.24 KB)
    ├── .gitattributes (38.0 B)
    ├── .gitignore (1.92 KB)
    ├── .project (929.0 B)
    ├── HELP.md (1.5 KB)
    ├── mvnw (11.51 KB)
    ├── mvnw.cmd (8.1 KB)
    └── pom.xml (3.9 KB)
```

## 2) 확장자별 파일 개수/용량 요약

| 확장자 | 파일 수 | 총 용량 |
|---|---:|---:|
| `.java` | 49 | 74.26 KB |
| `.class` | 48 | 100.38 KB |
| `<noext>` | 5 | 15.61 KB |
| `.properties` | 4 | 5.76 KB |
| `.prefs` | 3 | 739.0 B |
| `.xml` | 2 | 7.79 KB |
| `.pgsql` | 2 | 3.83 KB |
| `.md` | 1 | 1.5 KB |
| `.cmd` | 1 | 8.1 KB |
| `.mf` | 1 | 234.0 B |

## 3) 가장 큰 파일 Top 30

| 경로 | 크기 |
|---|---:|
| `study.springBoot/mvnw` | 11.51 KB |
| `study.springBoot/mvnw.cmd` | 8.1 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/user/controller/RESTUserController.class` | 5.83 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/role/service/impl/UserRoleServiceImpl.class` | 5.74 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/user/service/impl/UserServiceImpl.class` | 5.41 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/restTemplate/error/ProblemHandler.class` | 4.97 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/cmmn/role/service/impl/UserRoleServiceImpl.java` | 4.93 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/restTemplate/envelope/Envelope.class` | 4.68 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/files/entity/FilesEntity.class` | 4.32 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/user/service/impl/UserServiceImpl.java` | 4.14 KB |
| `study.springBoot/pom.xml` | 3.9 KB |
| `study.springBoot/target/classes/META-INF/maven/kr.letech/study.RestApi/pom.xml` | 3.9 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/user/controller/RESTUserController.java` | 3.71 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/files/controller/RESTFileController.class` | 3.44 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/sec/service/impl/SecurityServiceImpl.class` | 3.37 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/role/controller/RESTUserRoleController.class` | 3.34 KB |
| `study.springBoot/target/test-classes/kr/letech/study/springBoot/user/repository/TestUserRepository.class` | 3.14 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/files/service/impl/FileServiceImpl.class` | 3.0 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/restTemplate/envelope/EnvelopeAdvice.class` | 2.99 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/cmmn/restTemplate/envelope/Envelope.java` | 2.8 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/role/entity/UserRoleEntity.class` | 2.74 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/sec/controller/RESTSecurityController.class` | 2.7 KB |
| `study.springBoot/src/main/resources/application.properties` | 2.67 KB |
| `study.springBoot/target/classes/application.properties` | 2.67 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/code/controller/RESTCommonCodeController.class` | 2.54 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/user/entity/UserEntity.class` | 2.46 KB |
| `study.springBoot/target/classes/kr/letech/study/springBoot/cmmn/files/entity/FilesId.class` | 2.37 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/cmmn/sec/controller/AuthController.java` | 2.34 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/cmmn/files/repository/FileRepository.java` | 2.25 KB |
| `study.springBoot/src/main/java/kr/letech/study/springBoot/cmmn/restTemplate/error/ProblemHandler.java` | 2.24 KB |
