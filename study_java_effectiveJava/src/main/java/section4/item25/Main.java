package section4.item25;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
        // -> 예상 결과(Utensil + Main) : pancake
        // -> 컴파일이 Dessert + Main 되었다면 potpie가 나옴
    }
}
