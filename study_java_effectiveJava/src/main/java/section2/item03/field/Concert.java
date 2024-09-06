package section2.item03.field;

public class Concert {
    private boolean lightsOn;

    private boolean mainStateOpen;

//    private Elvis elvis; // Elvis 없이 (가짜 객체) 테스트 불가능,,
    private IElvis elvis;

//    public Concert(Elvis elvis){
//        this.elvis = elvis;
//    }

    public Concert(IElvis elvis){ // 인터페이스로 인자를 받아 사용
        this.elvis = elvis;
    }

        public void perform(){
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn() {
        return lightsOn;
    }
    public boolean isMainStateOpen(){
        return mainStateOpen;
    }
}
