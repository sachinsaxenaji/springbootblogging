package com.dropdownajex.entity;

import java.util.Objects;

public class Country {
	
	
	private int Countery_Id;
	 private String Countery_Code;
	 private String Country_name;
	 
	 
	 
	 
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(int countery_Id, String countery_Code, String country_name) {
		super();
		Countery_Id = countery_Id;
		Countery_Code = countery_Code;
		Country_name = country_name;
	}
	
	public int getCountery_Id() {
		return Countery_Id;
	}
	public void setCountery_Id(int countery_Id) {
		Countery_Id = countery_Id;
	}
	public String getCountery_Code() {
		return Countery_Code;
	}
	public void setCountery_Code(String countery_Code) {
		Countery_Code = countery_Code;
	}
	public String getCountry_name() {
		return Country_name;
	}
	public void setCountry_name(String country_name) {
		Country_name = country_name;
	}

	@Override
	public String toString() {
		return "Country [Countery_Id=" + Countery_Id + ", Countery_Code=" + Countery_Code + ", Country_name="
				+ Country_name + "]";
	}
	 
	 

}
