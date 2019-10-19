package edu.mum.cs.cs425.labs.bank.serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.labs.bank.model.Account;
import edu.mum.cs.cs425.labs.bank.model.Accounttype;
import edu.mum.cs.cs425.labs.bank.respository.AccountRepository;
import edu.mum.cs.cs425.labs.bank.respository.AccounttypeRepository;
import edu.mum.cs.cs425.labs.bank.service.AccountService;
import edu.mum.cs.cs425.labs.bank.service.AccounttypeService;

@Service
public class AccounttypeServiceImp implements AccounttypeService{

	private AccounttypeRepository repo;
	private AccountRepository accRepo;
	
	public AccounttypeServiceImp(AccounttypeRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Accounttype> getAll() {
		return repo.findAll();
	}

	

	
}
