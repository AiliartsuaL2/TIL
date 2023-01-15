package item03.staticfactory;

// 제네릭 싱글톤 팩토리
public class MetaElvis<T> { // <T>가 인스턴스 스콥이고
    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis(){}

    @SuppressWarnings("unchecked")
    public static <E> MetaElvis<E> getInstance(){return (MetaElvis<E>) INSTANCE; } // 제네릭 싱글톤 팩토리 가능,,
            // 이 <E>는 스태틱한 스콥
    public void say(T t){
        System.out.println(t);
    }

    public void leaveTheBuilding(){
        System.out.println("저는 엘비스입니다.");
    }

    public static void main(String[] args) {
        MetaElvis<String> elvis1 = MetaElvis.getInstance();
        MetaElvis<Integer> elvis2 = MetaElvis.getInstance();
        System.out.println(elvis1.equals(elvis2)); // 같은 인스턴스임,, 근데 타입이 다르기 떄문에 ==비교는 안됨,
    }

}
