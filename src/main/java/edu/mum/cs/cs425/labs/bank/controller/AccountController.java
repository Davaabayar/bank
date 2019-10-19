package edu.mum.cs.cs425.labs.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.labs.bank.model.Account;
import edu.mum.cs.cs425.labs.bank.model.Customer;
import edu.mum.cs.cs425.labs.bank.service.AccountService;
import edu.mum.cs.cs425.labs.bank.service.AccounttypeService;
import edu.mum.cs.cs425.labs.bank.service.CustomerService;


@Controller
public class AccountController {
	private AccountService accountService;
	private CustomerService customerService;
	private AccounttypeService accounttypeService;
	
	

	public AccountController(AccountService accountService, CustomerService customerService,
			AccounttypeService accounttypeService) {
		this.accountService = accountService;
		this.customerService = customerService;
		this.accounttypeService = accounttypeService;
	}

	@GetMapping(value = "/bank/account/list")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("accounts", accountService.getAllAccount());
		mav.addObject("net", accountService.calcNetLiquidity());
		mav.setViewName("account/list");
		return mav;		
	}
	
	@GetMapping(value = "/bank/account/new")
	public String newSupplier(Model model) {
		model.addAttribute("customers",customerService.getAllCustomers());
		model.addAttribute("typeofaccounts",accounttypeService.getAll());
		model.addAttribute("account", new Account());
		return "account/new";
	}
	
	
	@PostMapping(value = {"/bank/account/new"})
    public String addNewBook(@Valid @ModelAttribute("account") Account account,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	  model.addAttribute("errors", bindingResult.getAllErrors());
        	  model.addAttribute("customers",customerService.getAllCustomers());
        	  model.addAttribute("typeofaccounts",accounttypeService.getAll());
            return "account/new";
        }
        account = accountService.addAccount(account);
        return "redirect:/bank/account/list";
    }
}
