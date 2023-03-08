Servlet
- HttpServletRequest
  - 개발자가 Http 요청 메세지를 직접 파싱해도 되지만, 불편하기 떄문에 편리하게 파싱해주는 객체  
  - 헤더 바디 등,,, 
    - request.getParameter(key)
      - 쿼리 파라미터 (url?key=value)를 key value 형태로 꺼낼 수 있다
      - logging.level.org.apache.coyote.http11=debug 을 사용하면 모든 정보 확인 가능( 운영 서버에서는 사용 자제)
  - 부가기능
    - 임시 저장소 기능
      - HTTP 요청이 시작부터 응답까지 유지되는 임시 저장소 기능
        - 저장 : request.setAttribute(name,value)
        - 조회 : rquest.getAttribute(name)
    - 세션 관리 기능
      - request.getSession(create: true)
    

  - HTTP 요청 데이터
    - 서버로 데이터를 전달하는 방법 3가지
      - GET - 쿼리 파라미터
        - 메세지의 바디가 없이 URL의 쿼리 파라미터에 데이터를 포함해서 전달
        - 시작 : ?, 추가 파라미터는 &로 구분
        - 검색, 필터, 페이징등에서 많이 사용
        - 복수 파라미터, 단일 파라미터
          - 파라미터 이름은 하나인데, 값이 중복되는경우 request.getParameterValues(name)을 사용해서 꺼냄
          - 기본적으로는 하나의 파라미터 이름에 대해서는 하나의 값만 사용 (request.getParameter(name))
      - POST - HTML form
        - content-type : application/x-www-form-urlencoded
          - HTTP 메세지 바디의 데이터 형식을 지정하는 속성
          - GET url 사용시엔 바디를 사용하는게 아니라 없어도 되지만 POST의 경우 body에 보내기 때문에 필요함
        - 메세지 바디에 쿼리 파라미터 형식으로 전달한다.
          - 따라서 getParameter로도 받을 수 있음
        - HTML form에서 사용됨
      - HTTP message body에 데이터를 직접 담아서 요청
        - HTTP API에서 주로 사용,, JSON, XML, TEXT
        - 데이터 형식은 주로 JSON 사용
        - HTTP 메서드 : POST, PUT, PATCH 등으로 사용

HttpServletResponse
- HTTP 응답코드 지정
- 헤더 생성
- 바디 생성
- 편의 기능 제공
  - Content-Type, 쿠키, Redirect

