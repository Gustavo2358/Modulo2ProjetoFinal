package CarRental.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getAll();
    boolean add(T t);
}
