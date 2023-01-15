package item03;

import item03.field.IElvis;

public class MockElvis implements IElvis {
    @Override
    public void leaveTheBuilding(){

    }
    @Override
    public void sing(){
        System.out.println("엘비스 대역이 노래를 부르는 중입니다.");
    }

}
