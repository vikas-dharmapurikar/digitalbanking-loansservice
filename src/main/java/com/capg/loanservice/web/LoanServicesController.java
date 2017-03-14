package com.capg.loanservice.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.loanservice.Application;
import com.capg.loanservice.model.Customer;
import com.capg.loanservice.model.Loan;
import com.capg.loanservice.model.Transaction;
import com.capg.loanservice.service.LoanService;

@RestController
@ComponentScan("com.capg.loanservice")
@CrossOrigin
@EnableAutoConfiguration
public class LoanServicesController {

	@Autowired
	private LoanService loanService;
	private static Logger log = Logger.getLogger(LoanServicesController.class);
	 
	@RequestMapping(value="/loanservices/{customerId}/loans",method = RequestMethod.GET)
    public List<Loan> getAllLoansofCustomer(@PathVariable  int customerId) {
	    Customer customer=new Customer();
	    customer.setCustomerId(customerId);
	    log.info("Request Mapped");
	    List<Loan> listLoan=loanService.getLoans(customer);
	    return listLoan;
    }
	
	@RequestMapping(value="/loanservices/{loanId}/loan",method = RequestMethod.GET)
    public Loan getLoanById(@PathVariable  int loanId) {
	    Loan loan=loanService.getLoanById(loanId);
	    log.info("Request Mapped");
	    return loan;
    }

	@RequestMapping(value="/loanservices/{loanAccountNo}/{startDate}/{endDate}/getRecentTransactions"
			,method = RequestMethod.POST)
	public List<Transaction> getRecentTransactions(@PathVariable Integer loanAccountNo
			, @PathVariable String startDate
			, @PathVariable String endDate) {
		log.info("Request Mapped");
		return loanService.getRecentTransactions(loanAccountNo, startDate, endDate);
	}
}
//Test commit from Git extensions