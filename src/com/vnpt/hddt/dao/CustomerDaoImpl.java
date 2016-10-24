package com.vnpt.hddt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vnpt.hddt.model.Customer;
import com.vnpt.hddt.util.Utility;

public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
    @Resource(name = "dataSource")
    DataSource dataSource;

	@Override
	public Customer checkLogin(String username, String password) {
		String sql = "select * from " + TB_NAME + " where email = ? and password = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{username, password};
		if(Utility.isNotNull(username) && Utility.isNotNull(password)){
			try{
				Customer customer = (Customer) jdbcTemplate.queryForObject(sql, params, new RowMapper<Customer>(){

					@Override
					public Customer mapRow(ResultSet rs, int i) throws SQLException {
						Customer cus = new Customer(rs.getInt("id"), rs.getString("Name"), rs.getString("Phone"), rs.getString("Address"),
								rs.getDouble("Longtitude"), rs.getDouble("Latitude"), rs.getString("CMND"), rs.getString("Email"), rs.getString("Password"));
						
						return cus;
					}
					
				});
				
				return customer;
			}catch(Exception e){
			}
		}
		return null;
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "select * from "+ TB_NAME + " where id = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Customer>(){

				@Override
				public Customer mapRow(ResultSet rs, int i) throws SQLException {
					Customer cus = new Customer(rs.getInt("id"), rs.getString("Name"), rs.getString("Phone"), rs.getString("Address"),
							rs.getDouble("Longtitude"), rs.getDouble("Latitude"), rs.getString("CMND"), rs.getString("Email"), rs.getString("Password"));
					
					return cus;
				}
				
			});
			return customer;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		List <Customer> customerList = new ArrayList<Customer>();
		String sql = "select * from " + TB_NAME +";";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			List <Map<String, Object>> customerRows = jdbcTemplate.queryForList(sql);
			for(Map<String, Object> cr : customerRows){
				Customer customer = new Customer();
				
				customer.set_id(Integer.parseInt(String.valueOf(cr.get("id"))));
				customer.set_Name(String.valueOf(cr.get("Name")));
				customer.set_Phone(String.valueOf(cr.get("Phone")));
				customer.set_Address(String.valueOf(cr.get("Address")));
				customer.set_Longtitude(Double.parseDouble(String.valueOf(cr.get("Longtitude"))));
				customer.set_Latitude(Double.parseDouble(String.valueOf(cr.get("Latitude"))));
				customer.set_CMND(String.valueOf(cr.get("CMND")));
				customer.set_Email(String.valueOf(cr.get("Email")));
				customer.set_Password(String.valueOf(cr.get("Password")));
				
				customerList.add(customer);
			}
		}catch(Exception e){
			return null;
		}
		
		return customerList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getCount() {
		String sql = "select Count(*) From " + TB_NAME;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int total = jdbcTemplate.queryForInt(sql);
		return total;
	}

	@Override
	public boolean insert(Customer customer) {
		String sql = "insert into "+ TB_NAME +" values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{customer.get_id(), customer.get_Name(), customer.get_Phone(), customer.get_Address(),
				customer.get_Longtitude(), customer.get_Latitude(), customer.get_CMND(), customer.get_Email(), customer.get_Password()};
		int out = jdbcTemplate.update(sql, params);
		if(out != 0) return true;
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		String sql = "update "+ TB_NAME +" set Name=?, Phone=?, Address=?, Longtitude=?, Latitude=?,"
				+ " CMND=?, Email=?, Password=? where id=?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{customer.get_Name(), customer.get_Phone(), customer.get_Address(),
				customer.get_Longtitude(), customer.get_Latitude(), customer.get_CMND(), customer.get_Email(), customer.get_Password(), customer.get_id()};
		int out = jdbcTemplate.update(sql, params);
		if(out != 0) return true;
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "delete from "+ TB_NAME +" where id = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int out = jdbcTemplate.update(sql, id);
		if(out != 0){
			return true;
		}
		return false;
	}

}
