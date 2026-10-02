package repository;

import entity.BaseEntity;

public abstract class AbstractBaseRepository<E extends BaseEntity<I>, I>
        implements BaseRepository<E, I> {


}
