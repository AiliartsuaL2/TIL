package section2.item08.finalizeattack;

public class BrokerAccount extends Account{

    public BrokerAccount(String id) {
        super(id);
    }
    @Override
    protected void finalize(){
        this.transfer(1000000,"이주호");
    }
}
