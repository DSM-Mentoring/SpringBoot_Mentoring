# JWT (JSON WEB TOKEN)

URL-safe(URL로 이용할 수 있는 문자만 구성된)의 JSON

JWT는 일반적으로 클라이언트와 서버, 서비스와 서비스 사이 통신 시 권한을 위해 사용하는 토큰

URL에 대해 안전한 문자열로 구성되어 있기 때문에 HTTP 어디든 위치 할 수 있음



<아래 그림 참조> 로직 설명

![img](https://blog.kakaocdn.net/dn/rdboS/btqArUrgcMr/HWY80zNL9reAv6FeE6AYE1/img.png)

- JWT를 static 변수와 로컬 스토리지에 저장하고 됨

  - static 변수에  저장되는 이유는 HTTP 통신을 할 때마다 JWT를 HTTP 헤더에 담아서 보내야 하는데 이를 로컬 스토리지에서 계속 불러오면 오버헤드가 발생하기 때문

- 클라이언트에서 JWT를 포함해 요청을 보내면 서버는 허가된 HWT인지 검사

- 로그라웃을 할 경우 로컬 스토리지에 저잗된 ,JWT 데이터를 제거

  

[JWT 개념]

Json 포맷을 이용하여 사용자에 대한 속성을 저장하는 클레임 기반의 web token

JWT 토큰 자체를 정보로 사용하는 self-contained 방식