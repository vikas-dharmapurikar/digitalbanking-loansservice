package com.capg.loanservice.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.loanservice.model.Transaction;

@Repository
@Transactional
public interface TransactionDao extends JpaRepository<Transaction,Integer> {
	
	@Query("SELECT p FROM Transaction p WHERE loanAccountNo = ?1 "
			+ "and emiDate between ?2 AND ?3 ORDER by emiDate DESC")
	List<Transaction> getTransactions(Integer loanAccountNo, Date startDate, Date endDate);
}
