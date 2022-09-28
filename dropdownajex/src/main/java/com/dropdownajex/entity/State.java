package com.dropdownajex.entity;

public class State {
	

	private int State_Id;
	 private String Countery_Id;
	 private String State_name;
	 
	 
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public State(int state_Id, String countery_Id, String state_name) {
		super();
		State_Id = state_Id;
		Countery_Id = countery_Id;
		State_name = state_name;
	}
	public int getState_Id() {
		return State_Id;
	}
	public void setState_Id(int state_Id) {
		State_Id = state_Id;
	}
	public String getCountery_Id() {
		return Countery_Id;
	}
	public void setCountery_Id(String countery_Id) {
		Countery_Id = countery_Id;
	}
	public String getState_name() {
		return State_name;
	}
	public void setState_name(String state_name) {
		State_name = state_name;
	}
	@Override
	public String toString() {
		return "State [State_Id=" + State_Id + ", Countery_Id=" + Countery_Id + ", State_name=" + State_name + "]";
	}
	 
	
}
