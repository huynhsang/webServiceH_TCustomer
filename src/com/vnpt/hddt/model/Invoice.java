package com.vnpt.hddt.model;

import java.io.Serializable;

public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int _id;
	private String _Number;
	private String _DateTime;
	private int _OwnerId;
	private String _Price;
	private boolean _Status;
	private String _Duedate;
	private int _Csdk;
	private int _Csck;
	private String _Type;
	
	public Invoice(){};
	
	public Invoice(int id, String number, String dateTime, int ownerId, String price, boolean status,
			String dueDate, int csdk, int csck, String type){
		this._id = id;
		this._Number = number;
		this._DateTime = dateTime;
		this._OwnerId = ownerId;
		this._Price = price;
		this._Status = status;
		this._Duedate = dueDate;
		this._Csdk = csdk;
		this._Csck = csck;
		this._Type = type;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_Number() {
		return _Number;
	}

	public void set_Number(String _Number) {
		this._Number = _Number;
	}

	public String get_DateTime() {
		return _DateTime;
	}

	public void set_DateTime(String _DateTime) {
		this._DateTime = _DateTime;
	}

	public int get_OwnerId() {
		return _OwnerId;
	}

	public void set_OwnerId(int _OwnerId) {
		this._OwnerId = _OwnerId;
	}

	public String get_Price() {
		return _Price;
	}

	public void set_Price(String _Price) {
		this._Price = _Price;
	}

	public boolean is_Status() {
		return _Status;
	}

	public void set_Status(boolean _Status) {
		this._Status = _Status;
	}

	public String get_Duedate() {
		return _Duedate;
	}

	public void set_Duedate(String _Duedate) {
		this._Duedate = _Duedate;
	}

	public int get_Csdk() {
		return _Csdk;
	}

	public void set_Csdk(int _Csdk) {
		this._Csdk = _Csdk;
	}

	public int get_Csck() {
		return _Csck;
	}

	public void set_Csck(int _Csck) {
		this._Csck = _Csck;
	}

	public String get_Type() {
		return _Type;
	}

	public void set_Type(String _Type) {
		this._Type = _Type;
	}
	
	

}
