package repository;

import entity.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity<Integer>> {

    void save(E entity);

    void update(E entity);

    E findById(Integer id);

    List<E> findAll();

    void delete(E entity);

    void deleteById(Integer id);

}
