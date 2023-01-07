package item01.first;

public class Order {
    private boolean prime;
    private boolean urgent;
    private Product product;

    /**
     * 컴파일러는 생성자를 통해 객체 생성 시 , 파라미터의 이름을 고려하지 않고, 타입으로만 확인, 따라서 타입이 같은 필드의 경우 값을 달리하고싶으면
     * 아래와 같이 파라미터의 순서를 변경하는등의 꼼수를 사용해야 값을 변경 할 수 있다.
     * 여기서 정적 팩터리 메서드를 사용하면 메서드의 명으로 변경이 가능하다.
     */
//    public Order(Product product, boolean prime){ // 생성자를 통해 객체 생성 1
//        this.prime = prime;
//        this.product = product;
//    }
//    public Order(boolean urgent, Product product){ // 생성자를 통해 객체 생성 2 ,,
//        this.urgent = urgent;
//        this.product = product;
//    }
    /**
     * 정적 펙터리 메서드 사용 시
     */

    public static Order urgentOrder(Product product, boolean urgent){
        Order order = new Order();
        order.urgent = urgent;
        order.product = product;
        return order;
    }

    public static Order primeOrder(Product product, boolean prime){
        Order order = new Order();
        order.prime = prime;
        order.product = product;
        return order;
    }

}
