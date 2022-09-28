package com.dropdownajex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.dropdownajex.entity.Country;

@Service
public class AddDataServiceImpl implements AddDataService {
	

	static {
		 System.out.println("Hello I'm static Service");
		
	}
	
	
	public void fun()
	
	{
		 
	}
	
	
	  public void insert()
	  {
		  
		  HashMap<Integer, String> hashMap = new HashMap<>();
		  hashMap.put(1, "sachin");
		  hashMap.put(2, "kumar");
		  hashMap.put(3, "saxena");
		  hashMap.put(4, "male");
		  
		  
		  for(Entry<Integer, String> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			
			System.out.println("key = "+ key+ "value"+ val);
		}

	  }


	@Override
	public Map<Integer, String> getCountries() {
		List<Country> countries = null;
		Map<Integer, String> countryMap = new HashMap<>();
		
		if(!countries.isEmpty())
		{
			for(Country model: countries)
			{
				countryMap.put(model.getCountery_Id(), model.getCountry_name());
			}
		}
		return countryMap;
		
	}
	
	@Override
	public Map<Integer, String> getCities() {
		// TODO Auto-generated method stub
		List<Country> cities = null;
		Map<Integer, String> cityMap = new HashMap<>();
		
		if(!cities.isEmpty())
		{
			for(Country model: cities)
			{
				cityMap.put(model.getCountery_Id(), model.getCountry_name());
			}
		}
		return cityMap;
	}


	


	@Override
	public Map<Integer, String> getStates() {
		// TODO Auto-generated method stub
		List<Country> country = null;
		Map<Integer, String> stateMap = new HashMap<>();
		
		if(!country.isEmpty())
		{
			for(Country model: country)
			{
				stateMap.put(model.getCountery_Id(), model.getCountry_name());
			}
		}
		return stateMap;
	}


	

}
