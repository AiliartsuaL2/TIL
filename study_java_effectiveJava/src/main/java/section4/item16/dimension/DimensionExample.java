package section4.item16.dimension;

import java.awt.*;

public class DimensionExample {
    public static void main(String[] args) {
        Button button = new Button("hello button");
        button.setBounds(0,0,20,10);
        Dimension size = button.getSize();
        // Dimension의 클래스의 필드가 public임 (같은 패키지가 아님에도 접근 가능)
        System.out.println(size.width);
        System.out.println(size.height);
    }
    private static void doSomething(Dimension dimension){
        // 작업을 할 때 public 필드의경우 copy를 해야 안전하게 사용 가능하기 떄문에 copy를 하는 순간부터 불필요한 작업이 됨
        Dimension localDimension = new Dimension();
        localDimension.height = dimension.height;
        localDimension.width = dimension.width;
    }
}
