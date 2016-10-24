package com.vnpt.hddt.constants;

public class InvRestURIConstants {
	
	public static final String GET_INV = "rest/inv/{id}";
	
	public static final String GET_INV_FOLLOW_OWNER = "rest/inv/ownerid={ownerId}";
	
	public static final String GET_INV_FOLLOW_PERIOD = "rest/inv/ownerid={ownerId}/from={from}&to={to}";
	
	public static final String GET_INV_FOLLOW_TYPE = "rest/inv/ownerid={ownerId}/type={type}";
	
	public static final String GET_ALL_INV = "rest/allinvs";
	
	public static final String GET_COUNT_INV = "rest/inv/count";
	
	public static final String INSERT_INV = "rest/inv/add";
	
	public static final String UPDATE_INV = "rest/inv/update/{id}";
	
	public static final String DELETE_INV = "rest/inv/delete/{id}";
}
