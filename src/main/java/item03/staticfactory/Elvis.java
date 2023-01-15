package item03.staticfactory;

import item03.field.ElvisReflection;

public class Elvis implements Singer {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis(){}; // 생성자
    //public static Elvis getInstance(){return INSTANCE;} // 정적 팩토리 메서드로 싱글턴 인스턴스 반환
    public static Elvis getInstance(){return new Elvis();}; // 싱글턴에서 다른 인스턴스 반환을 원하는경우 간단하게 변경 가능

    public void leaveTheBuilding(){
        System.out.println("안녕하세요 엘비스 입니다.");
    }

    public void sing(){
        System.out.println("노래를 부르는 중입니다.");
    }


    public static void main(String[] args) { // 밖에서 사용했다고 가정
        Elvis elvis = Elvis.getInstance(); // 싱글턴 인스턴스
        elvis.leaveTheBuilding();

        System.out.println(Elvis.getInstance());
        System.out.println(Elvis.getInstance());

    }

}
