package repository;

import entity.Loan;

import java.util.List;

public interface LoanRepository extends BaseRepository<Loan,Integer> {


    List<Loan> findActiveLoans();

}
