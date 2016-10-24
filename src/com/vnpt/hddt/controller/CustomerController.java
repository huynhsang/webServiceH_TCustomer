package com.vnpt.hddt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vnpt.hddt.constants.CusRestURIConstants;
import com.vnpt.hddt.dao.CustomerDao;
import com.vnpt.hddt.model.Customer;
import com.vnpt.hddt.util.Utility;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value=CusRestURIConstants.DO_LOGIN, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String checkLogin(@PathVariable("username") String usr, @PathVariable("password") String pss){
		String response = "";
		Customer cus = customerDao.checkLogin(usr, pss);
		if(cus != null){
			response = Utility.constructJSON("checklogin", true, cus);
		}else{
			response = Utility.constructJSON("checklogin", false, "Incorrect Username or Password!");
		}
		return response;
	}
	
	@RequestMapping(value=CusRestURIConstants.GET_CUS, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getCustomer(@PathVariable("id") int id){
		String response = "";
		Customer cus = customerDao.getCustomerById(id);
		if(cus != null){
			response = Utility.constructJSON("customerById", true, cus);
		}else{
			response = Utility.constructJSON("customerById", false, "Incorrect id");
		}
		return response;
	}
	
	@RequestMapping(value=CusRestURIConstants.GET_ALL_CUS, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String getAllCustomers(){
		String response = "";
		List<Customer> customerList = new ArrayList<>();
		customerList = customerDao.getAllCustomer();
		if(customerList != null){
			response = Utility.constructJSON("allCustomer", true, customerList);
		}else{
			response = Utility.constructJSON("allCustomer", false, "Data had been deleted");
		}
		return response;
	}
	
	@RequestMapping(value=CusRestURIConstants.GET_COUNT_CUS, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody int getCountCustomer(){
		return customerDao.getCount();
	}
	
	@RequestMapping(value=CusRestURIConstants.INSERT_CUS, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Customer insertCustomer(@RequestBody Customer customer){
		if(customerDao.insert(customer)){
			return customer;
		}
		return null;
	}
	
	@RequestMapping(value=CusRestURIConstants.UPDATE_CUS, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer){
		if(customerDao.update(customer)){
			return customer;
		}
		return null;
	}
	
	@RequestMapping(value=CusRestURIConstants.DELETE_CUS, method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	public @ResponseBody boolean deleteCustomerById(@PathVariable("id") int id){
		return customerDao.deleteById(id);
	}
}
