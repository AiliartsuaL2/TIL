package thread.executor.test;

public class OrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234"; // 예시 주문 번호
//        OrderService orderService = new OldOrderService();
        NewOrderService orderService = new NewOrderService();
        try {
            orderService.order(orderNo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            orderService.close();
        }
    }
}
