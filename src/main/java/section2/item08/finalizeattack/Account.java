package section2.item08.finalizeattack;

public class Account {
    private String id;
    public Account(String id){
        this.id  = id;

        if("푸틴".equals(id)){
            throw new IllegalArgumentException("푸틴은 계정을 생성 할 수 없습니다.");
        }
    }

    public void transfer(int money ,String toId){
        System.out.printf("%s 에게 %d 원을 보냈습니다.",toId,money);
    }

    // finalize 공격을 막으려면 부모 객체에서 finalize를 final로 override해서 해당 메서드를 oveeride 못하게 한다.
//    @Override
//    protected final void finalize() throws Throwable {
//    }
}
