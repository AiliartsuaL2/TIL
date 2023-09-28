package item14;

import java.math.BigDecimal;

/**
 * CompareTo 규약
 */
public class CompareToConvention {
    public static void main(String[] args) {
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(43323123);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // 반사성 : 자기 자신을 비교 할 경우 같고, 한쪽이 크면 반대쪽은 작다.
            // Comparable에 정의되어있는 값은 1,0,-1이 아닌 양수,0, 음수로 정의되어있음
        System.out.println(n1.compareTo(n1));
        System.out.println(n1.compareTo(n2));
        System.out.println(n2.compareTo(n1));

        // 추이성 : a가 b보다 크고 b가 c보다 큰 경우, a는 항상 c보다 크다.
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        // 일관성 : a와 b가 같은경우 a가 c보다 크면 b도 c보다 크다.
        System.out.println(n4.compareTo(n2));
        System.out.println(n2.compareTo(n1));
        System.out.println(n4.compareTo(n1));

        // compareTo가 0이라면, equals는 true여야 한다. (Required 조건 아님)
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.equals(oneZeroZero));

    }
}
