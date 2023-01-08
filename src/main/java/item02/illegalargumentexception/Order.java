package item02.illegalargumentexception;

import java.time.LocalDate;

public class Order {
    public void updateDeliveryDate(LocalDate deliveryDate) throws  IllegalArgumentException, NullPointerException{ // 이런 에러가 발생 할 수 있음을 명시적으로 알려줌
        if(deliveryDate == null){
            throw new NullPointerException("deliveryDate can't be null");
        }
        if(deliveryDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("deliveryDate can't be earlier than" + LocalDate.now()); //어떤 arguemnt가 왜 잘못되었는지 알려주는것이 중요
        }
    }
}
