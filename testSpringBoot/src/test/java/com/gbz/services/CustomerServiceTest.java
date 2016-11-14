package com.gbz.services;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	

	
	@InjectMocks
	CustomerService sut; // System Under Test

	@Mock
	CustomerRepository customerRepositoryMock;

	public static final long CUSTOMER_ID = 1; 
	
	@Test
	public void nameOfTestedFunction_usecase_that_you_want_to_test() {

		// Arrange

		// Act

		// Assert
		assertThat(true, is(true));
		assertThat(10, allOf(is(10),  instanceOf(Integer.class))); 
		assertThat("This a test", containsString("a test")); 
		assertThat(10, is(notNullValue()));
		assertThat(null, is(nullValue())); 
		assertThat("toto", is(not(equalTo("tata")))); 
	}

	@Test
	public void getAllCustomers_getting_all_customers() {
		// Arrange
		List<Customer> customersFixture = Arrays.asList(new Customer("a", "a"), new Customer("b", "b"),
				new Customer("c", "c"));
		when(customerRepositoryMock.findAll()).thenReturn(customersFixture);

		// Act
		List<Customer> result = sut.getAllCustomers();

		// Assert
		verify(customerRepositoryMock).findAll();
		assertThat(result, is(customersFixture));

	}

	@Test
	public void getCustomerById_get_simple_customer() {

		// Arrange
		Customer customerFixture = new Customer("jean",  "jeanjean"); 
		when(customerRepositoryMock.findOne(CUSTOMER_ID)).thenReturn(customerFixture); 
				
		// Act
		Customer result = sut.getCustomerById(CUSTOMER_ID); 
		
		// Assert
		verify(customerRepositoryMock).findOne(CUSTOMER_ID); 
		assertThat(result, is(customerFixture));
	}

	@Test
	public void createCustomer_test_creating_user() {

		// Arrange
		Customer dummyCustomer = new Customer("",  ""); 
		Customer customerFixture = new Customer("jean",  "jeanjean"); 
		when(customerRepositoryMock.save(dummyCustomer)).thenReturn(customerFixture);
		
		// Act
		Customer result = sut.createCustomer(dummyCustomer);
		
		// Assert
		verify(customerRepositoryMock).save(dummyCustomer); 
		assertThat(result, is(customerFixture));
	}

	@Test
	public void updateCustomer_test_updating_user() {

		// Arrange
		Customer dummyCustomer = new Customer("",  ""); 
		Customer customerFixture = new Customer("jean",  "jeanjean");
		when(customerRepositoryMock.findOne(CUSTOMER_ID)).thenReturn(dummyCustomer); 
		when(customerRepositoryMock.save(dummyCustomer)).thenReturn(customerFixture);
		
		// Act
		Customer result = sut.updateCustomer(CUSTOMER_ID, new Customer("test",  "test")); 
		
		// Assert
		verify(customerRepositoryMock).save(dummyCustomer); 
		verify(customerRepositoryMock).findOne(CUSTOMER_ID); 
		assertThat(result, is(customerFixture));
	}

	@Test
	public void deleteCustomer_test_deleting_user() {

		// Arrange
		Mockito.doNothing().when(customerRepositoryMock).delete(CUSTOMER_ID);
		
		// Act
		sut.deleteCustomer(CUSTOMER_ID);
		
		// Assert
		verify(customerRepositoryMock).delete(CUSTOMER_ID);
	}

}
