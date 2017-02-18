package com.capg.loanservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.loanservice.model.Customer;
import com.capg.loanservice.model.Loan;
import com.capg.loanservice.model.Transaction;

@Service
public interface LoanService {
	
	public List<Loan> getLoans(Customer customer);
	public Loan getLoanById(int loanAccountId);
	public List<Transaction> getRecentTransactions(Integer loanId, String startDate, String endDate);
}
