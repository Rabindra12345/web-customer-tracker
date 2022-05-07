package com.rabindra.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabindra.springdemo.dao.CustomerDAO;
import com.rabindra.springdemo.entity.RabindrasCustomer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<RabindrasCustomer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public  void saveCustomer(RabindrasCustomer theCustommer) {
		
		customerDAO.saveCustomer(theCustommer);
		
	}
//
//	@Override
//	@Transactional
//	public RabindrasCustomer getCustomer(int theId) {
//		
//		return customerDAO.getCustomer(theId);
//	}

	@Override
	@Transactional
	public RabindrasCustomer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
		
	}

//	@Override
//	public void saveCustomer(RabindrasCustomer theCustomer) {
//		
//		customerDAO.saveCustomer(theCustomer);
//		
//	}
	
}
