package com.altsystem.customerregistration;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.altsystem.customerregistration.controllers.CustomersController;
import com.altsystem.customerregistration.entities.Customers;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerResourceTest extends CustomerRegistrationApplicationTests {

	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private CustomersController customersController;
	
	@Before
	public void setUp() {
		this.mocMvc = MockMvcBuilders.standaloneSetup(customersController).build();
	}

	private static final String PATH = "/api/customer/v1.0";
	
	@Test
	public void createCustomerWithCorrectData_ReturnStatusCode201() throws Exception {
		
		Customers customer = new Customers(null, "Cliente Teste API", "99999999999", "Rua dos Testes, 99");
				

		String json = new ObjectMapper().writeValueAsString(customer);
		
		mocMvc.perform(MockMvcRequestBuilders.post(PATH)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			   	.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header()
				.string("location", Matchers.containsString("http://localhost/api/customer/v1.0")));
		
		
	}
	
	
 }
