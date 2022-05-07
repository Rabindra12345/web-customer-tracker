package com.rabindra.springdemo.service;

import java.util.List;

import com.rabindra.springdemo.entity.RabindrasCustomer;

public interface CustomerService {
	
	public List<RabindrasCustomer> getCustomers();

	public void saveCustomer(RabindrasCustomer theCustomer);

	public RabindrasCustomer getCustomer(int theId);

	public void deleteCustomer(int theId);

//	public RabindrasCustomer getCustomer(int theId);
	
//	public void saveCustomer(RabindrasCustomer theCustomer);
	
}
