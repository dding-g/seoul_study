# 스터디 1주차

JPA 이전까지  
https://ddingg.tistory.com/44  

1. 블로그 정리.

2. 기본적인 GetMapping, Json으로 데이터 받아와 확인.

3. Annotation들과 JPA에 대한 학습 필요. Entity를 구성하는 것 까지 완료.

---

# 스터디 2주차

##### 토이 프로젝트 시작 : Temporage(회사 같은 제한적인 공간에서 자신이 필요한 링크 혹은 메모를 remote storage에 임시로 보관할 수 있는 프로그램) ---
##### 기술 스택 참고 : https://github.com/haneunjung/log/blob/master/log/2020-01-11.md 
##### DB 구성  
![temporage_db](https://user-images.githubusercontent.com/29707967/72516191-9be4cd80-3894-11ea-8d1b-1f4ab56da826.png)

#### DB 생성 쿼리  
CREATE SEQUENCE seq_id START 1;

-- Table: public.temporage_data

-- DROP TABLE public.temporage_data;
```

CREATE TABLE public.temporage_data  
(
    id integer NOT NULL DEFAULT nextval('seq_id'::regclass),
    key text COLLATE pg_catalog."default" NOT NULL,
    value text COLLATE pg_catalog."default" NOT NULL,
    create_time timestamp without time zone NOT NULL,
    CONSTRAINT temporage_data_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.temporage_data OWNER to postgres;

```

#### 기능
1. key, value를 받아 DB에 저장. - 완료
2. key 값으로 DB에 있는 값을 Searching 해서 결과를 반환. - 완료
3. 저장 후 이틀 이상 지난 값은 삭제. (매일 00시 마다 DB에서 삭제. Searching 해서 return 할 때 한번 더 check 해서 이틀이 지난 값은 return 되지 않게 함.) - 추가 예정

### API
#### /save : parameter - key, value
##### 해당 parameter로 request를 보내 DB에 저장. 현재 시간도 함께 저장
#### /getData : parameter - key
##### key로 값을 찾아 return함. key, value, datetime이 return 됨.

#### 추가 기능
##### [ ]SNS와 연동. 내용을 바로 SNS에 올릴 수 있게 해줌
##### [o]회원가입, 로그인 - 3주차  

---

# 스터디 3주차 02/02
### API
- /sign-up : parameter - email, password, name 
    - return type : String 
- /sign-in : parameter - email, password 
    - return type : String

### **기능 추가**
- 회원가입, 로그인 기능 추가. 
- 세션 기능 추가 예정 
- CI/CD git 연동 및 배포 완료. 

### **다음주 기능 추가 예정**
- 로그인 세션
- 공유 기능
- CI/CD 완성 시키기