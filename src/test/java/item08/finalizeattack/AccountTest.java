package item08.finalizeattack;

import org.junit.jupiter.api.Test;
import section2.item08.finalizeattack.Account;
import section2.item08.finalizeattack.BrokerAccount;

class AccountTest {
    @Test
    void 일반계정(){
        Account 이주호 = new Account("이주호");
        이주호.transfer(1000000,"ailiartsua");
    }
    @Test
    void 푸틴계정(){
        Account account = new Account("푸틴");
        account.transfer(100000000,"ailiartsua");
    }

    @Test
    void 브로커를통해보냄() throws InterruptedException {
        Account account = null;
        try {
            account = new BrokerAccount("푸틴");
        }catch (IllegalArgumentException e){
            System.out.println("이러면 . . .");
        }
        System.gc();
        Thread.sleep(3000L);
    }

}