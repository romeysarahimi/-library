package entity;

import java.time.LocalDate;

public class Loan extends BaseEntity<Integer> {
    private int bookId;
    private int memberId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(int id, int bookId, int memberId, LocalDate loanDate, LocalDate returnDate) {
        super(id);
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan() {

    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int book_id) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int member_id) {
        this.memberId = memberId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loan_date) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + getId() +
                ", book_id=" + bookId +
                ", member_id=" + memberId +
                ", loan_date=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
