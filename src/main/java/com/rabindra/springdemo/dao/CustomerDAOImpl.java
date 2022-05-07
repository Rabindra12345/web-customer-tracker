package com.rabindra.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rabindra.springdemo.entity.RabindrasCustomer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFac;
			
	@Override
	public List<RabindrasCustomer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFac.getCurrentSession();
				
		// create a query
		Query<RabindrasCustomer> theQuery = 
				currentSession.createQuery("from RabindrasCustomer order by firstName", RabindrasCustomer.class);
		
		// execute query and get result list
		List<RabindrasCustomer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(RabindrasCustomer theCustomerr) {
		
		//create a hibernate session
		Session currentSession = sessionFac.getCurrentSession();
		
		//save the customemr
		currentSession.saveOrUpdate(theCustomerr);
		
	}

	@Override
	public RabindrasCustomer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFac.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		RabindrasCustomer theCustomer = currentSession.get(RabindrasCustomer.class, theId);
		
		return theCustomer;
	}

	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFac.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from RabindrasCustomer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

//	@Override
//	public RabindrasCustomer getCustomer(int theId) {
//		//create a current session
//		Session currentSession = sessionFac.getCurrentSession();
//
//		
//		//read / retrieve data from db
//		RabindrasCustomer theCustomer = currentSession.get(RabindrasCustomer.class, theId);
//		
//		return theCustomer;
//	}


	

}






