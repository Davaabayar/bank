package edu.mum.cs.cs425.labs.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@NotBlank(message="* Account number is a required field")
	private String accountNumber;
	
	@NotNull(message = "* Balance is required")
	@Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
	@NumberFormat(pattern = "$#,###.##")
	private Double balance;
	
	@OneToOne
	@JoinColumn(name = "accounttype_id", nullable = false)
	@NotNull(message = "* Account type is required")
	private Accounttype accounttype;

	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull(message = "* Customer is required")
	private Customer customer;

	public Account(Long accountId, @NotBlank(message = "* Account number is a required field") String accountNumber,
			Double balance, @NotNull(message = "* Account type is required") Accounttype accounttype,
			@NotNull(message = "* Customer is required") Customer customer) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accounttype = accounttype;
		this.customer = customer;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Accounttype getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(Accounttype accounttype) {
		this.accounttype = accounttype;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
