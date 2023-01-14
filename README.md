# study_java_effectiveJava
EffectiveJava 개인 공부 필기 + 인프런 백기선 EffectiveJava 라이브코딩


<details>
  <summary><b>2장 객체 생성과 파괴</b></summary>
  <details>
     <summary><b>Item1 생성자 대신 정적 팩터리 메서드를 고려하라</b></summary>
    
     >> 평범한 경우에는 생성자를 사용하고, 정적 팩터리가 유리한 경우에는 생성자만 쓰지말고 정적 팩터리 메서드도 고려를 해봐라
- 클라이언트가 클래스의 인스턴스를 방법
    - 전통적인 수단 : public 생성자
    - 정적 팩터리 메서드 (static factory method) : 해당 클래스의 인스턴스를 반환하는 단순한 정적 메서드 (디자인 패턴의 팩터리 메서드와 다름)
        - 정적 팩터리 메서드 : 객체의 생성 역할을 하는 클래스 메서드 (생성자를 통해 객체를 생성하는게 아닌, 메서드를 통해 객체를 생성해주는 메서드)
        - 클래스는 클라이언트에 public 생성자 대신 정적 팩터리 메서드를 제공,
            - 장점 : 
                - 1. 이름을 가질 수 있다.
                    - 생성자는 이름을 바꿀 수 없고, 생성자를 다르게 일부 필드만 변경하려면 파라미터의 순서를 바꾸어 선언하는등의 번거로움이 있음..
                    - 생성자 자체만으로는 반환될 객체의 특성을 제대로 설명 못함.. (메서드 명으로 해당 생성자가 무엇을 의미하는지 명확한 의미전달 가능)
                - 2. 호출 될 때마다 인스턴스를 새로 생성하지 않아도 된다.
                    - 생성자는 기본적으로 매번 새로운 인스턴스를 만든다. 
                    - 인스턴스의 통제가 필요한 경우가 있는데, 생성자가 있으면 통제가 불가능함.
                    - 불변 클래스는 인스턴스를 미리 만들어 놓는 등 불필요한 객체 생성을 피할 수 있다. >> 생성 비용이 큰 객체가 자주 요청되는 상황시 성능을 올려준다.
                    - 반복되는 요청에 같은 객체를 반환하는 식으로 정적 팩터리 방식의 클래스는 언제 어떤 인스턴스를 살아 있게 할 지 철저히 통제 가능 >> 인스턴스 통제 클래스
                        - 인스턴스 통제 클래스는 클래스를 싱글턴으로 만들수도, 인스턴스화 불가로 만들 수 있다. 
                        - 불변 값 클래스에서 동치인 인스턴스가 단 하나뿐임을 보장 할 수 있다.
                        - 인스턴스 통제는 플라이웨이트 패턴의 근간이 된다.
                        - 열거 타입 인스턴스가 하나만 만들어짐을 보장
                        - 플라이 웨이트 패턴 (자주 사용하는 값들을 미리 캐싱해서 넣어두고, 꺼내서 쓰는 패턴,,) 과 유사함
                - 3. 반환 타입의 하위 타입 객체를 반환 할 수 있는 능력이 있다.
                    - 반환할 객체의 클래스를 자유롭게 선택 할 수 있다. >> 큰 유연성 보장. ,, API 구현 시, 작게 유지 할 수 있다.
                    - 인터페이스 타입을 사용 가능 (정적 팩터리 메서드 사용시 리턴 타입에 인터페이스를 두고, 실제 리턴은 해당 인터페이스의 구현체로 해줌)
                    - 자바 8 이후부터는 인터페이스에 정적 메서드를 선언 가능, 이를 통해 컬렉션 프레임워크에 핵심 인터페이스들에 수정 불가나 동기화 등의 기능을 붙인 구현체를 java.util.Collections를 통해 얻도록 했음. 
                        - 해당 인터페이스의 정적 팩터리 메서드를 호출하여 객체를 생성하는 클라이언트 입장에서 선언된 객체의 타입은 인터페이스가 된다! (이렇게 하면 API를 만들 때 구현 클래스를 공개하지 않고도 그 객체를 반환 할 수 있어 API를 작게 유지 가능) >> 인터페이스 기반 프레임워크를 만드는 핵심 기술
                        - 클래스에서는 메서드에 접근지정자를 붙이지 않으면 package 레벨의 접근지정자가 되고, 인터페이스에서는 public 레벨의 접근 지정자가 된다.
                - 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환 할 수 있다.
                    - 3번의 내용과 같이, 해당 타입의 리턴하는 타입의 하위타입인 경우 리턴의 구현체로 사용 가능하다.
                    - 3번 내용과 같이 클라이언트는 반환 타입의 존재를 모르고 알 필요도 없다. 그냥 해당 객체의 하위 클래스이기만 하면된다. 
                        - EnumSet 클래스는 public 생성자 없이 정적 팩터리만 제공하는데, OpenJDK에서는 원소의 수에 따라 두가지 하위 클래스 중 하나의 인스턴스를 반환한다. 
                            - 원소가 64개 이하면 원소들을 long 변수 하나로 관리하는 RegularEnumSet의 인스턴스를
                            - 65개 이상이면 long 배열로 관리하는 JumboEnumSet의 인스턴스를 반환한다.
                - 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
                    - ServiceLoader를 통해서 해당 인터페이스에 해당하는 구현체의 객체를 받아와 메서드를 실행 할 수 있음.
                    - 이렇게 하면 구현체에 의존적이지 않고 인터페이스에 의존하게 됨 >> 많은 유연성 제공
            - 단점
                - 1. 상속을 하려면 private나 protected 생성자가 필요한데, 정적 팩터리 메서드를 사용하려면 생성자를 private하게 선언하고 정적 팩터리 메서드를 선언하기 때문에 상속이 불가능하다.
                    - 상속보다 컴포지션()을 하도록 유도하면서 불편타입으로 만들려면 이 제약을 지켜야한다는 점에서 장점으로 받아들일 수 있다.
                - 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다
                    - javadoc을 사용하면 생성자는 API가 칸이 특별하게 생성되서 나오는 반면, 정적 팩토리 메서드를 사용하면 다른 메서드들과 엮이기 때문에 클라이언트가(해당 API를 사용하는 사용자) 찾기가 어려움.
                        - 네이밍 규칙을 이용하여 해결한다 (javadoc에 스태틱 메서드 탭이 있으니 거기서 그래도 찾기 쉬우라고)
                            - from : 매개변수 1개를 받아서 인스턴스를 리턴하는 경우
                            - of,valueOf : 매개변수 여러개를 받아서 인스턴스를 만들어 리턴하는 경우 
                            - valueOf : of, from보다 더 자세하게 매개변수를 받는다.
                            - instance, getInstance : 미리 만들어져있는 인스턴스를 가져오는 경우 (같은 인스턴스임을 보장하지는 않음!)
                            - create , newInstance : 매번 새로운 인스턴스를 생성해 반환하는 경우.(다른 인스턴스를 보장)
                            - getType : getInstance 에서 인스턴스를 가져오는데 다른 클래스에서 팩터리 메서드를 정의 할 때 사용
                            - newType : newInstance에서 인스턴스를 가져오는데 다른 클래스에서 팩터리 메서드를 정의 할 때 사용
                                - BuffredReader br = Files.newBufferedReader(path);
                            - type : getType과 newType의 간결한 버전
                                - List<Product> productLitst = Collections.list(legacyProductList);
                        - 문서화(javadoc)를 통해 메서드를 설명한다. 
                            - javadoc 규약
                                - @param : 매개변수에 대한 설명
                                - @return : 반환값에 대한 설명
                                - @throws : 던지는 예외에 대한 설명
                                - @see : 외부 링크 또는 텍스트를 표시,,다른 필드나 메소드에 대한 모든 참조 링크를 나타내는 경우 사용
                                - /** 주석을 통해 설명해놓고 @see를 사용, 참조함을 알려주는건 클래스명#메서드명 (자기 자신일 경우 #메서드명)  
                            - javadoc 실행 방법
                                - tools > generated javadoc 클릭
                                - 한글 깨짐 방지를 위해 Other command line arguments에 
                                    - encoding UTF-8 charset UTF-8 docencoding UTF-8 > OK
                                    - open generated documentation in browser 체크하면 생성 후 자동으로 열림,, 
                                        - 체크 안해놨으면 해당 파일 경로의 index.html 열기.
            - 정적 팩토리 메서드 완벽 공략
                - 열거 타입(Enum)은 인스턴트가 하나만 만들어짐을 보장한다.
                    - 열거타입(Enum) : 상수 목록을 담을 수 있는 데이터 타입, 필드가 가질 수 있는 특정한 값들을 제한 할 수 있다. >> Type Safety 보장
                        - Type Safety : 허용하지 않는 값을 방어가 됨을 보장 (컴파일러 차원에서 지원하기 때문에)
                        - ENUM은 인스턴스가 하나만 만들어진다.
                            - Enum은 하나의 인스턴스만 만들어짐을 보장하기 때문에 값 비교시 equals보다 ==을 권장
                                - 만약 비교하는 대상이 null인경우, ==을 쓰면 그냥 아니라고 비교가되고 , equals를 쓰면 NPE가 동작하기 때문
                        - 열거 타입의 이름은 관례적으로 파스칼케이스(첫글자 대문자, 이후 카멜) 사용상수의 이름들은 관례적으로 모두 대문자를 사용
                        - Enum 내부적으로 필드나 생성자를 가질 수 있다.
                        - Enum타입의 메서드
                            - valueOf() : 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴 (외부로부터 문자열을 입력받아 열거 객체로 변환 할 때 사용) 
                                - 해당하는열거 객체가 없다면 IllegalArgumentException 발생
                            - values() : 열거 타입의 모든 객체들을 배열로 만들어 리턴
                            - name() : 열거 객체가 갖고있는 문자열을 리턴하는 메소드. 리턴되는 문자열은 열거타입 정의시 사용한 상수 이름과 동일
                            - ordinal() : 전체 열거 객체 중 몇 번째 열거 객체인지 알려주는 메소드,, 배열의 인덱스
                            - Enum을 key로사용하는 맵이나 Enum을 담고있는 Set을 만들어 쓰고싶으면  EnumSet, EnumMap을 사용해서 사용하면 훨씬 빠름
                                - Color.class을 Enum으로 정의 했을 때
                                    - allOf(Color.class) : Enum의 모든 요소를 포함하는 EnumSet 만들 수 있다.
                                    - noneOf(Color.class) : 빈 Color 컬렉션을 갖는 EnumSet을 만들 수 있다.
                                    - contains(Color.RED) : 특정 요소가 EnumSet에 포함되어 있는지 확인 할 수 있다.
                                    - remove(Color.RED) : 특정 요소를 제거 할 수 있다. 
                - 같은 객체가 자주 요청되는 상황이라면 플라이웨이트 패턴을 사용 할 수 있다.
                    - 플라이웨이트 패턴 : 객체를 재사용 하는 방법 중 하나로, 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
                        - 자주 변하는 속성과 변하지 않는 속성을 분리하고, 재사용하여 메모리 사용을 줄일 수 있다. 조금이라도 줄이기 위해..
                        - 플라이웨이트 패턴을 생성자로 사용하지않고, 정적 팩토리 메서드를 통해 만들 수 있다.
                - 자바 8 부터는 인터페이스가 정적 메서드를 가질 수 없다는 제한이 풀렸기 때문에 인스턴스화 불가능한 동반 클래스를 둘 이유가 별로 없다.
                    - 기본 메서드
                        - default로 선언
                        - 인스턴스를 통해서 메서드를 호출 할 수 있음
                    - 정적 메서드
                        - static으로 선언하는것 (public이 기본이기 때문에 public이 들어가있음)
                        - 구현 타입을 통해서 메서드를 호출 할 수 있음
                    - private static 메서드
                        - java9 이후부터 제공, 하지만 아직도 private 필드는 정의 할 수 없다.
                        - override 불가능, 인터페이스 이름.메소드 이름 방식으로 사용해야함
                - 서비스 제공자 프레임워크를 만드는 근간이 된다. 
                    - 개념이 중요하지, 구현이 중요한게 아니다. (확장 가능한 애플리케이션을 목적으로..)
                    - 서비스 제공자 프레임워크 구성요소 4가지
                        - 서비스 제공자 인터페이스
                            - 확장이 가능한 서비스의 특징을 정의 ,, Service.interface
                        - 서비스 제공자
                            - 서비스 인터페이스를 구현하는 구현체
                        - 서비스 제공자 등록 API
                            - 스프링 기준 AppConfig처럼 서비스를 등록시키도록 도와주는 API 
                        - 서비스 접근 API
                            - 서비스를 가져오도록 해주는 API (의존관계 주입)
                - 서비스 제공자 인터페이스가 없다면 각 구현체를 인스턴스로 만들 때 리플렉션을 사용해야 한다.
                    - 리플렉션이란
                        - JVM의 클래스 로더를 통해 읽어온 클래스 정보(애노테이션, 필드, 메서드 등)를 사용하는 기술
                        - 네이밍 패턴, 필드이름 등등을 가능하게 해줌 >> 편리성 제공 
                - 브리지 디자인 패턴
                    - 서로 영향을 주지 않으면서 개별적인 계층구조로 발전 할 수 있게끔 구체적인것과 추상적인것을 분리해서 그 사이에 다리를 놓는 패턴
                    - 확장을 유연하게 해줌.
                - 의존 객체 주입 프레임워크 (스프링 프레임워크)

  </details>
  
  <details>
  <summary><b>Item2 생성자에 매개변수가 많다면 빌더를 고려하라</b></summary>
  
  정적 팩터리와 생성자의 제약조건 : 선택적 매개변수가 많을 때 적절히 대응하기 어렵다

선택적 매개변수가 많을때 생성자를 만드는 방법
- 점층적 생성자 패턴
    - 어떤 클래스에 필수 파라미터와 선택적 파라미터가 여러개가 있는경우, 필수 파라미터 + 선택적 파라미터 1개 생성자, 필수 파라미터+ 선택적 파라미터 2개 생성자 …  필수파라미터 + 선택적 파라미터 n개 생성자 이런 방식으로 점층적으로 생성자의 선택적 매개변수의 개수를 늘려가는 방식
    - 매개변수의 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어려움
        - 각 값의 의미, 몇개인지 세어보기, 원하지않는 매개변수 사용, 타입이 같은 매개변수가 연달아 나오면 찾기 어려운 버그 등,, 컴파일 단계에서 잡지 못하는 여러가지 변수들이 존재함
- 자바 빈즈 패턴
    - 자바 빈즈란 자바 표준 스펙중 하나인데, 게터세터 등을 정의해놨음
    - 객체 생성이 간단해짐
    - 매개변수가 없는 생성자로 객체를 만든 후, 세터 메서드를 호출해 원하는 매개변수의 값을 설정하는 방식
    - 객체 하나를 만들기 위해서는 메서드를 여러개 호출해야하고, 객체가 완전히 생성되기 전 까지 일관성이 무너진 상태에 놓인다. >> 디버깅이 어려움
        - 매개변수가 없는 생성자를 객체로 만드니까, 필수 파라미터를 빼놓고 사용 할 수도 있고,, 하니까 안전하지가 않음 (주석이나 문서화밖에는 방법이 없음)
        - 생성자에 필수 파라미터를 받는다고 해도, 불변성(이뮤터블)이 보장되지 않아 불완전함
    - 클래스를 불변으로 만들 수 없으며 스레드 안정성을 얻으려면 프로그래머가 추가작업을 해줘야함 
    - 단점을 완화하고자 생성이 끝난 객체를 수동으로 얼리고, 얼리기 전에는 사용 할 수 없도록 하는데, 실전에서는 거의 안쓰임,, 또한 freeze 메서드를 확실히 호출해줬는지 컴파일러가 보증 할 방법이 없어 런타임 오류에 취약
- 빌더 패턴
    - 점층적 생성자 패턴의 안전성 + 자바 빈즈 패턴의 가독성
    - 필수 파라미터만 갖는 생성자를 호출해 객체를 만들고, 빌더 객체가 제공하는 일종의 세터 메서들로 원하는 선택 매개변수를 설정 후, 매개변수가 없는 build 메서드를 호출해 클라이언트에게 필요한 (보통은 불변인) 객체를 얻는다.
        - 플루언트 API (메서드 호출) : 빌더의 세터 메서드들은 빌더 자신을 반환하기 때문에 연쇄적으로 호출 할 수 있다
    - 빌더는 생성할 클래스 안에 정적 멤버 클래스로 만들어두는게 보통이다.
    - 장점
        - 상당히 유연하다.
            - 빌더 하나로 여러 객체를 순회하며 만들 수 있고, 빌더에 넘기는 매개변수에 따라 다른 객체를 만들 수 있다.
            - 객체마다 부여되는 일련번호와 같은 특정 필드는 빌더가 알아서 채우도록 할 수 있다.
    - 단점
        - 객체를 만들려면 그에 앞서 빌더부터 만들어야 함
            - 생성비용은 크지 않지만, 성능에 민감한 상황에서는 문제가 될 수 있다.
        - 코드가 장황해서 매개변수가 4개 이상은 되어야 값어치를 한다.
            - 하지만 API는 시간이 지날수록 매개변수가 많아지는 경향이 있음을 명심!!
            - 생성자나 정적 팩터리 방식으로 시작했다가 나중에 매개변수가 많아지면 빌더 패턴으로 전환 할 수 있지만, 이전에 만들어둔 생성자와 정적 팩터리가 아주 도드라져보임,, 애초에 빌더로 시작하는 편이 나을때가 많다.
            - 인프런 팁 : Lombok의 @Builder를 추가하면 빌더를 알아서 만들어줌,
                - 애노테이션 프로세서 : 주석과도 같은 애노테이션을 통해 컴파일 하는 시점에 자바 코드로 변환을 해줌 ,, target 아래에 실제 클래스 파일을 만들어준다..
                - 장점 : 애노테이션 하나로 코딩을 할 게 없음,, 세팅 할 파라미터만 지정해주면 됨
                - 단점 : 
                    - 모든 파라미터를 받는 생성자가 생기기 때문에, 매개변수가 많은 생성자 가 노출되기 때문에 헷갈릴 수 있음,,
                        - 보완 하려면 AllArgsConstructor(access=AccessLevel.PRIVATE) 설정하면 외부에서 모든 파라미터 받는 생성자를 못씀
                    - 필수 파라미터를 지정 할 수 없음 이건 해결 불가라서 객체 사용시 필수 파라미터를 받아야한다면 빌더패턴을 직접 생성해줘야함 (어노테이션 불가능)
                    - 빌더 이름이 Builder로 default로 만들어지지 않음
                        - @Builder(builderClassName=“Builder”)로 설정하면 해결 가능
    - 핵심 정리 
        - 생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는게 더 낫다.
        - 매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 고려 할 것
        - 빌더는 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바 빈즈보다 훨씬 안전하다.

빌더 패턴은 계층적으로 설계된 클래스와 함께 사용하기에 좋다.
- 각 계층의 클래스에 관련 빌더를 멤버로 정의한다.
    - 추상 클래스는 추상 빌더를 갖게한다.
        - 추상클래스의 이너 Builder 클래스는 재귀적 타입 한정을 이용하는 제네릭 타입으로 정의
            - 하위타입으로 리턴해줘야 하위 클래스에서 재귀(메서드 체이닝)시 캐스팅을 해주지 않아도 됨.
        - 추상 메서드인 self를 통해 하위 클래스에서 형변환 하지 않고 메서드 연쇄를 지원한다 >> self 타입이 없는 자바에서 우회적으로 사용,, >> 시뮬레이트한 셀프타입 관용구
            - this를 리턴하면 상위 클래스를 리턴 해주기 때문에 하위타입으로 캐스팅 해줘야함
    - 구체 클래스는 구체 빌더를 갖게한다.
        - 각 하위클래스의 빌더가 정의한 build 메서드는 해당하는 구체 하위클래스를 반환하도록 선언
            - NyPizza.Builder.build()는 NyPizza 반환, Calzone.Builder.build()는 Calzone 반환
            - 공변 반환 타이핑 : 하위클래스의 메서드가 상위 클래스의 메서드가 정의한 반환 타입이 아닌, 그 하위 타입을 반환하는 기능
                - 클라이언트가 형변환에 신경쓰지 않고도 빌더를 사용 할 수 있다.
        - self()를 return this처리해서 하위타입을 다시 호출해주게끔함 (자바에는 없기 때문에 편법사용)

인프런 - 아이템2 생성자에 매개변수가 많다면 빌더를 고려하라 완벽 공략
- 자바 빈즈, 게터, 세터
    - 자바 빈즈
        - 주로 GUI에서 재사용이 가능한 소프트웨어 컴포넌트
        - 자바빈 스펙
            - GUI에서 사용하기위한 규약임, 
            - 프레임워크에서 사용하는경우, 데이터를 꺼내야 하는데 일관성이 필요, 여기서 자바 빈 규약을 따른 것!
            - 종류
                - 게터세터 네이밍 규약
                    - boolean만 독특하게 is필드명 라고 함
                - 인자가 없는 없는 생성자를 만들어 둬야 한다.
                    - 그래야 객체를 만들기 편함
                - Serializable 인터페이스를 따라야 한다. 
                    - 객체를 직렬화하고 역직렬화하게끔 해줌, 객체를 저장 할 수 있는 형태로 만들어줘야함
- 객체 얼리기 
    - 자바에 있는 기능 아님, 자바스크립트에 있는 기능, 진짜 안씀
    - freeeze를 하고나선 객체에 프로퍼티를 추가 할 수 없음
- 빌더 패턴
    - 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법.
        - 복잡한 객체를 만드는 프로세스를 독립적으로 분리 할 수 있다.
- IllegalArgumentException : 잘못된 인자를 넘겨 받았을 때 사용 할 수 있는 기본 런타임 예외
    - RuntimeException을 상속받은 기본 런타임 예외, uncheckedException
        - 자바의 예외 상황
            - Error
                - 시스템에 비정상적인 상황이 발생했을경우 발생
                - 메모리부족(OutOfMemoryError), 스택오버플로우(StackOverFlow) 등
                - 개발자가 예측하기도 쉽지 않고 처리 할 수 있는 방법도 없다.
            - Exception(예외)
                - Checked Exception
                    - RuntimeException의 하위클래스가 아니면서 ! Exception의 하위 클래스
                    - 반드시(강제) 에러 처리를 해야하는 특징이 있다. (try/catch or throw)
                    - FileNotFoundException, ClassNotFoundException 등
                    - 강제를 하기 때문에 클라이언트가 어떤 후속작업을 해주길 원하는경우 checkedException을 사용해야한다.
                - Unchecked Exception
                    - RuntimeException의 하위 클래스, 말그대로 실행 중 발생할 수 있는 예외
                    - Checked Exception과는 달리 에러 처리를 강제하지 않는다.
                    - ArrayIndexOutOfBoundsException, NPE, IllegalArgumentException 등

                - 어떤 필드에서 왜 에러가 났는지 생성자에 충분한 정보를 알려주는것이 좋다.
                - 메서드에 throws IllegalArgumentException, NullPointerException등 throws 를 해두면, 명시적으로 해당 메서드를 사용하는 클라이언트에게 이러한 에러가 발생 할 수 있다는 걸 알려줄 수 있다.! (에러 조심하라고 알려주는)
                - 너무 많은 uncheckedException을 다 표기하는건 코드의 가독성을 떨어트릴 수 있기 때문에 , 보통 checkedException만 표기를 한다.
- 가변인수
    - 가변적인 인자가 있는경우 여러 인자를 넘겨받는 방법
    - 타입…변수명 으로 사용, 내부적으로 배열을 생성해서 사용한다.(향상된 for문, 인자값으로 배열 넣어진다.)
    - 오롯이 메서드에 마지막에 하나만 쓸 수 있다.
    - 빌더를 사용하면 가변인수를 여러개 사용할 수 있다 >> 빌더가 제공하는 각각의 메서드에 값을 나눠서 가져올 수 있다는 뜻

  </details>
  
  <details>
  <summary><b>Item3 private 생성자나 열거 타입으로 싱글턴임을 보증하라</b></summary>
  
  싱글턴은 인스턴스를 오직 하나만 생성 할 수 있는 클래스
    
- 전형적인 예 : 함수와 같은 무상태 객체나 설계상 유일해야 하는 시스템 컴포넌트
- 단점 : 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어렵다.
    - 타입을 인터페이스로 정의한 다음 인터페이스를 구현해서 만든 싱글턴이 아니라면, 싱글턴 인스턴스를 가짜(mock) 구현으로 대체 할 수 없기 때문에
- 싱글턴 생성 방식 1 : public 필드 방식
    - 생성자는 private로 감춰두고, 유일한 인스턴스에 접근 할 수 있는 수단으로 public static 멤버를 하나 만듬.
    - private 생성자는 public static final 필드를 초기화 할 때 딱 한 번만 호출됨, public이나 protected 생성자가 없어 해당 클래스가 초기화 될 때 만들어진 인스턴스가 전체 시스템에서 하나뿐임을 보장
        - 예외 상황 : 권한이 있는 클라이언트는 리플렉션 API인 AccessibleObject.setAccessible을 사용하여 private 생성자를 호출 할 수 있음,, >> 방어를 위해 생성자를 수정하여 두번째 객체가 생성되려 할 때 예외를 던지면 된다.  
    - 장점 
        - 해당 클래스가 싱글턴임이 API에 명백히 드러난다. 
            - public static 필드가 final 이므로 절대로 다른 객체를 참조 할 수 없다.
        - 간결함
- 싱글턴 생성 방식 2 : 정적 팩터리 메서드를 public static 멤버로 제공
    - 

  
  </details>
  
  <details>
  <summary><b>Item4 인스턴스화를 막으려거든 private 생성자를 사용하라</b></summary>
  
  </details>
  
  <details>
  <summary><b>Item5 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라</b></summary>
  
  </details>
  
  <details>
  <summary><b>Item6 불필요한 객체 생성을 피하라</b></summary>
  
  </details>
  
  <details>
  <summary><b>Item7 다 쓴 객체 참조를 해제하라</b></summary>
  
  </details>
  
  <details>
  <summary><b>Item8 finalizer와 cleaner 사용을 피하라</b></summary>
  
  </details>
  
  <details>
  <summary><b>Item9 try-finally보다는 try-with-resources를 사용하라</b></summary>
  
  </details>
  
</details> 

<details>
  <summary><b>3장 모든 객체의 공통 메서드</b></summary>
  
</details>
