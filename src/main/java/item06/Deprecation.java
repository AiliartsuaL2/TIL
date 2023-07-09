package item06;

public class Deprecation {

    /**
     * Java doc에 사용되는 어노테이션
     * @deprecated
     * {@link #abcd2{name}
     */
    @Deprecated(forRemoval = true, since = "v1.2")
    // 컴파일 레벨에서 사용되는 어노테이션
    public String abcd(){
        return "";
    }

    public String abcd2(String name){
        return name;
    }
}
