package section5.item26.genericdao;

import java.time.LocalDate;

public class Schedule implements Entity{
    private Long id;
    private LocalDate localDate;

    public Schedule(Long id, LocalDate localDate) {
        this.id = id;
        this.localDate = localDate;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
