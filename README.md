# cafe-tart(가칭) 
2024.08 ~ ...
카페-타르트(가칭) 브랜드 사이트 초기 버전

# 사용 기술 스택
Backend : Java 17, SpringBoot 2.7, WebSocket(현재 X)
Sql Mapper : Mabatis
ORM : JPA(현재 X)
Front : JSP, JS(ES5), jQuery, BootStrap
DB : MySQL, PostgreSQL(현재 X)
Lib : Swipe, Lombok
Infra : AWS Cloud(현재 X), Docker(현재 X)
Server : WAS(Apache Tomcat), WEB(Apache HTTP(현재 X))
CI/CD : Github / Jenkins(현재 X)
Mobile 지원 : AOS(현재 X) / IOS(현재 X)
 - Flutter WebView 예정

# Description
브랜드 사이트(게시판(텍스트 + 이미지)기능과 채팅 기능이 있는)로 개발 중.
BoilerPlate 겸용이며 간단하게 프리티어로 배포해볼 예정
사업 구조 상 확장에 다소 제한이 있을 것이라 생각하여 일단은 MPA(멀티 페이지 어플리케이션) 구조이며 Monolithic으로 진행.
단일 서버 구성 예정이나, 여건이 된다면 이중화 / 클러스터링 / 오케스트레이션을 적용해보길 희망
느리더라도 차차 완성하여 상용화하길 희망..
확장한다면 베이킹 레시피 메뉴도 존재하는 사이트를 희망하지만 그러는 경우 서버 유지비가 추가로 들 것으로 예상되므로 현재는 제외
