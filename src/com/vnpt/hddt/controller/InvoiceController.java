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

import com.vnpt.hddt.constants.InvRestURIConstants;
import com.vnpt.hddt.dao.InvoiceDao;
import com.vnpt.hddt.model.Invoice;
import com.vnpt.hddt.util.Utility;

@RestController
public class InvoiceController {
	
	@Autowired
	InvoiceDao invoiceDao;
	
	@RequestMapping(value=InvRestURIConstants.GET_INV, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getInvoiceById(@PathVariable("id") int id){
		String response = "";
		Invoice inv = invoiceDao.getInvoiceById(id);
		if(inv != null){
			response = Utility.constructJSON("InvoiceById", true, inv);
		}else{
			response = Utility.constructJSON("InvoiceById", false, "Incorrect id");
		}
		return response;
	}
	
	@RequestMapping(value=InvRestURIConstants.GET_INV_FOLLOW_OWNER, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getInvoiceByOwnerId(@PathVariable("ownerId") int ownerId){
		String response = "";
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceDao.getAllInvoiceFollowOwner(ownerId);
		if(invoices != null){
			response = Utility.constructJSON("InvoiceByOwner", invoices, true);
		}else{
			response = Utility.constructJSON("InvoiceByOwner", false, "Incorrect OwnerId");
		}
		return response;
	}
	
	@RequestMapping(value=InvRestURIConstants.GET_INV_FOLLOW_PERIOD, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getInvoiceByPeriod(@PathVariable("ownerId") int ownerId, @PathVariable("from") String from, @PathVariable("to") String to ){
		String response = "";
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceDao.getOwnerInvoiceFollowPeriod(ownerId, from, to);
		if(invoices != null){
			response = Utility.constructJSON("InvoiceByPeriod", invoices, true);
		}else{
			response = Utility.constructJSON("InvoiceByPeriod", false, "Incorrect OwnerId or date from or to");
		}
		return response;
	}
	
	@RequestMapping(value=InvRestURIConstants.GET_INV_FOLLOW_TYPE, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getInvoiceByType(@PathVariable("ownerId") int ownerId, @PathVariable("type") String type ){
		String response = "";
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceDao.getOwnerInvoiceFollowType(ownerId, type);
		if(invoices != null){
			response = Utility.constructJSON("InvoiceByType", invoices, true);
		}else{
			response = Utility.constructJSON("InvoiceByType", false, "Incorrect OwnerId or type");
		}
		return response;
	}
	
	
	@RequestMapping(value=InvRestURIConstants.GET_ALL_INV, method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getAllInvoices(){
		String response = "";
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = invoiceDao.getAllInvoices();
		if(invoices != null){
			response = Utility.constructJSON("InvoiceByType", invoices, true);
		}else{
			response = Utility.constructJSON("InvoiceByType", false, "Data had been deleted");
		}
		return response;
	}
	
	@RequestMapping(value=InvRestURIConstants.GET_COUNT_INV, method = RequestMethod.GET)
	public @ResponseBody int getCountInvoice(){
		
		return invoiceDao.getCount();
	}
	
	@RequestMapping(value=InvRestURIConstants.INSERT_INV, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Invoice insertInvoice(@RequestBody Invoice invoice){
		if(invoiceDao.insert(invoice)){
			return invoice;
		};
		return null;
	}
	
	@RequestMapping(value=InvRestURIConstants.UPDATE_INV, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody Invoice UpdateInvoice(@RequestBody Invoice invoice){
		if(invoiceDao.update(invoice)){
			return invoice;
		};
		return null;
	}
	
	@RequestMapping(value=InvRestURIConstants.DELETE_INV, method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	public @ResponseBody Invoice deleteInvoiceById(@PathVariable("id") int id){
		Invoice  inv = invoiceDao.getInvoiceById(id);
		invoiceDao.deleteById(id);
		return inv;
	}
}
