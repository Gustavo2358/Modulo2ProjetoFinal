package CarRental.service;

import CarRental.repositories.Repository;

import java.util.Collection;

public class RepositoryService<E> {

    private Repository<E> repository;

    public void setRepository(Repository<E> repository) {
        this.repository = repository;
    }

    public boolean add(E element) {
        return this.repository.add(element);
    }

    public Collection<E> getAll() {
        return this.repository.getAll();
    }
}
