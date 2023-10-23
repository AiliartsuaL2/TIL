package section4.item17.memorymodel;

public class Ailiartsua {
    private int x;
    private int y;

    public Ailiartsua() {
        this.x = 1;
        this.y = 2;
    }

    public static void main(String[] args) {
        // 일반적인 프로그램의 실행 순서 라고 생각
        // Object w = new Ailiartsua()
        // w.x = 1;
        // w.y = 2;
        // Ailiartsua = w

        // JMM은 한 쓰레드 내에서 유효한지 유효하지 않은지 확인하는 규칙
        // 하지만 싱글 스레드 환경에서만 검증을 진행하기 때문에 아래같은 상황이 생길 수 있음

        // 이론상 아래와 같이 구현체가 변경 될 수 있음
        // Object w = new Ailiartsua()
        // Ailiartsua ailiartsua =  w
        // 멀티스레드 환경에서는  생성자를 통해 위 ailiartsu 인스턴스에 값을 할당하기 전에 해당 인스턴스를 참조 하는 경우가 생길수도 있음
        // ailiartsua.x = 1;
        // ailiartsua.y = 2;

        // 하지만 필드에 final을 사용한다면, 스펙상 인스턴스의 필드가 초기화가 된 이후에 다른 쓰레드가 해당 인스턴스를 참조 할 수 있음.
        // 다른 쓰레드가 참조하려면 final이 초기화 될 떄까지 기다려야함!
        // >> 멀티 스레드 환경에서 해당 필드에 값이 할당이 됨을 보장하고 싶다면 필드에 final 키워드를 붙여주자/

        // 이론상 그렇지만 실제로는 아닐 확률이 크다고 함. . .
        Ailiartsua ailiartsua = new Ailiartsua();
    }
}
