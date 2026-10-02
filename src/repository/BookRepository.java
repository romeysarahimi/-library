package repository;

import entity.Book;

public interface BookRepository extends BaseRepository<Book,Integer> {

    Book findByTitle(String title);

}
