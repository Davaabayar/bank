package edu.mum.cs.cs425.labs.bank.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.labs.bank.model.Customer;
import edu.mum.cs.cs425.labs.bank.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService service;
	

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping(value = "/bank/customer/list")
	public ModelAndView listProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", service.getAllCustomers());
		mav.setViewName("customer/list");
		return mav;		
	}
	
	@GetMapping(value = "/bank/customer/new")
	public String newSupplier(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/new";
	}
	
	
	@PostMapping(value = {"/bank/customer/new"})
    public String addNewBook(@Valid @ModelAttribute("customer") Customer customer,
                                     BindingResult bindingResult, Model model) {
		System.out.println(customer);
        if (bindingResult.hasErrors()) {
        	  model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        customer = service.addCustomer(customer);
        return "redirect:/bank/customer/list";
    }
}
