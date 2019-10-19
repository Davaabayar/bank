package edu.mum.cs.cs425.labs.bank.service;

import java.util.List;

import edu.mum.cs.cs425.labs.bank.model.Account;

public interface AccountService {
	public abstract List<Account> getAllAccount();
	public abstract Account addAccount(Account account);
	public abstract Double calcNetLiquidity();
}
