# 스터디 1주차</br>

JPA 이전까지</br>
https://ddingg.tistory.com/44</br>
1. 블로그 정리. </br>
2. 기본적인 GetMapping, Json으로 데이터 받아와 확인.</br>
3. Annotation들과 JPA에 대한 학습 필요. Entity를 구성하는 것 까지 완료.</br>

<hr>

# 스터디 2주차</br>

##### 토이 프로젝트 시작 : Temporage(회사 같은 제한적인 공간에서 자신이 필요한 링크 혹은 메모를 remote storage에 임시로 보관할 수 있는 프로그램)</br>
##### 기술 스택 참고 : https://github.com/haneunjung/log/blob/master/log/2020-01-11.md </br></br></br>
##### DB 구성</br>
![temporage_db](https://user-images.githubusercontent.com/29707967/72516191-9be4cd80-3894-11ea-8d1b-1f4ab56da826.png)

#### 기능</br>
1. key, value를 받아 DB에 저장. - 완료
2. key 값으로 DB에 있는 값을 Searching 해서 결과를 반환. - 완료
3. 저장 후 이틀 이상 지난 값은 삭제. (매일 00시 마다 DB에서 삭제. Searching 해서 return 할 때 한번 더 check 해서 이틀이 지난 값은 return 되지 않게 함.) - 추가 예정

### API</br>
#### /save : parameter - key, value</br>
##### 해당 parameter로 request를 보내 DB에 저장. 현재 시간도 함께 저장</br>
#### /getData : parameter - key</br>
##### key로 값을 찾아 return함. key, value, datetime이 return 됨.


