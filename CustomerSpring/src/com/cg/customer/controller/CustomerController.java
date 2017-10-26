package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.ICustomerService;

@Controller
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	
	@RequestMapping("/index")
	public String firtsPage(){
		return "index";
	}
	
	@RequestMapping("/Start")
	public String goToStart(Model m){
		m.addAttribute("bean",new Customer());
		return "customerRegForm";
	}
	
	@RequestMapping("/reg")
	public ModelAndView registration(@Valid @ModelAttribute("bean") Customer cust,BindingResult bindres,Model m){
		if(bindres.hasErrors()){
			//return "customerRegForm";
			return new ModelAndView("customerRegForm");
		}
		service.addDetails(cust);
		//m.addAttribute("k",cust);
		return new ModelAndView("RegistrationSuccess", "k", cust);
		//return "RegistrationSuccess";
	}
	
	
	@RequestMapping("/Find")
	public ModelAndView goToFind(){
		List<Integer> custId=service.retrieveAllIds();
		return new ModelAndView("custIdFind","custId",custId);
	}
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerDetails", "k", cust);
	}
	
	
	@RequestMapping("/FindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	

	@RequestMapping("/Delete")
	public ModelAndView goToDelete(){
		List<Integer> custId=service.retrieveAllIds();
		return new ModelAndView("custIdDelete","custId",custId);

	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int custId){
		/*Customer cust = service.retrieveById(custId);
		System.out.println(cust);*/
		service.deleteDetails(custId);
		return "deleteCust";
	}
}
	

	
	
