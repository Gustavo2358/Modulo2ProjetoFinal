package CarRental.repositories;

import java.util.HashSet;
import java.util.Objects;

public class GenericRepository<T>{

    private final HashSet<T> elements = new HashSet<>();
    private static GenericRepository instance = null;

    private GenericRepository(){}

    public static <T> GenericRepository getInstance(){
        if(Objects.isNull(instance))
            instance = new GenericRepository<T>();
        return instance;
    }

    public boolean add(T element) {
        return elements.add(element);
    }

    public HashSet<T> get() {
        return elements;
    }
}
