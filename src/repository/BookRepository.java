package repository;

import entity.Book;

public interface BookRepository extends BaseRepository<Book> {

    Book findByTitle(String title);

}
