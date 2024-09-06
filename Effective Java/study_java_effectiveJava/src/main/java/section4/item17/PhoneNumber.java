package section4.item17;

public final class PhoneNumber {
    private short areaCode, prefix, lineNum;
    // 생성자를 통해서 값을 설정하고, setter를 없애서 변경 불가능하게 만
    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }
}
