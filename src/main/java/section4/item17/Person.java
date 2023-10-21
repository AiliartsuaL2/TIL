package section4.item17;

public final class Person {

    // Address는 setter 제공 >> 변경이 가능한 가변 컴포넌트
    //

    private final Address address;

    // 가변 컴포넌트의 경우 getter를 만들지 않거나, 꼭 제공해야한다면 아래처럼 방어코드를 작성해준다.
    public Address getAddress() {
        // 가변 인스턴스에 대한 방어코드
        Address copyOfAddress = new Address();
        copyOfAddress.setStreet(address.getStreet());
        copyOfAddress.setZipCode(address.getZipCode());
        copyOfAddress.setCity(address.getCity());
        return copyOfAddress;
    }

    public Person(Address address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Person joo = new Person(new Address("12345", "abc-1", "Seattle"));
        // 이렇게 Person에는 setter를 제공 하지 않았지만 가변 컴포넌트는 변경될 수 있기 때문에 불변 클래스라고 할 수 없음
        joo.getAddress().setCity("서울");
        System.out.println(joo.address.getCity());
    }
}
