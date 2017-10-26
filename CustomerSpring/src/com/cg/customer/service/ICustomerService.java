package com.cg.customer.service;

import java.util.List;

import com.cg.customer.model.Customer;

public interface ICustomerService {

	void addDetails(Customer bean);

	Customer retrieveById(int id);

	List<Customer> retrieveDetails();

	void deleteDetails(int custId);

	List<Integer> retrieveAllIds();

	
}
