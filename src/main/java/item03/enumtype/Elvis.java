package item03.enumtype;

import item03.field.IElvis;

public enum Elvis implements IElvis { // 인터페이스를 통해 가짜 객체로 테스트도 가능
    INSTANCE;

    public void leaveTheBuilding(){
        System.out.println("지금 나갑니다");
    }

    @Override
    public void sing() {

    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
