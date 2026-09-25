package service;

import dto.BookCreateRequest;
import dto.BookUpdateRequest;
import entity.Book;
import repository.BookRepository;
import util.Validator;

import java.util.List;

public class BookService {

    private static final String TITLE_REQUIRED_MESSAGE = "Title cannot be empty";
    private static final String BOOK_NOT_FOUND_MESSAGE = "Book not found";
    private static final String BOOK_ALREADY_EXISTS_MESSAGE = "Book with this title already exists";

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookCreateRequest request) {
        Validator.notNull(request.title(), TITLE_REQUIRED_MESSAGE);

        Book existingBook = bookRepository.findByTitle(request.title());
        Validator.isNull(existingBook, BOOK_ALREADY_EXISTS_MESSAGE);

        Book newBook = new Book();
        newBook.setAuthor(request.author());
        newBook.setTitle(request.title());
        newBook.setAvailable(request.available());

        bookRepository.save(newBook);
    }

    public void updateBook(BookUpdateRequest request) {
        Validator.notNull(request.title(), TITLE_REQUIRED_MESSAGE);

        Book book = findBookByTitleOrThrow(request.title());

        book.setAuthor(request.author());
        book.setTitle(request.title());
        book.setAvailable(request.available());

        bookRepository.update(book);
    }

    public void deleteBook(int id) {
        Book book = findBookByIdOrThrow(id);
        bookRepository.deleteById(book.getId());
    }

    public Book findById(int id) {
        return findBookByIdOrThrow(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    private Book findBookByIdOrThrow(int id) {
        Book book = bookRepository.findById(id);
        Validator.notNull(book, BOOK_NOT_FOUND_MESSAGE);
        return book;
    }

    private Book findBookByTitleOrThrow(String title) {
        Book book = bookRepository.findByTitle(title);
        Validator.notNull(book, BOOK_NOT_FOUND_MESSAGE);
        return book;
    }
}