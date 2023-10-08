# wanted-pre-onboarding-backend
원티드 10월 프리온보딩 사전과제입니다.

## 사용 기술 스택
- Java
- Spring Boot
- Spring Data JPA
- QueryDSL
- MySQL
- Docker


## 실행방법
프로젝트 상위 경로에서 아래 명령어 실행
```
docker-compose up
```

## API 명세서

### 회원 등록
- Http Method : Post
- API 주소 : /api/account/join
- 요청 데이터
```json
{
   "name" : "hoe",
   "age" : 26
}
```
### 회사 등록
- Http Method : Post
- API 주소 : /api/company/create
- 요청 데이터
```json
{
   "name" : "원티드",
   "country" : "대한민국",
   "area" : "서울"
}
```
### 채용공고 등록
- Http Method : Post
- API 주소 : /api/announcement/create
- 요청 데이터
```json
{
   "companyId" : 1,
   "position" : "백엔드",
   "content" : "원티드 사전과제입니다.",
   "recruitmentCompensation" : 30000,
   "skill" : "Java"
}
```

### 채용공고 삭제
- Http Method : Delete
- API 주소 : /api/announcement/{announcementId}
- PathVariable : announcementId

### 채용공고 수정
- Http Method : Put
- API 주소 : /api/announcement/{announcementId}
- PathVariable : announcementId
- 요청 데이터
```json
{
   "position" : "백엔드",
   "content" : "원티드 사전과제입니다.",
   "recruitmentCompensation" : 30000,
   "skill" : "Java"
}
```

### 채용공고 목록
- Http Method : Get
- API 주소 : /api/announcement?search
- Parameter : search
- 응답 데이터
```json
[
    {
        "announcementId": 2,
        "companyName": "원티드랩",
        "country": "대한민국",
        "area": "서울",
        "position": "프론트엔드",
        "recruitmentCompensation": 10000,
        "skill": "React"
    },
    {
        "announcementId": 1,
        "companyName": "원티드랩",
        "country": "대한민국",
        "area": "서울",
        "position": "풀스택",
        "recruitmentCompensation": 20000,
        "skill": "JPA"
    }
]
```

### 채용공고 신청
- Http Method : Get
- API 주소 : /api/announcement/register
요청 데이터
```json
{
  "accountId" : 1,
  "announcementId" : 1
}
```
- 에러 응답데이터
```json
{
    "message": "이미 신청한 채용 공고입니다.",
    "time": "2023-10-08T23:55:06.084054",
    "status": 409
}
```

### 채용공고 상세보기
- Http Method : Get
- API 주소 : /api/announcement/{announcementId}
- PathVariable : announcementId
- 응답 데이터
```json
{
    "announcementId": 1,
    "companyName": "원티드랩",
    "country": "대한민국",
    "area": "서울",
    "recruitmentCompensation": 20000,
    "skill": "JPA",
    "content": "객체지향",
    "announcementIds": [
        1,
        2
    ]
}
```



