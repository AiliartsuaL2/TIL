package item14;

public class IntOverflow {
    public static void main(String[] args) {
        // 빼기로 비교하면 다음과같이 범위를 벗어나는 수인경우 양수가 나온다.
        System.out.println(-2147483648 - 10);

        // Integer.compare을 하면 정상 비교가 된다.
        System.out.println(Integer.compare(-2147483648,10));
    }
}
