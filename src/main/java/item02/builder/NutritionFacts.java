package item02.builder;

// 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder { // 빌더 클래스를 이너 클래스로 만든다.
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) { // 필수 매개변수만 받는 빌더 생성자
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val) // 리턴타입이 빌더 >> 연쇄적으로 메서드를 호출 가능
        { carbohydrate = val;  return this; }

        public NutritionFacts build() { // 마지막에 해당 객체를 생성하는 메서드
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8) // 필수 파라미터는 생성자 생성시 넣어줘야함, 안하면 컴파일 오류
                .calories(100).sodium(35).carbohydrate(27).build(); // 메서드의 연쇄호출 (메서드 체이닝, 플루언트 API)
    }
}