//package item02.inflearntip;
//
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//
//@Builder // 롬복 어노테이션, 빌더를 생성해줌,
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//public class NutritionFacts {
//    private final int servingSize;
//    private final int servings;
//    private final int calories;
//    private final int fat;
//    private final int sodium;
//    private final int carbohydrate;
//
//
//    public static void main(String[] args) {
//        NutritionFacts nutritionFacts = new NutritionFactsBuilder()
//                .servingSize(10)
//                .servings(100)
//                .calories(200).build();
//    }
//}