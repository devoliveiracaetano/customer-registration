package com.altsystem.customerregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.altsystem.customerregistration.entities.Customers;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Long>{

	
	
}
