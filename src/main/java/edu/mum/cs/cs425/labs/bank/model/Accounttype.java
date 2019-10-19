package edu.mum.cs.cs425.labs.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "accounttypes")
public class Accounttype {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "accounttype_id")
	private Long accounttypeId;
	
	@NotBlank(message="* Account type name is a required field")
	private String accountTypeName;	
	
	@OneToOne(mappedBy = "accounttype")
    private Account account;

	public Accounttype() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounttype(Long accounttypeId,
			@NotBlank(message = "* Account type name is a required field") String accountTypeName, Account account) {
		super();
		this.accounttypeId = accounttypeId;
		this.accountTypeName = accountTypeName;
		this.account = account;
	}

	public Long getAccounttypeId() {
		return accounttypeId;
	}

	public void setAccounttypeId(Long accounttypeId) {
		this.accounttypeId = accounttypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
