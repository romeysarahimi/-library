package repository;

import entity.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity<I>, I> {

    void save(E entity);

    void update(E entity);

    E findById(I id);

    List<E> findAll();

    void delete(E entity);

    void deleteById(I id);

}
