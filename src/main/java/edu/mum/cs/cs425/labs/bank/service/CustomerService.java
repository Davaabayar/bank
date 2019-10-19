package edu.mum.cs.cs425.labs.bank.service;

import java.util.List;

import edu.mum.cs.cs425.labs.bank.model.Customer;

public interface CustomerService {
	public abstract List<Customer> getAllCustomers();
	public abstract Customer addCustomer(Customer customer);
}
