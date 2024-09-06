package section5.item26.raw;

public class UseRawType<E> {
    private E e;

    public static void main(String[] args) {
        System.out.println(UseRawType.class);

        UseRawType<String> stringUseRawType = new UseRawType<>();

        System.out.println(stringUseRawType instanceof  UseRawType);
    }
}
