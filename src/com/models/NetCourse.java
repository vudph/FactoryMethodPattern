package com.models;


public class NetCourse extends AbstractCourse {

	public NetCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. NET Framework Programming");
	}

}
