package edu.mum.cs.cs425.labs.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.labs.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
