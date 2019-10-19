package edu.mum.cs.cs425.labs.bank.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotBlank(message="* Customer number is a required field")
	private String customerNumber;
	
	@NotBlank(message="* First name is a required field")
	private String firstName;
	
	private String middleName;
	@NotBlank(message="* Last name is a required field")
	private String lastName;
	
	@NotBlank(message="* Email is a required field")
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
			message = "Enter valid email")
	private String emailAddress;

	@NotEmpty(message = "* Contact phone number is required.")
	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.")
	private String contactPhoneNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
	public Customer(Long customerId, @NotBlank(message = "* Customer number is a required field") String customerNumber,
			@NotBlank(message = "* First name is a required field") String firstName,
			@NotBlank(message = "* Middle name is a required field") String middleName,
			@NotBlank(message = "* Last name is a required field") String lastName, String emailAddress,
			@NotEmpty(message = "* Contact phone number is required.") @Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "* Contact number must be a valid phone number formated as (123) 456-7890.") String contactPhoneNumber,
			LocalDate dob, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.contactPhoneNumber = contactPhoneNumber;
		this.dob = dob;
		this.accounts = accounts;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
