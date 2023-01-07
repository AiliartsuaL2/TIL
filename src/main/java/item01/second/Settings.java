package item01.second;

/** 이 클래스의 인스턴스는 #getInstance를 사용한다.
 * @see #getInstance()
 */
public class Settings {
    private boolean useAutoSetting;
    private boolean useABS;

    private Difficulty difficulty;

    /**
     * 생성자로 객체들을 생성 할 경우, 호출 할 때마다 각자 다른 인스턴스가 생성된다
     * 생성자를 막고, 정적 팩터리 메서드로만 해당 클래스의 인스턴스를 생성 할 수 있도록 private 처리를 함
     * 그러면 인스턴스를 생성해도 private static final 객체에 최초 한 번만 생성이 되고 그 객체를 갖다 쓰는거기 때문에 싱글톤 유지, 해당 인스턴스 통제 가능
     */
//    public static void main(String[] args) {
//        System.out.println(new Settings()); //생성자 자동 생성 후 HashCode 비교
//        System.out.println(new Settings()); // 인스턴스가 각자 다른것을 확인 할 수 있다.
//        System.out.println(new Settings()); // 이렇게 되면 인스턴스 통제 불가능 (아무데서나 마음대로 아주 많이 생성 가능)
//    }

    private Settings(){} // 생성자를 private 으로 선언 후,
    private static final Settings SETTINGS = new Settings(); // private 객체로 해당 생성자를 담아두고
    public static Settings getInstance(){ // 정적 팩터리 메서드를 통해 return 해준다.
        return SETTINGS;
    }

    public static void main(String[] args) {
        System.out.println(getInstance()); // HashCode가 동일해짐 >> 같은 객체
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
