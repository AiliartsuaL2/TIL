package item03.functionalinterface;

@FunctionalInterface // 마킹용으로 붙임, 메서드가 2개이상인경우 컴파일단에서 에러 체크해줌, 붙여주는게 좋음
public interface MyFunction {
    String valueOf(Integer integer); // 메서드 하나만 있어야 성립
}
