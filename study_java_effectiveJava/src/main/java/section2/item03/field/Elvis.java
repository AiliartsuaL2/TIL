package section2.item03.field;

import java.io.Serializable;

public class Elvis implements IElvis, Serializable {

    /**
     * 싱글톤 오브젝트
     */
    public static final Elvis INSTANCE = new Elvis(); // 인스턴스
    private static boolean created; // 리플렉션 공격을 막기위함
    private Elvis(){
        if(created){ // 최초에 생성 할 때에는 정상적으로 생성하고, 이후에 created 플래그에 의해 생성을 못하게 막음.
            throw new UnsupportedOperationException("can't be created by constructor.");
        }
        created = true;

    } // private 생성자

    public void leaveTheBuilding(){
        System.out.println("안녕하세요 엘비스 입니다.");
    }

    public void sing(){
        System.out.println("노래를 부르는 중입니다.");
    }


    public static void main(String[] args) { // 밖에서 사용했다고 가정
        Elvis elvis = Elvis.INSTANCE; // 싱글턴 인스턴스
        elvis.leaveTheBuilding();
    }

    private Object readResolve(){
        return INSTANCE;
    }


}
