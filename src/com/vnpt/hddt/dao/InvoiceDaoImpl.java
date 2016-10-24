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

import com.vnpt.hddt.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao{

	@Autowired
    @Resource(name = "dataSource")
    DataSource dataSource;
	
	@Override
	public Invoice getInvoiceById(int id) {
		String sql = "select * from "+ TB_NAME + " where id = ?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			Invoice invoice = (Invoice) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Invoice>(){
				@Override
				public Invoice mapRow(ResultSet rs, int arg1) throws SQLException {
					Invoice inv = new Invoice(rs.getInt("id"), rs.getString("Number"), rs.getString("Datetime"), rs.getInt("OwnerId"),
							rs.getString("Price"), rs.getBoolean("Status"), rs.getString("Duedate"), rs.getInt("Csdk"), rs.getInt("Csck"), rs.getString("Type"));
					
					return inv;
				}
				
			});
			return invoice;
		}catch(Exception e){
			return null;
		}		
		
	}

	@Override
	public List<Invoice> getOwnerInvoiceFollowPeriod(int ownerID, String from, String to) {
		List<Invoice> invoiceList = new ArrayList<>();
		String sql = "select * from " + TB_NAME +" where OwnerId=? and ( Datetime between ? and ? );";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{ownerID, from, to};
		try{
			List <Map<String, Object>> invoiceRows = jdbcTemplate.queryForList(sql, params);
			for(Map<String, Object> ir : invoiceRows){
				Invoice invoice = new Invoice();
				invoice.set_id(Integer.parseInt(String.valueOf(ir.get("id"))));
				invoice.set_Number(String.valueOf(ir.get("Number")));
				invoice.set_DateTime(String.valueOf(ir.get("Datetime")));
				invoice.set_OwnerId(Integer.parseInt(String.valueOf(ir.get("OwnerId"))));
				invoice.set_Price(String.valueOf(ir.get("Price")));
				if(String.valueOf(ir.get("Status")).equals("1")){
					invoice.set_Status(true);
				}else{
					invoice.set_Status(false);
				}
				invoice.set_Duedate(String.valueOf(ir.get("Duedate")));
				invoice.set_Csdk(Integer.parseInt(String.valueOf(ir.get("Csdk"))));
				invoice.set_Csck(Integer.parseInt(String.valueOf(ir.get("Csck"))));
				invoice.set_Type(String.valueOf(ir.get("Type")));
				
				invoiceList.add(invoice);
			}
			return invoiceList;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Invoice> getOwnerInvoiceFollowType(int ownerID, String type) {
		List<Invoice> invoiceList = new ArrayList<>();
		String sql = "select * from " + TB_NAME +" where OwnerId=? and Type=?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{ownerID, type};
		try{
			List <Map<String, Object>> invoiceRows = jdbcTemplate.queryForList(sql, params);
			for(Map<String, Object> ir : invoiceRows){
				Invoice invoice = new Invoice();
				invoice.set_id(Integer.parseInt(String.valueOf(ir.get("id"))));
				invoice.set_Number(String.valueOf(ir.get("Number")));
				invoice.set_DateTime(String.valueOf(ir.get("Datetime")));
				invoice.set_OwnerId(Integer.parseInt(String.valueOf(ir.get("OwnerId"))));
				invoice.set_Price(String.valueOf(ir.get("Price")));
				if(String.valueOf(ir.get("Status")).equals("1")){
					invoice.set_Status(true);
				}else{
					invoice.set_Status(false);
				}
				invoice.set_Duedate(String.valueOf(ir.get("Duedate")));
				invoice.set_Csdk(Integer.parseInt(String.valueOf(ir.get("Csdk"))));
				invoice.set_Csck(Integer.parseInt(String.valueOf(ir.get("Csck"))));
				invoice.set_Type(String.valueOf(ir.get("Type")));
				
				invoiceList.add(invoice);
			}
			return invoiceList;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Invoice> getAllInvoiceFollowOwner(int ownerID) {
		List<Invoice> invoiceList = new ArrayList<>();
		String sql = "select * from " + TB_NAME +" where OwnerId=?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try{
			List <Map<String, Object>> invoiceRows = jdbcTemplate.queryForList(sql, ownerID);
			for(Map<String, Object> ir : invoiceRows){
				Invoice invoice = new Invoice();
				invoice.set_id(Integer.parseInt(String.valueOf(ir.get("id"))));
				invoice.set_Number(String.valueOf(ir.get("Number")));
				invoice.set_DateTime(String.valueOf(ir.get("Datetime")));
				invoice.set_OwnerId(Integer.parseInt(String.valueOf(ir.get("OwnerId"))));
				invoice.set_Price(String.valueOf(ir.get("Price")));
				if(String.valueOf(ir.get("Status")).equals("1")){
					invoice.set_Status(true);
				}else{
					invoice.set_Status(false);
				}
				invoice.set_Duedate(String.valueOf(ir.get("Duedate")));
				invoice.set_Csdk(Integer.parseInt(String.valueOf(ir.get("Csdk"))));
				invoice.set_Csck(Integer.parseInt(String.valueOf(ir.get("Csck"))));
				invoice.set_Type(String.valueOf(ir.get("Type")));
				
				invoiceList.add(invoice);
			}
			return invoiceList;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> invoiceList = new ArrayList<>();
		String sql = "select * from " + TB_NAME +";";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try{
			List <Map<String, Object>> invoiceRows = jdbcTemplate.queryForList(sql);
			for(Map<String, Object> ir : invoiceRows){
				Invoice invoice = new Invoice();
				invoice.set_id(Integer.parseInt(String.valueOf(ir.get("id"))));
				invoice.set_Number(String.valueOf(ir.get("Number")));
				invoice.set_DateTime(String.valueOf(ir.get("Datetime")));
				invoice.set_OwnerId(Integer.parseInt(String.valueOf(ir.get("OwnerId"))));
				invoice.set_Price(String.valueOf(ir.get("Price")));
				if(String.valueOf(ir.get("Status")).equals("1")){
					invoice.set_Status(true);
				}else{
					invoice.set_Status(false);
				}
				invoice.set_Duedate(String.valueOf(ir.get("Duedate")));
				invoice.set_Csdk(Integer.parseInt(String.valueOf(ir.get("Csdk"))));
				invoice.set_Csck(Integer.parseInt(String.valueOf(ir.get("Csck"))));
				invoice.set_Type(String.valueOf(ir.get("Type")));
				
				invoiceList.add(invoice);
			}
			return invoiceList;
		}catch(Exception e){
			return null;
		}
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
	public boolean insert(Invoice invoice) {
		String sql = "insert into "+ TB_NAME +" values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{invoice.get_id(), invoice.get_Number(), invoice.get_DateTime(), invoice.get_OwnerId(),
				invoice.get_Price(), invoice.is_Status(), invoice.get_Duedate(), invoice.get_Csdk(), invoice.get_Csck(), invoice.get_Type()};
		int out = jdbcTemplate.update(sql, params);
		if(out != 0) return true;
		return false;
	}

	@Override
	public boolean update(Invoice invoice) {
		String sql = "update "+ TB_NAME +" set Number=?, Datetime=?, OwnerId=?, Price=?, Status=?,"
				+ " Duedate=?, Csdk=?, Csck=?, Type=? where id=?;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] params = new Object[]{invoice.get_Number(), invoice.get_DateTime(), invoice.get_OwnerId(),
				invoice.get_Price(), invoice.is_Status(), invoice.get_Duedate(), invoice.get_Csdk(), invoice.get_Csck(), invoice.get_Type(), invoice.get_id()};
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
