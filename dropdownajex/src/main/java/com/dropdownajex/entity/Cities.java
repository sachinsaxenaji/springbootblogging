package com.dropdownajex.entity;

public class Cities {
	

	private int City_Id;
	 private String State_id;
	 private String City_name;
	 
	 
	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cities(int city_Id, String state_id, String city_name) {
		super();
		City_Id = city_Id;
		State_id = state_id;
		City_name = city_name;
	}
	public int getCity_Id() {
		return City_Id;
	}
	public void setCity_Id(int city_Id) {
		City_Id = city_Id;
	}
	public String getState_id() {
		return State_id;
	}
	public void setState_id(String state_id) {
		State_id = state_id;
	}
	public String getCity_name() {
		return City_name;
	}
	public void setCity_name(String city_name) {
		City_name = city_name;
	}
	@Override
	public String toString() {
		return "Cities [City_Id=" + City_Id + ", State_id=" + State_id + ", City_name=" + City_name + "]";
	}
	 
	 
	 

}
