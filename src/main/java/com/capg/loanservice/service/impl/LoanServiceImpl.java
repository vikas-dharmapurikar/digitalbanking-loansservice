package com.capg.loanservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capg.loanservice.dao.LoanDao;
import com.capg.loanservice.dao.TransactionDao;
import com.capg.loanservice.model.Customer;
import com.capg.loanservice.model.Loan;
import com.capg.loanservice.model.Transaction;
import com.capg.loanservice.service.LoanService;

@Component
@Service
public class LoanServiceImpl implements LoanService{
	static Logger logger = Logger.getLogger(LoanServiceImpl.class);
	
	@Autowired
	private LoanDao loanDao;
	
	@Autowired
	private TransactionDao transactionDao;

	@Value("${max.recent.transactions}")
	private Integer maxRecentTransactions;
	
	@Override
	public List<Loan> getLoans(Customer customer) {
		logger.info("In Service : Finding By Customer");
		return loanDao.findByCustomer(customer);
	}

	@Override
	public Loan getLoanById(int loanAccountId) {
		logger.info("In Service : Finding By Account Id");
		return loanDao.findByLoanAccountId(loanAccountId);
	}
	
	@Override
	public List<Transaction> getRecentTransactions(Integer loanAccountNo, String startDate, String endDate) {
		Date startDt;
		List<Transaction> txList =null;
		try {
			startDt = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			Date endDt =new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
			txList = transactionDao.getTransactions(loanAccountNo, startDt, endDt);

			// Get max 10 recent transactions
			if(txList!= null && txList.size()>maxRecentTransactions){
				txList = txList.subList(0, maxRecentTransactions-1);
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		logger.info("In Service : Getting Recent Transaction");
		return txList;
	}
}
