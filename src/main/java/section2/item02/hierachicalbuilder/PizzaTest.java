package section2.item02.hierachicalbuilder;


import static section2.item02.hierachicalbuilder.NyPizza.Size.*;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}