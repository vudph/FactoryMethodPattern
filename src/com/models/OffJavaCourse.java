package com.models;


public class OffJavaCourse extends AbstractCourse {

	public OffJavaCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. Java Core 1");
		System.out.println("  2. Java Core 2");
	}

}
