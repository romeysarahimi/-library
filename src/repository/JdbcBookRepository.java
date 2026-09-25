package repository;

import entity.Book;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcBookRepository implements BookRepository {

    @Override
    public void save(Book book) {

        String addQuery = "INSERT INTO book (title , author, available) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(addQuery)) {

            pS.setString(1, book.getTitle());
            pS.setString(2, book.getAuthor());
            pS.setBoolean(3, book.isAvailable());

            pS.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book findByTitle(String title) {

        String updateQuery = "SELECT id, title, author, available FROM book WHERE title = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(updateQuery)) {

            pS.setString(1, title);

            ResultSet resultSet = pS.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");
                String titleBook = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean available = resultSet.getBoolean("available");

                return new Book(id, titleBook, author, available);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    public Book findById(int id) {

        String findQuery = "SELECT id, title, author, available FROM book WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pS = connection.prepareStatement(findQuery)) {

            pS.setInt(1, id);

            ResultSet resultSet = pS.executeQuery();

            if (resultSet.next()) {

                int bookId = resultSet.getInt("id");
                String titleBook = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean available = resultSet.getBoolean("available");

                return new Book(id, titleBook, author, available);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public void update(Book book) {

        String updateQuery = "UPDATE book SET  title = ?, author = ?, available = ? WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setBoolean(3, book.isAvailable());
            ps.setInt(4, book.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findAll() {

        List<Book> books = new ArrayList<>();

        String findAllBooks = "SELECT * FROM book";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(findAllBooks)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Book book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getBoolean("available"));

                books.add(book);

            }
            return books;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Book book) {

        String deleteQuery = "Delete FROM book WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement((deleteQuery))) {

            statement.setInt(1, book.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteById(int id) {

        String deleteQuery = "Delete from book where id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement((deleteQuery))) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}


