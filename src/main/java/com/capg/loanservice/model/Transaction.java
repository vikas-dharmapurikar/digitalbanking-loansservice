package com.capg.loanservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "loan_payment_history", catalog="postgres", schema="public")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="emi_no")
	private int emiNo; 
	
	@Column(name="emi_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date emiDate;
	
	@Column(name="emi_amount")
	private Double emiAmount; 
	
	@Column(name="emi_status")
	private String emiStatus;
	
	@Column(name="loan_acc_no")
	private Integer loanAccountNo; 
	
    @Column(name="emi_rejected_tx_no")
	private Double emiRejectedTxNo;

	public int getEmiNo() {
		return emiNo;
	}

	public void setEmiNo(int emiNo) {
		this.emiNo = emiNo;
	}

	public Date getEmiDate() {
		return emiDate;
	}

	public void setEmiDate(Date emiDate) {
		this.emiDate = emiDate;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public String getEmiStatus() {
		return emiStatus;
	}

	public void setEmiStatus(String emiStatus) {
		this.emiStatus = emiStatus;
	}

	public Integer getLoanAccountNo() {
		return loanAccountNo;
	}

	public void setLoanAccountNo(Integer loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	public Double getEmiRejectedTxNo() {
		return emiRejectedTxNo;
	}

	public void setEmiRejectedTxNo(Double emiRejectedTxNo) {
		this.emiRejectedTxNo = emiRejectedTxNo;
	}

	@Override
	public String toString() {
		return "Transaction [emiNo=" + emiNo + ", emiDate=" + emiDate + ", emiAmount=" + emiAmount + ", emiStatus="
				+ emiStatus + ", loanAccountNo=" + loanAccountNo + ", emiRejectedTxNo=" + emiRejectedTxNo + "]";
	}
}