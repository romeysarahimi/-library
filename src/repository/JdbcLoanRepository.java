package repository;

import entity.Loan;
import util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcLoanRepository implements LoanRepository {

    @Override
    public void save(Loan loan) {

        String saveQuery = "INSERT INTO loan (book_id, member_id, loan_date, return_date) VALUES (?, ?, ?, ?) ";
        Date returnDate = null;

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(saveQuery);

            ps.setInt(1, loan.getBookId());
            ps.setInt(2, loan.getMemberId());
            ps.setDate(3, Date.valueOf(loan.getLoanDate()));

            if (loan.getReturnDate() != null) {
                returnDate = Date.valueOf(loan.getReturnDate());

            }
            ps.setDate(4, returnDate);
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Loan findById(Integer id) {

        String findQuery = "SELECT id, book_id, member_id, loan_date, return_date FROM loan WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(findQuery);

            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                Date returnDate = resultSet.getDate("return_date");

                LocalDate localReturnDate = null;

                if (returnDate != null) {
                    localReturnDate = returnDate.toLocalDate();
                }

                return new Loan(
                        resultSet.getInt("id"),
                        resultSet.getInt("book_id"),
                        resultSet.getInt("member_id"),
                        resultSet.getDate("loan_date").toLocalDate(),
                        localReturnDate
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Loan> findAll() {
        return List.of();
    }

    @Override
    public void delete(Loan entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Loan loan) {

        String updateQuery = "UPDATE loan SET return_date = ? WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(updateQuery);

            Date returnDate = null;

            if (loan.getReturnDate() != null) {
                returnDate = Date.valueOf(loan.getReturnDate());
            }

            ps.setDate(1, returnDate);
            ps.setInt(2, loan.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Loan> findActiveLoans() {

        String findQuery = "SELECT id, book_id, member_id, loan_date, return_date " +
                "FROM loan WHERE return_date IS NULL";

        List<Loan> loans = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(findQuery);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                Loan loan = new Loan(
                        resultSet.getInt("id"),
                        resultSet.getInt("book_id"),
                        resultSet.getInt("member_id"),
                        resultSet.getDate("loan_date").toLocalDate(),
                        null
                );
                loans.add(loan);
            }
            return loans;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
