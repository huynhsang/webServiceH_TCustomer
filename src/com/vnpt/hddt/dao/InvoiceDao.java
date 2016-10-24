package com.vnpt.hddt.dao;

import java.util.List;

import com.vnpt.hddt.model.Invoice;

public interface InvoiceDao {
	
	public static final String TB_NAME = "Invoice";
	
	public Invoice getInvoiceById(int id);
	
	public List<Invoice> getOwnerInvoiceFollowPeriod(int ownerID, String from, String to);
	
	public List<Invoice> getOwnerInvoiceFollowType(int ownerID, String type);
	
	public List<Invoice> getAllInvoiceFollowOwner(int ownerID);
	
	public List<Invoice> getAllInvoices();
	
	public int getCount();
	
	public boolean insert(Invoice invoice);
	
	public boolean update(Invoice invoice);
	
	public boolean deleteById(int id);
}
