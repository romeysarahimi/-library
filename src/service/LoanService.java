package service;

import entity.Book;
import entity.Loan;
import entity.Member;
import repository.BookRepository;
import repository.LoanRepository;
import repository.MemberRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class LoanService {
    //    TODO: implement this class
    private LoanRepository loanRepository;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public void lendBook(int memberId, int bookId) {

        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new RuntimeException("Member not found.");
        }

        Book book = bookRepository.findById(bookId);

        if (book == null) {
            throw new RuntimeException("Book not found.");
        }

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available.");
        }

        Loan loan = new Loan();

        loan.setBookId(bookId);
        loan.setMemberId(memberId);
        loan.setLoanDate(LocalDate.now());

        book.setAvailable(false);

        bookRepository.update(book);
        loanRepository.save(loan);

    }

    public void returnBook(int loanId) {

        Loan loan = loanRepository.findById(loanId);

        if (loan == null) {
            throw new RuntimeException("Loan not found");
        }

        if (loan.getReturnDate() != null) {
            throw new RuntimeException("Book has already been returned.");
        }

        loan.setReturnDate(LocalDate.now());

        loanRepository.update(loan);

        Book book = bookRepository.findById(loan.getId());

        if (book != null) {
            book.setAvailable(true);
            bookRepository.update(book);
        }
    }

    public List<Loan> findActiveLoans() {

        return loanRepository.findActiveLoans();
    }
}
