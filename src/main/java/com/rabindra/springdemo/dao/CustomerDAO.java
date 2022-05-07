package com.rabindra.springdemo.dao;

import java.util.List;

import com.rabindra.springdemo.entity.RabindrasCustomer;

public interface CustomerDAO {

	public List<RabindrasCustomer> getCustomers();

	public void saveCustomer(RabindrasCustomer theCustomer);

	public RabindrasCustomer getCustomer(int theId);

	public void deleteCustomer(int theId);

	
	
}
