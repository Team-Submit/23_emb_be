## 프로젝트 설명

- emb라는 프로젝트는 유성구청 기간제 인력을 관리할 때 기존의 데이터 관리가 되지 않아 경력 공유가 어려운 점, 공문들이 데이터베이스에 저장되지 않아 모든 게시글을 찾아야 하는 점등의 불편함을 개선하기 위한 프로젝트입니다. 
- emb notion link(https://www.notion.so/emb-83f6ce0c936847ca9a8da705eb1bcd35?pvs=4)
- 유성구청 관련 기사(https://www.dawonnews.co.kr/news/articleView.html?idxno=100733)

## 프로젝트 목표

- 모든 부서에서  입력된 데이터를 공유할 수 있으며 범용적으로 사용할 수 있는 근로 인력 입력 프로그램 만들기

## 프로젝트 기동방법

### 구성원

- 양희범, 심예찬,  이강희, 이하윤

## 언어, 버전, 사용한 라이브러리

- 언어 : JAVA 
- 버전: 17
- sprig boot version: 3.1.4
- spring.dependency-management version : 1.1.3

```java
dependencies {
	// redis
	implementation 'org.springframework.boot:spring-boot-starter-data-redis'

	// validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'

	// web
	implementation 'org.springframework.boot:spring-boot-starter-web'

	// lombok
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'

	// jwt
	implementation 'io.jsonwebtoken:jjwt-api:0.11.5' 
	runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5' 
	runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'
	
	// mysql
	runtimeOnly 'com.mysql:mysql-connector-j'

	// security
	implementation 'org.springframework.boot:spring-boot-starter-security'

	// jpa
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

	// configuration
	annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'

	// test
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
}
```
