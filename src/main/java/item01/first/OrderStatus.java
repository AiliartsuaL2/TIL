package item01.first;

public enum OrderStatus {
    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    private int number; //Enum도 필드를 가질 수 있음

    OrderStatus(int number){ //Enum도 생성자를 가질 수 있음
        this.number = number;
    }


}
