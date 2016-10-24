package com.vnpt.hddt.model;

import java.io.Serializable;


public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int _id;
	private String _Name;
	private String _Phone;
	private String _Address;
	private double _Longtitude;
	private double _Latitude;
	private String _CMND;
	private String _Email;
	private String _Password;
	
	public Customer(){};
	
	public Customer(int id, String name, String phone, String address, double longtitude,
			double latitude, String cmnd, String email, String password){
		this._id = id;
		this._Name = name;
		this._Phone = phone;
		this._Address = address;
		this._Longtitude = longtitude;
		this._Latitude = latitude;
		this._CMND = cmnd;
		this._Email = email;
		this._Password = password;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_Name() {
		return _Name;
	}
	public void set_Name(String _Name) {
		this._Name = _Name;
	}
	public String get_Phone() {
		return _Phone;
	}
	public void set_Phone(String _Phone) {
		this._Phone = _Phone;
	}
	public String get_Address() {
		return _Address;
	}
	public void set_Address(String _Address) {
		this._Address = _Address;
	}
	public double get_Longtitude() {
		return _Longtitude;
	}
	public void set_Longtitude(double _Longtitude) {
		this._Longtitude = _Longtitude;
	}
	public double get_Latitude() {
		return _Latitude;
	}
	public void set_Latitude(double _Latitude) {
		this._Latitude = _Latitude;
	}
	public String get_CMND() {
		return _CMND;
	}
	public void set_CMND(String _CMND) {
		this._CMND = _CMND;
	}
	public String get_Email() {
		return _Email;
	}
	public void set_Email(String _Email) {
		this._Email = _Email;
	}
	public String get_Password() {
		return _Password;
	}
	public void set_Password(String _Password) {
		this._Password = _Password;
	}
	
	
}
