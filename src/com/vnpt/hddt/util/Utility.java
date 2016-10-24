package com.vnpt.hddt.util;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vnpt.hddt.model.Customer;
import com.vnpt.hddt.model.Invoice;

public class Utility {

	/**
     * Null check Method
     * 
     * @param txt
     * @return
     */
	public static boolean isNotNull(String txt){
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}
	
	/**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @param Customer
     * @return
     */
	public static String constructJSON(String tag, boolean status, Customer object){
		JSONObject main  = new JSONObject();
		JSONObject obj = new JSONObject();
		try{
			obj.put("id", object.get_id());
			obj.put("Name", object.get_Name());
			obj.put("Phone", object.get_Phone());
			obj.put("Address", object.get_Address());
			obj.put("Longtitude", object.get_Longtitude());
			obj.put("Latitude", object.get_Latitude());
			obj.put("CMND", object.get_CMND());
			obj.put("Email", object.get_Email());
			obj.put("Password", object.get_Password());
			main.put("tag", tag);
			main.put("status", new Boolean(status));
			main.put("data", obj);
		}catch(JSONException e){
			
		}
		
		return main.toString();
	}
	
	/**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @param Customer
     * @return
     */
	public static String constructJSON(String tag, boolean status, Invoice object){
		JSONObject main  = new JSONObject();
		JSONObject obj = new JSONObject();
		try{
			obj.put("id", object.get_id());
			obj.put("Number", object.get_Number());
			obj.put("Datetime", object.get_DateTime());
			obj.put("OwnerId", object.get_OwnerId());
			obj.put("Price", object.get_Price());
			obj.put("Status", object.is_Status());
			obj.put("Duedate", object.get_Duedate());
			obj.put("Csdk", object.get_Csdk());
			obj.put("Csck", object.get_Csck());
			obj.put("Type", object.get_Type());
			main.put("tag", tag);
			main.put("status", new Boolean(status));
			main.put("data", obj);
		}catch(JSONException e){
			
		}
		
		return main.toString();
	}
	
	/**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @param listCustomer
     * @return
     */
	public static String constructJSON(String tag, boolean status, List<Customer> objects){
		JSONObject main  = new JSONObject();
		JSONArray array = new JSONArray();

		try{
			for (int i=0; i<objects.size(); i++){
				JSONObject obj  = new JSONObject();
				obj.put("id", objects.get(i).get_id());
				obj.put("Name", objects.get(i).get_Name());
				obj.put("Phone", objects.get(i).get_Phone());
				obj.put("Address", objects.get(i).get_Address());
				obj.put("Longtitude", objects.get(i).get_Longtitude());
				obj.put("Latitude", objects.get(i).get_Latitude());
				obj.put("CMND", objects.get(i).get_CMND());
				obj.put("Email", objects.get(i).get_Email());
				obj.put("Password", objects.get(i).get_Password());
				array.put(obj);
			}
			
			main.put("tag", tag);
			main.put("status", new Boolean(status));
			main.put("data", array);
		}catch(JSONException e){
			
		}
		
		return main.toString();
	}
	
	/**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @param listInvoice
     * @return
     */
	public static String constructJSON(String tag, List<Invoice> objects, boolean status){
		JSONObject main  = new JSONObject();
		JSONArray array = new JSONArray();

		try{
			for (int i=0; i<objects.size(); i++){
				JSONObject obj  = new JSONObject();
				obj.put("id", objects.get(i).get_id());
				obj.put("Number", objects.get(i).get_Number());
				obj.put("Datetime", objects.get(i).get_DateTime());
				obj.put("OwnerId", objects.get(i).get_OwnerId());
				obj.put("Price", objects.get(i).get_Price());
				obj.put("Status", objects.get(i).is_Status());
				obj.put("Duedate", objects.get(i).get_Duedate());
				obj.put("Csdk", objects.get(i).get_Csdk());
				obj.put("Csck", objects.get(i).get_Csck());
				obj.put("Type", objects.get(i).get_Type());
				array.put(obj);
			}
			
			main.put("tag", tag);
			main.put("status", new Boolean(status));
			main.put("data", array);
		}catch(JSONException e){
			
		}
		
		return main.toString();
	}
	
	/**
     * Method to construct JSON with Error Msg
     * 
     * @param tag
     * @param status
     * @param err_msg
     * @return
     */
	public static String constructJSON(String tag, boolean status, String err_msg){
		JSONObject obj  =  new JSONObject();
		try {
            obj.put("tag", tag);
            obj.put("status", new Boolean(status));
            obj.put("error_msg", err_msg);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
        }
        return obj.toString();
	}
}
