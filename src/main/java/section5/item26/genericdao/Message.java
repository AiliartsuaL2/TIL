package section5.item26.genericdao;

public class Message implements Entity{
    private Long id;
    private String body;

    @Override
    public Long getId() {
        return null;
    }

    public String getBody() {
        return body;
    }
}
