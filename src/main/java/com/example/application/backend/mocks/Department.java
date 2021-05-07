package com.example.application.backend.mocks;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("serial")
	public static List<Department> getDepartments() {	
		return new ArrayList<Department>() {
			{
				add(new Department("Product"));
				add(new Department("Service"));
				add(new Department("HR"));
				add(new Department("Account"));
			}
		};
	}
	
	@Override
	public String toString() {
		return name;
	}
}
