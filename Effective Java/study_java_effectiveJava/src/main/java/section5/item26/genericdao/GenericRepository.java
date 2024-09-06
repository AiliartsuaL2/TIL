package section5.item26.genericdao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

// 이렇게 동일한
public class GenericRepository<T extends Entity> {
    private Set<T> generics;

    public GenericRepository() {
        this.generics = new HashSet<>();
    }

    public Optional<T> findById(Long id) {
        return generics.stream().filter(a -> a.getId().equals(id)).findAny();
    }

    public void add(T t) {
        this.generics.add(t);
    }
}
