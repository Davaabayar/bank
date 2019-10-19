package edu.mum.cs.cs425.labs.bank.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.bank.model.Customer;
import edu.mum.cs.cs425.labs.bank.respository.CustomerRepository;
import edu.mum.cs.cs425.labs.bank.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService{
	private CustomerRepository repo;

	@Autowired
	public CustomerServiceImp(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll(Sort.by("lastName"));
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	
}
