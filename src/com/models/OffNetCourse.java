package com.models;


public class OffNetCourse extends AbstractCourse {

	public OffNetCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. NET Framework Programming");
	}

}
